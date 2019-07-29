package br.com.solutis.gamechanger.repository;

import br.com.solutis.gamechanger.model.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> { }
