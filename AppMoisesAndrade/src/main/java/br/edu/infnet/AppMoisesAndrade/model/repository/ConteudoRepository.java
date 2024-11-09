package br.edu.infnet.AppMoisesAndrade.model.repository;

import br.edu.infnet.AppMoisesAndrade.model.domain.Conteudo;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends CrudRepository<Conteudo, Integer> {

    Collection<Conteudo> findAll(Sort by);

}