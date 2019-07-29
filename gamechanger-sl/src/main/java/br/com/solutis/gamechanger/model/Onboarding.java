package br.com.solutis.gamechanger.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "onboarding")
public class Onboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "data_evento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEvento;

    @Column(name = "nome_projeto", nullable = false)
    private String nomeProjeto;


    @ManyToMany
    @JoinTable(
            name="onboarding_declaracao",
            joinColumns=@JoinColumn(name="id_onboarding", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id_declaracao", referencedColumnName="id"))
    private List<Declaracao> declaracoes;

    public Onboarding() {
    }

    public Onboarding(OnboardingRequest request) {

        this.setNomeProjeto(request.getNome());
        this.setDataEvento(request.getData());

        List<DeclaracaoRequest> rDec = request.getDeclaracoes();

        if (rDec != null && rDec.size() > 0) {
            this.declaracoes = rDec.stream().map((rd -> {
                Declaracao declaracao = new Declaracao();
                declaracao.setId(rd.getId());
                return declaracao;
            })).collect(Collectors.toList());
        }


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public List<Declaracao> getDeclaracoes() {
        return declaracoes;
    }

    public void setDeclaracoes(List<Declaracao> declaracoes) {
        this.declaracoes = declaracoes;
    }
}
