package br.edu.infnet.AppMoisesAndrade.controller;

import br.edu.infnet.AppMoisesAndrade.model.domain.Avaliacao;
import br.edu.infnet.AppMoisesAndrade.model.service.AvaliacaoService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping(value = "/avaliacao")
    public Iterable<Avaliacao> listarTodos() {
        return avaliacaoService.obterLista();
    }

    @GetMapping(value = "/avaliacao/{id}")
    public Avaliacao obterPorId(@PathVariable Integer id) {
        return avaliacaoService.obterPorId(id);
    }

    @PostMapping(value = "/avaliacao")
    public Avaliacao incluir(@RequestBody Avaliacao avaliacao) {
        avaliacaoService.incluir(avaliacao);
        return avaliacao;
    }

    @DeleteMapping(value = "/avaliacao/{id}")
    public String remover(@PathVariable Integer id) {
        avaliacaoService.remover(id);
        return "Elemento id \"" + id + "\" foi removido com sucesso!";
    }

    @GetMapping(value = "/avaliacao/nota/{nota}")
    public Collection<Avaliacao> obterListaPorNota(@PathVariable float nota) {
        return avaliacaoService.obterListaPorNota(nota);
    }

    @GetMapping(value = "/avaliacao/cliente/{id}")
    public Collection<Avaliacao> obterPorClienteId(@PathVariable Integer id) {
        return avaliacaoService.obterListaPorClienteId(id);
    }

    @GetMapping(value = "/avaliacao/conteudo/{id}")
    public Collection<Avaliacao> obterPorConteudoId(@PathVariable Integer id) {
        return avaliacaoService.obterListaPorConteudoId(id);
    }
}
