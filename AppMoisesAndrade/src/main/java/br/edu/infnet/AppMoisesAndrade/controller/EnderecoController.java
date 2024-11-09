package br.edu.infnet.AppMoisesAndrade.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppMoisesAndrade.model.domain.Endereco;
import br.edu.infnet.AppMoisesAndrade.model.domain.Estado;
import br.edu.infnet.AppMoisesAndrade.model.domain.Municipio;
import br.edu.infnet.AppMoisesAndrade.model.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
   
    @GetMapping(value = "/endereco/{cep}")
    public Endereco findByCep(@PathVariable String cep) {
        return enderecoService.obterPorCep(cep);
    }

    @GetMapping(value = "/estados")
    public Collection<Estado> obterEstados() {
        return enderecoService.obterEstados();
    }
    

    @GetMapping(value = "/municipios/{uf}")
    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf) {
        return enderecoService.obterMunicipios(uf);
    }
}