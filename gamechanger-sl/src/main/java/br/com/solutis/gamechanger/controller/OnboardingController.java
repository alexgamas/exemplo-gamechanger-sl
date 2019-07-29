package br.com.solutis.gamechanger.controller;


import br.com.solutis.gamechanger.model.Onboarding;
import br.com.solutis.gamechanger.model.OnboardingRequest;
import br.com.solutis.gamechanger.model.QuantidadeDeclaracoesPorOnboarding;
import br.com.solutis.gamechanger.service.OnboardingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/onboarding")
public class OnboardingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingController.class);

    @Autowired
    public OnboardingService service;

    @GetMapping()
    public List<QuantidadeDeclaracoesPorOnboarding> getQuantidadeDeclaracoesPorOnboarding() {
        return service.getQuantidadeDeclaracoesPorOnboarding(Optional.ofNullable(null));
    }

    @PutMapping()
    public void salvarOnboarding(@Valid @RequestBody OnboardingRequest request) {
        service.salvarOnboarding(request);
    }

    @GetMapping("{onboardingId}")
    public List<QuantidadeDeclaracoesPorOnboarding> getQuantidadeDeclaracoesPorOnboardingEspecifico(@PathVariable(value = "onboardingId") Long onboardingId) {
        return service.getQuantidadeDeclaracoesPorOnboarding(Optional.of(onboardingId));
    }

    @GetMapping("/details")
    public List<Onboarding> getAll() {
        return service.getAll();
    }



//    @GetMapping()
//    public List<Declaracao> getAll() {
//        LOGGER.trace("Obtendo declarações");
//        return service.getAll();
//    }

}
