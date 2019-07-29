package br.com.solutis.gamechanger.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.List;


public class OnboardingRequest {

    @NotNull(message = "O campo data deve ser preenchido")
    private LocalDate data;

    @NotNull(message = "O campo nome deve ser preenchido")
    private String nome;

    private List<DeclaracaoRequest> declaracoes;

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

    public List<DeclaracaoRequest> getDeclaracoes() {
        return declaracoes;
    }

    public void setDeclaracoes(List<DeclaracaoRequest> declaracoes) {
        this.declaracoes = declaracoes;
    }
}
