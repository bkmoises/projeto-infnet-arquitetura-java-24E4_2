package br.edu.infnet.AppMoisesAndrade;

import br.edu.infnet.AppMoisesAndrade.model.domain.Avaliacao;
import br.edu.infnet.AppMoisesAndrade.model.domain.Cliente;
import br.edu.infnet.AppMoisesAndrade.model.domain.Conteudo;
import br.edu.infnet.AppMoisesAndrade.model.service.AvaliacaoService;
import br.edu.infnet.AppMoisesAndrade.model.service.ClienteService;
import br.edu.infnet.AppMoisesAndrade.model.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


@Component
@Order(4)
public class AvaliacaoLoader implements ApplicationRunner {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ConteudoService conteudoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Resource resource = new ClassPathResource("files/avaliacao.txt");
        FileReader file = new FileReader(resource.getFile());
        BufferedReader data = new BufferedReader(file);

        String linha = data.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Cliente cliente = clienteService.obterPorId(Integer.valueOf(campos[2]));

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setNota(Float.valueOf(campos[0]));
            avaliacao.setComentario(campos[1]);
            avaliacao.setCliente(cliente);

            Conteudo conteudo = conteudoService.obterPorId(Integer.valueOf(campos[3]));
            avaliacao.setConteudo(conteudo);

            avaliacaoService.incluir(avaliacao);

            linha = data.readLine();
        }
        
        data.close();

        for (Avaliacao avaliacao : avaliacaoService.obterLista()) {
            System.out.println("[AVALIACAO] " + avaliacao);
        }
    }

}
