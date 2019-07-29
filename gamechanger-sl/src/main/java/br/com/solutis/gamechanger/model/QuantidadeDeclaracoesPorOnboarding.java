package br.com.solutis.gamechanger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

public class QuantidadeDeclaracoesPorOnboarding {

    private Long id;

    private LocalDate data;

    private String nome;

    private Long quantidadeDeclaracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuantidadeDeclaracoesPorOnboarding() {
    }


    public QuantidadeDeclaracoesPorOnboarding(Long id, LocalDate data, String nome, Long quantidadeDeclaracao) {
        this.id = id;
        this.data = data;
        this.nome = nome;
        this.quantidadeDeclaracao = quantidadeDeclaracao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidadeDeclaracao() {
        return quantidadeDeclaracao;
    }

    public void setQuantidadeDeclaracao(Long quantidadeDeclaracao) {
        this.quantidadeDeclaracao = quantidadeDeclaracao;
    }
}
