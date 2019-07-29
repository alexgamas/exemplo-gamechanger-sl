package br.com.solutis.gamechanger.model;

import javax.validation.constraints.NotNull;

public class DeclaracaoRequest {

    @NotNull(message = "O campo Id deve ser preenchido")
    private Long id;

    @NotNull(message = "O campo valor deve ser preenchido")
    private Boolean valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }
}
