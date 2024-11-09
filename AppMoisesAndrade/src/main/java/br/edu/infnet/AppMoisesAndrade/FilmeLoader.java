package br.edu.infnet.AppMoisesAndrade;

import br.edu.infnet.AppMoisesAndrade.model.domain.Avaliacao;
import br.edu.infnet.AppMoisesAndrade.model.domain.Filme;
import br.edu.infnet.AppMoisesAndrade.model.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@Component
@Order(3)
public class FilmeLoader implements ApplicationRunner {

    @Autowired
    private FilmeService filmeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Resource resource = new ClassPathResource("files/filme.txt");
        FileReader file = new FileReader(resource.getFile());
        BufferedReader data = new BufferedReader(file);

        String linha = data.readLine();
        String[] campos = null;

        while(linha != null) {

            campos = linha.split(";");

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setId(Integer.valueOf(campos[5]));

            Filme filme = new Filme();
            filme.setTitulo(campos[0]);
            filme.setGenero(campos[1]);
            filme.setAnolancamento(Integer.valueOf(campos[2]));
            filme.setDuracao(Integer.valueOf(campos[3]));
            filme.getOscar().addAll(List.of(campos[4].split(",")));
            filme.setAvaliacoes(List.of(avaliacao));

            filmeService.incluir(filme);

            linha = data.readLine();
        }

        data.close();
        
        for(Filme f : filmeService.obterLista()) {
            System.out.println("[FILME] " + f);
        }

    }
}
