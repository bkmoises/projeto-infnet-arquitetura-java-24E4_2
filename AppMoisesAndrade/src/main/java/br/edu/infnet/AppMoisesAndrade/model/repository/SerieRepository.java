package br.edu.infnet.AppMoisesAndrade.model.repository;

import br.edu.infnet.AppMoisesAndrade.model.domain.Serie;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Integer> {
    
    Collection<Serie> findAll(Sort by);

    Collection<Serie> findByTituloContaining(String titulo);

    Collection<Serie> findByGenero(String genero);
}