package br.edu.infnet.AppMoisesAndrade.model.repository;

import br.edu.infnet.AppMoisesAndrade.model.domain.Cliente;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Cliente findByCpf(String cpf);

    Collection<Cliente> findByNomeContaining(String nome);

    Collection<Cliente> findByAssinanteTrue();

    Collection<Cliente> findAll(Sort by);
}