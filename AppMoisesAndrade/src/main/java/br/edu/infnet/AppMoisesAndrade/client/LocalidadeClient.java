package br.edu.infnet.AppMoisesAndrade.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import br.edu.infnet.AppMoisesAndrade.model.domain.Estado;
import br.edu.infnet.AppMoisesAndrade.model.domain.Municipio;


@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "localidadeClient")
public interface LocalidadeClient {

    @GetMapping(value = "/estados")
    Collection<Estado> obterEstados();

    @GetMapping(value = "/estados/{uf}/municipios")
    Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}