package br.edu.infnet.AppMoisesAndrade.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "TSerie")
public class Serie extends Conteudo {

    @Min(value = 1, message = "O valor de temporada não pode ser menor que 1")
    private int temporada;

    @Min(value = 1, message = "O valor de episodio não pode ser menor que 1")
    private int episodio;

    public Serie() {

    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    @Override
    public String toString() {
        return "Serie{" + super.toString() +
                ", temporada='" + temporada + '\''+
                ", episodio='" + episodio + '\'' +
                '}';
    }
}
