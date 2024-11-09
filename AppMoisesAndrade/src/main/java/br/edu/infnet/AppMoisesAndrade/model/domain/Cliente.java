package br.edu.infnet.AppMoisesAndrade.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TCliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "O campo cpf é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF fornecido é invalido")
    private String cpf;

    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "O email fornecido é invalido")
    private String email;

    @NotNull(message = "O campo data de nascimento é obrigatório")
    private Date dataNascimento;

    private Boolean assinante;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "cliente")
    @JsonManagedReference
    private List<Avaliacao> avaliacoes;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getAssinante() {
        return assinante;
    }

    public void setAssinante(Boolean assinante) {
        this.assinante = assinante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", assinante='" + (assinante == true ? "'Sim'" : "'Não'") + '\'' +
                ", cep='" + endereco.getCep() + '\'' +
                '}';
    }
}