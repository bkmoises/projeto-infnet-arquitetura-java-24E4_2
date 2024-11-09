package br.edu.infnet.AppMoisesAndrade.model.service;

import br.edu.infnet.AppMoisesAndrade.model.domain.Serie;
import br.edu.infnet.AppMoisesAndrade.model.repository.SerieRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public void incluir(Serie serie) {
        try {
            serieRepository.save(serie);
        } catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    public Iterable<Serie> obterLista(){
        return serieRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
    }

    public Serie obterPorId(Integer id) {
        return serieRepository.findById(id).orElse(null);
    }

    public void  remover(Integer id) {
        serieRepository.deleteById(id);
    }

    public Long obterQtd() {
        return serieRepository.count();
    }

        public Collection<Serie> obterListaPorTitulo(String titulo) {
        return serieRepository.findByTituloContaining(titulo);
    }

    public Collection<Serie> obterListaPorGenero(String genero) {
        return serieRepository.findByGenero(genero);
    }
}
