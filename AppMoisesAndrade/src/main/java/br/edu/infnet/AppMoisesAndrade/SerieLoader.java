package br.edu.infnet.AppMoisesAndrade;

import br.edu.infnet.AppMoisesAndrade.model.domain.Avaliacao;
import br.edu.infnet.AppMoisesAndrade.model.domain.Serie;
import br.edu.infnet.AppMoisesAndrade.model.service.SerieService;
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
@Order(2)
public class SerieLoader implements ApplicationRunner {

    @Autowired
    private SerieService serieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Resource resource = new ClassPathResource("files/serie.txt");
        FileReader file = new FileReader(resource.getFile());
        BufferedReader data = new BufferedReader(file);

        String linha = data.readLine();
        String[] campos = null;

        while(linha != null) {

            campos = linha.split(";");

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setId(Integer.valueOf(campos[6]));

            Serie serie = new Serie();
            serie.setTitulo(campos[0]);
            serie.setGenero(campos[1]);
            serie.setAnolancamento(Integer.valueOf(campos[2]));
            serie.setDuracao(Integer.valueOf(campos[3]));
            serie.setTemporada(Integer.valueOf(campos[4]));
            serie.setEpisodio(Integer.valueOf(campos[5]));
            serie.setAvaliacoes(Arrays.asList(avaliacao));

            serieService.incluir(serie);

            linha = data.readLine();
        }

        data.close();

        for(Serie s : serieService.obterLista()) {
            System.out.println("[SÉRIE] " + s);
        }
    }
}