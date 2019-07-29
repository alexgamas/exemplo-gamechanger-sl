package br.com.solutis.gamechanger.repository;

import br.com.solutis.gamechanger.model.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;


// https://stackoverflow.com/questions/45403857/extend-simplejparepository
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories

public interface OnboardingRepository extends JpaRepository<Onboarding, Integer>, OnboardingRepositoryCustom {

//    BigDecimal sumValorPrincipalPorPeriodo(@Param("dataStart") LocalDate dataStart, @Param("dataEnd") LocalDate dataEnd);

    @Query("select count(o.id) from Onboarding o")
    Long getQuantidadeOnboarding();


    @Query("select count(o.id) from Onboarding o where o.dataEvento between :dataStart and :dataEnd")
    Long getQuantidadeOnboardingNoPeriodo(@Param("dataStart") LocalDate dataStart, @Param("dataEnd") LocalDate dataEnd);

}