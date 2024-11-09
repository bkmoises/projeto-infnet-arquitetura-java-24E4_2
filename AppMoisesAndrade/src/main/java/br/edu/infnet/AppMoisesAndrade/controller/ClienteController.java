package br.edu.infnet.AppMoisesAndrade.controller;

import br.edu.infnet.AppMoisesAndrade.model.domain.Cliente;
import br.edu.infnet.AppMoisesAndrade.model.service.ClienteService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/cliente")
    public Iterable<Cliente> listarTodos() {
        return clienteService.obterLista();
    }

    @GetMapping(value = "/cliente/{id}")
    public Cliente obterPorId(@PathVariable Integer id) {
        return clienteService.obterPorId(id);
    }

    @PostMapping(value = "/cliente")
    public Cliente incluir(@RequestBody Cliente cliente) {
        clienteService.incluir(cliente);
        return cliente;
    }

    @DeleteMapping(value = "/cliente/{id}")
    public String remover(@PathVariable Integer id) {
        clienteService.remover(id);
        return "Elemento id \"" + id + "\" foi removido com sucesso!";
    }

    @GetMapping(value = "/cliente/cpf/{cpf}")
    public Cliente obterPorCpf(@PathVariable String cpf) {
        return clienteService.obterPorCpf(cpf);
    }

    @GetMapping(value = "/cliente/nome/{nome}")
    public Collection<Cliente> obterListaPorNome(@PathVariable String nome) {
        return clienteService.obterListaPorNome(nome);
    }

    @GetMapping(value = "/cliente/assinante/")
    public Collection<Cliente> obterListaPorAssinante() {
        return clienteService.obterListaPorAssinante();
    }
}
