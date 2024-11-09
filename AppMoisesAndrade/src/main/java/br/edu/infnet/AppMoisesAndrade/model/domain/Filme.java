package br.edu.infnet.AppMoisesAndrade.model.domain;

import br.edu.infnet.AppMoisesAndrade.ListToStringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TFilme")
public class Filme extends Conteudo {
    @Convert(converter = ListToStringConverter.class)
    private List<String> oscar;

    public Filme() {
        oscar = new ArrayList<String>();
    }

    public List<String> getOscar() {
        return oscar;
    }

    public void setOscar(List<String> oscar) {
        this.oscar = oscar;
    }

    @Override
    public String toString() {
        return "Filme{" + super.toString() + '\'' +
                ", oscar='Qtd: " + oscar.size() + "', '" + oscar + '\'' +
                '}';
    }
}
