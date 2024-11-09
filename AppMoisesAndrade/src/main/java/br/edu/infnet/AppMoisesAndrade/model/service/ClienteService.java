package br.edu.infnet.AppMoisesAndrade.model.service;

import br.edu.infnet.AppMoisesAndrade.model.domain.Cliente;
import br.edu.infnet.AppMoisesAndrade.model.repository.ClienteRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void incluir(Cliente cliente) {
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    public Iterable<Cliente> obterLista(){
        return clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Cliente obterPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void  remover(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Long obterQtd() {
        return clienteRepository.count();
    }

    public Cliente obterPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public Collection<Cliente> obterListaPorNome(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    public Collection<Cliente> obterListaPorAssinante() {
        return clienteRepository.findByAssinanteTrue();
    }
}
