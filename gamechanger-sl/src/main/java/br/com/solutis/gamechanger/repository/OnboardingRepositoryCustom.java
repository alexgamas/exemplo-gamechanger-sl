package br.com.solutis.gamechanger.repository;

import br.com.solutis.gamechanger.model.QuantidadeDeclaracoesPorOnboarding;

import java.util.List;
import java.util.Optional;

public interface OnboardingRepositoryCustom {

    List<QuantidadeDeclaracoesPorOnboarding> getQuantidadeDeclaracoesPorOnboarding(Optional<Long> onboardingId);

}