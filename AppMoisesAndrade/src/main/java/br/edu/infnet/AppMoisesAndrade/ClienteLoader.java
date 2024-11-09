package br.edu.infnet.AppMoisesAndrade;

import br.edu.infnet.AppMoisesAndrade.model.domain.Cliente;
import br.edu.infnet.AppMoisesAndrade.model.domain.Endereco;
import br.edu.infnet.AppMoisesAndrade.model.service.ClienteService;
import br.edu.infnet.AppMoisesAndrade.model.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

@Component
@Order(1)
public class ClienteLoader implements ApplicationRunner {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Resource resource = new ClassPathResource("files/cliente.txt");
        FileReader file = new FileReader(resource.getFile());
        BufferedReader data = new BufferedReader(file);

        String linha = data.readLine();
        String[] campos = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");

        while(linha != null) {
            campos = linha.split(";");

            Endereco endereco = enderecoService.obterPorCep(campos[5]);

            System.err.print(endereco);

            Cliente cliente = new Cliente();

            cliente.setNome(campos[0]);
            cliente.setCpf(campos[1]);
            cliente.setEmail(campos[2]);
            cliente.setDataNascimento(dateFormat.parse(campos[3]));
            cliente.setAssinante(Boolean.valueOf(campos[4]));
            cliente.setEndereco(endereco);

            clienteService.incluir(cliente);

            linha = data.readLine();
        }
        
        data.close();

        for(Cliente cliente : clienteService.obterLista()) {
            System.out.println("[CLIENTE] " + cliente);
        }

    }
}
