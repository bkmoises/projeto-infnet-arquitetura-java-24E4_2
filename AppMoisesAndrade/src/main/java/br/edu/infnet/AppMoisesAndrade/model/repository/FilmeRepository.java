package br.edu.infnet.AppMoisesAndrade.model.repository;

import br.edu.infnet.AppMoisesAndrade.model.domain.Filme;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

    Collection<Filme> findAll(Sort by);

    Collection<Filme> findByTituloContaining(String titulo);

    Collection<Filme> findByGenero(String genero);
}