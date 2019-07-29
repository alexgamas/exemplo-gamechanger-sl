package br.com.solutis.gamechanger;

import br.com.solutis.gamechanger.model.Declaracao;
import br.com.solutis.gamechanger.service.DeclaracaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamechangerApplicationTest {

    @Autowired
    private DeclaracaoService declaracaoService;


    public Long novaDeclaracao() {

        Declaracao declaracao = declaracaoService.save("Declaração de teste");
        Assert.assertNotNull("Declaração tem que ser devolvida pelo método", declaracao);
        Assert.assertNotNull("Declaração tem que ser devolvida pelo método com o Id preenchido", declaracao.getId());
        Assert.assertNotNull("Declaração tem que ser devolvida pelo método com a descrição preenchida", declaracao.getDescricao());

        return declaracao.getId();

    }

    public void obterUmaDeclaracoesTest(Long id) {
        Declaracao declaracao = declaracaoService.getOne(id);
        Assert.assertNotNull("Temos que ter declaraçoes no banco", declaracao);
        Assert.assertNotNull("Declaração tem que ser devolvida pelo método com o Id preenchido", declaracao.getId());
        Assert.assertNotNull("Declaração tem que ser devolvida pelo método com a descrição preenchida", declaracao.getDescricao());
    }

    @Test
    public void obterDeclaracoesTest() {
        List<Declaracao> declaracaoList = declaracaoService.getAll();
        Assert.assertNotNull("Temos que ter declaraçoes no banco", declaracaoList);
    }

    @Test
    public void novaDeclaracoesTest() {
        Long declaracaoId = novaDeclaracao();
        obterUmaDeclaracoesTest(declaracaoId);
    }

    @Test(expected = HttpClientErrorException.class)
    public void falhaAoObterUmaDeclaracoesTest() {
        Declaracao declaracao = declaracaoService.getOne(Long.MAX_VALUE);
    }




}
