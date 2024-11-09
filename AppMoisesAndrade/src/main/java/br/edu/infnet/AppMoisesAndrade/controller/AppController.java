package br.edu.infnet.AppMoisesAndrade.controller;

import br.edu.infnet.AppMoisesAndrade.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FilmeService filmeService;
    @Autowired
    private SerieService serieService;
    @Autowired
    private AvaliacaoService avaliacaoService;
    @Autowired
    private ConteudoService conteudoService;

    @GetMapping(value = "/")
    public String showHome(Model model) {
        model.addAttribute("qtdCliente", clienteService.obterQtd());
        model.addAttribute("qtdFilme", filmeService.obterQtd());
        model.addAttribute("qtdSerie", serieService.obterQtd());
        model.addAttribute("qtdAvaliacao", avaliacaoService.obterQtd());
        model.addAttribute("qtdConteudo", conteudoService.obterQtd());

        return "index";
    }

    @GetMapping(value = "/cliente/list")
    public String listarCliente(Model model) {

        model.addAttribute("titulo", "Lista de Clientes");
        model.addAttribute("listagem", clienteService.obterLista());

        return showHome(model);
    }

    @GetMapping(value = "/filme/list")
    public String listarFilme(Model model) {

        model.addAttribute("titulo", "Lista de Filmes");
        model.addAttribute("listagem", filmeService.obterLista());

        return showHome(model);
    }

    @GetMapping(value = "/serie/list")
    public String listarSerie(Model model) {

        model.addAttribute("titulo", "Lista de Série");
        model.addAttribute("listagem", serieService.obterLista());

        return showHome(model);
    }

    @GetMapping(value = "/avaliacao/list")
    public String listarAvaliacao(Model model) {

        model.addAttribute("titulo", "Lista de Avaliações");
        model.addAttribute("listagem", avaliacaoService.obterLista());

        return showHome(model);
    }

    @GetMapping(value = "/conteudo/list")
    public String listarConteudo(Model model) {

        model.addAttribute("titulo", "Lista de Conteúdos");
        model.addAttribute("listagem", conteudoService.obterLista());

        return showHome(model);
    }

}
