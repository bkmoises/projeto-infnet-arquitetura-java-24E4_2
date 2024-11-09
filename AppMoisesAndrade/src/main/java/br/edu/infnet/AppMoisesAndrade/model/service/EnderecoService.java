package br.edu.infnet.AppMoisesAndrade.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import br.edu.infnet.AppMoisesAndrade.client.EnderecoClient;
import br.edu.infnet.AppMoisesAndrade.client.LocalidadeClient;
import br.edu.infnet.AppMoisesAndrade.model.domain.Endereco;
import br.edu.infnet.AppMoisesAndrade.model.domain.Estado;
import br.edu.infnet.AppMoisesAndrade.model.domain.Municipio;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoClient enderecoClient;

	@Autowired
	private LocalidadeClient localidadeClient;

	public Endereco obterPorCep(String cep) {
		return enderecoClient.findByCep(cep);
	}

	public Collection<Estado> obterEstados() {
		return localidadeClient.obterEstados();
	}

	public Collection<Municipio> obterMunicipios(Integer uf) {
		return localidadeClient.obterMunicipios(uf);
	}

}
