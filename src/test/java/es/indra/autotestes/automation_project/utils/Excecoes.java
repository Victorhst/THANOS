package es.indra.autotestes.automation_project.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;

/**
 * Classe para tratamento de exce��es java e erros de assert do JUnit.
 *
 * @author victor.teixeira@receita.pb.gov.br
 * @author vhsilvat@indracompany.com
 */
public final class Excecoes extends PageObject {

    private Excecoes(Throwable e) {

        if (e instanceof Error) {

            tratarErro(e);

        } else if (e instanceof Exception) {

            tratarExcecao(e);
        }

    }

    public static Excecoes tratarExcecoes(Throwable e) {

        return new Excecoes(e);
    }

    private void tratarExcecao(Throwable e) {

        String url = getDriver().getCurrentUrl();
        if (url.contains(
                "message=N%C3%A3o+foi+poss%C3%ADvel+executar+o+servi%C3%A7o"
                        + "+solicitado.")) {
            throw new NoSuchElementException(Mensagens.ACESSO_NAO_PERMITIDO,
                    e.fillInStackTrace());

        }

        throw new NoSuchElementException(e.getMessage(), e.fillInStackTrace());
    }

    private void tratarErro(Throwable e) {

        throw new AssertionError(e.getMessage(), e.fillInStackTrace());
    }

}
