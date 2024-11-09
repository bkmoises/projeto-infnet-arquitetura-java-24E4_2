package br.edu.infnet.AppMoisesAndrade.controller;

import br.edu.infnet.AppMoisesAndrade.model.domain.Filme;
import br.edu.infnet.AppMoisesAndrade.model.service.FilmeService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping(value = "/filme")
    public Iterable<Filme> listarTodos() {
        return filmeService.obterLista();
    }

    @GetMapping(value = "/filme/{id}")
    public Filme obterPorId(@PathVariable Integer id) {
        return filmeService.obterPorId(id);
    }

    @PostMapping(value = "/filme")
    public Filme incluir(@RequestBody Filme filme) {
        filmeService.incluir(filme);
        return filme;
    }

    @DeleteMapping(value = "/filme/{id}")
    public String remover(@PathVariable Integer id) {
        filmeService.remover(id);
        return "Elemento id \"" + id + "\" foi removido com sucesso!";
    }

    @GetMapping(value = "/filme/titulo/{titulo}")
    public Collection<Filme> obterListaPorTitulo(@PathVariable String titulo) {
        return filmeService.obterListaPorTitulo(titulo);
    }

    @GetMapping(value = "/filme/genero/{genero}")
    public Collection<Filme> obterListaPorGenero(@PathVariable String genero) {
        return filmeService.obterListaPorGenero(genero);
    }

}
