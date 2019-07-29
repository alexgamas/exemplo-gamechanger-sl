package br.com.solutis.gamechanger.service;

import br.com.solutis.gamechanger.model.Declaracao;
import br.com.solutis.gamechanger.repository.DeclaracaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class DeclaracaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeclaracaoService.class);

    @Autowired
    public DeclaracaoRepository repository;

    public List<Declaracao> getAll() {
        LOGGER.debug("Obtendo declarações");
        return repository.findAll();
    }

    public Declaracao save(String descricao) {
        LOGGER.debug("Salvando declaracao");
        Declaracao declaracao = new Declaracao();
        declaracao.setDescricao(descricao);
        return repository.save(declaracao);
    }

    public Declaracao getOne(Long id) {
        LOGGER.debug("Getting declaracao id: {}", id);
        Optional<Declaracao> declaracao = repository.findById(id);

        if (declaracao.isPresent()){
            return declaracao.get();
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);

    }

}