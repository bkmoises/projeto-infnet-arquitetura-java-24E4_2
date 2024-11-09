package br.edu.infnet.AppMoisesAndrade.model.service;

import br.edu.infnet.AppMoisesAndrade.model.domain.Filme;
import br.edu.infnet.AppMoisesAndrade.model.repository.FilmeRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void incluir(Filme filme) {
        try {
            filmeRepository.save(filme);
        } catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    public Iterable<Filme> obterLista(){
        return filmeRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
    }

    public Filme obterPorId(Integer id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public void  remover(Integer id) {
        filmeRepository.deleteById(id);
    }

    public Long obterQtd() {
        return filmeRepository.count();
    }

    public Collection<Filme> obterListaPorTitulo(String titulo) {
        return filmeRepository.findByTituloContaining(titulo);
    }

    public Collection<Filme> obterListaPorGenero(String genero) {
        return filmeRepository.findByGenero(genero);
    }
}
