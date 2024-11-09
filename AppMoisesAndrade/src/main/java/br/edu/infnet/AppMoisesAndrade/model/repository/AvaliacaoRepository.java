package br.edu.infnet.AppMoisesAndrade.model.repository;

import br.edu.infnet.AppMoisesAndrade.model.domain.Avaliacao;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Integer> {

    Collection<Avaliacao> findByNota(float nota);

    Collection<Avaliacao> findByClienteId(Integer id);

    Collection<Avaliacao> findByConteudoId(Integer id);

    Collection<Avaliacao> findAll(Sort by);
}