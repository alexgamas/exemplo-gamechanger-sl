package br.com.solutis.gamechanger.repository;

import br.com.solutis.gamechanger.model.Onboarding;
import br.com.solutis.gamechanger.model.QuantidadeDeclaracoesPorOnboarding;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class OnboardingRepositoryImpl implements OnboardingRepositoryCustom {

    // Fonte: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/restricting-query-results.html

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<QuantidadeDeclaracoesPorOnboarding> getQuantidadeDeclaracoesPorOnboarding(Optional<Long> onboardingId) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();

        CriteriaQuery<QuantidadeDeclaracoesPorOnboarding> criteria = builder.createQuery(QuantidadeDeclaracoesPorOnboarding.class);

        Root<Onboarding> root = criteria.from(Onboarding.class);

        Join declaracao = root.join("declaracoes", JoinType.LEFT);

        Expression<String> idColumn = root.get("id");
        Expression<LocalDate> dataEventoColumn = root.get("dataEvento");
        Expression<String> nomeProjetoColumn = root.get("nomeProjeto");

        criteria.select(builder.construct(QuantidadeDeclaracoesPorOnboarding.class,
                idColumn, dataEventoColumn, nomeProjetoColumn,
                builder.count(declaracao.get("id"))
        ));

        criteria.groupBy(Arrays.asList(idColumn, dataEventoColumn, nomeProjetoColumn));

        if (onboardingId.isPresent()) {
            criteria.where(builder.equal(idColumn, onboardingId.get()));
        }

        //criteria.groupBy(idColumn);

        TypedQuery<QuantidadeDeclaracoesPorOnboarding> query = em.createQuery(criteria);

        return query.getResultList();

    }

}