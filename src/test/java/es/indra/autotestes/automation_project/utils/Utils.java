package es.indra.autotestes.automation_project.utils;

import net.serenitybdd.core.pages.FluentDropdownSelect;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 * Classe utilitária em conjunto com as properties. Define paths e configurações
 * gerais necessárias para os testes automatizados.
 *
 * @author victor.teixeira@receita.pb.gov.br
 * @author vhsilvat@indracompany.com
 */
public final class Utils extends PageObject {

    // TODO montar uma funcao lambda que retorne
    private static final Map<Atores, Supplier<String>> Usuarios = new HashMap<>();

    FluentDropdownSelect gerencias;

    private Utils() {
    }

    public void teste(WebElementFacade combobox) {

        gerencias = new FluentDropdownSelect(combobox);

        for (WebElement opcao : gerencias.getOptions()) {

            // TODO retornar a opção desejada como WebElement, conforme a gerência
            //  informada pelo ENUM
        }
    }

    /**
     * Bloco de código que identifica o checkbox a ser selecionado usando
     * o cpf previamente informado como parametro
     * <p>
     * findElements(By.tagName("tr"))
     * forEach(tr) -> findElements(By.tagName("td"))
     * forEach(td) -> getString(cpf)
     */
    public WebElement identificarElemento(String nrProtocolo, WebElement elemento) {

        WebElement parecer = elemento;
        List<WebElement> tabela = getDriver().findElements(By.tagName("tr"));

        for (int i = 0; i < tabela.size(); i++) {

            List<WebElement> conteudo = tabela.get(i)
                    .findElements(By.tagName("td"));

            for (WebElement coluna : conteudo) {

                if (coluna.getText().contains(nrProtocolo)) {

                    StringBuilder xpath = new StringBuilder();

                    xpath.append("//tr[")
                            .append(i)
                            .append("]//td[1]//input[1]");

                    parecer = tabela.get(i)
                            .findElement(By.xpath(xpath.toString()));

                } // if
            } // for-each(coluna)
        } // for-each(linha)

        return parecer;
    }

    public List<By> identificarDocumentoObrigatorio() {

        List<By> anexadores = new ArrayList<>();
        List<WebElement> tabela = getDriver().findElements(By.tagName("tr"));

        for (int i = 0; i < tabela.size(); i++) {

            List<WebElement> conteudo = tabela.get(i)
                    .findElements(By.tagName("td"));

            for (WebElement coluna : conteudo) {

                if (coluna.getText().contains("Obrigatório sem assinatura") ||
                        coluna.getText().contains("Obrigatório com assinatura")) {

                    StringBuilder xpath = new StringBuilder();

                    xpath.append("//tr[")
                            .append(i)
                            .append("]//td[6]//div[1]//input[1]");

                    anexadores.add(By.xpath(xpath.toString()));
                }

            }
        }

        return anexadores;
    }

    public void aguardarTransacao() {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver());
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofMinutes(5));
        wait.ignoring(NoSuchElementException.class);
        final String[] titulo = {""};

        Function<WebDriver, Boolean> function = arg0 -> {
            By h4 = By.xpath("//h4[@class='ng-binding']");
            WebElement header = getDriver().findElement(h4);

            By h3 = By.xpath("//h3[contains(text(),'Operacao Realizada com Sucesso!')]");
//            WebElement inclusaoSucesso = getDriver().findElement(h3);

            By div = By.xpath("//div[@class='sa-icon sa-success animate']");
//            WebElement operacaoSucesso = getDriver().findElement(div);

            if (titulo[0].isEmpty()) {
                titulo[0] = header.getText();
            }

            return !header.getText().equals(titulo[0]);
        };
        wait.until(function);
    }

}
