package br.edu.infnet.AppMoisesAndrade;

import br.edu.infnet.AppMoisesAndrade.model.domain.Estado;
import br.edu.infnet.AppMoisesAndrade.model.domain.Municipio;
import br.edu.infnet.AppMoisesAndrade.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class LocalidadeLoader implements ApplicationRunner {

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for(Estado e: enderecoService.obterEstados()) {
            System.out.println("[ESTADO] " + e);
        }


        System.out.println("*** São Paulo *** ");

        for(Municipio m : enderecoService.obterMunicipios(35)) {
            System.out.println("[MUNICIPIO] " + m);
        }
    }
}
