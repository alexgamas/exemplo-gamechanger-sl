package br.com.solutis.gamechanger.controller;


import br.com.solutis.gamechanger.model.Declaracao;
import br.com.solutis.gamechanger.service.DeclaracaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/declaracao")
public class DeclaracaoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeclaracaoController.class);

    @Autowired
    public DeclaracaoService service;

    @GetMapping()
    public List<Declaracao> getAll() {
        LOGGER.debug("Obtendo declarações");
        return service.getAll();
    }
}
