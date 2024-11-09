package br.edu.infnet.AppMoisesAndrade.model.service;

import br.edu.infnet.AppMoisesAndrade.model.domain.Avaliacao;
import br.edu.infnet.AppMoisesAndrade.model.repository.AvaliacaoRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public void incluir(Avaliacao avaliacao) {
        try {
            avaliacaoRepository.save(avaliacao);
        } catch (Exception e) {
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    public Iterable<Avaliacao> obterLista(){
        return avaliacaoRepository.findAll(Sort.by(Sort.Direction.DESC, "nota"));
    }

    public Avaliacao obterPorId(Integer id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public void  remover(Integer id) {
        avaliacaoRepository.deleteById(id);
    }

    public long obterQtd() {
        return avaliacaoRepository.count();
    }

    public Collection<Avaliacao> obterListaPorNota(float nota) {
        return avaliacaoRepository.findByNota(nota);
    }

    public Collection<Avaliacao> obterListaPorClienteId(Integer id) {
        return avaliacaoRepository.findByClienteId(id);
    }

    public Collection<Avaliacao> obterListaPorConteudoId(Integer id) {
        return avaliacaoRepository.findByConteudoId(id);
    }
}
