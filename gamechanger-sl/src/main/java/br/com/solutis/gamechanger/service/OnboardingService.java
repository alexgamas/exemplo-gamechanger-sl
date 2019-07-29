package br.com.solutis.gamechanger.service;

import br.com.solutis.gamechanger.model.Onboarding;
import br.com.solutis.gamechanger.model.OnboardingRequest;
import br.com.solutis.gamechanger.model.QuantidadeDeclaracoesPorOnboarding;
import br.com.solutis.gamechanger.repository.OnboardingRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OnboardingService {

    @Autowired
    public OnboardingRepository repository;

    public List<Onboarding> getAll() {
        return repository.findAll();
    }

    public List<QuantidadeDeclaracoesPorOnboarding> getQuantidadeDeclaracoesPorOnboarding(Optional<Long> onboardingId) {

        return repository.getQuantidadeDeclaracoesPorOnboarding(onboardingId);

    }

    public void salvarOnboarding(OnboardingRequest request) {

        Onboarding onboarding = new Onboarding(request);
        repository.save(onboarding);

    }
}