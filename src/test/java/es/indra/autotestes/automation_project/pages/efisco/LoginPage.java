package es.indra.autotestes.automation_project.pages.efisco;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author victor.teixeira
 */
public class LoginPage extends PageObject {

    public static final String USUARIO = "usuario";
    public static final String SENHA = "senha";

    // Mapeamento dos elementos de p�gina
    @FindBy(id = "username")
    private WebElementFacade campoUsuario;
    @FindBy(id = "password")
    private WebElementFacade campoSenha;
    @FindBy(name = "submit")
    private WebElementFacade botaoAvancar;
    @FindBy(name = "reset")
    private WebElementFacade botaoLimpar;
    @FindBy(id = "conteudo")
    private WebElementFacade conteudo;
    @FindBy(xpath = "div[@class='cs-loader']//div[@class='loader']")
    private WebElementFacade elementoCarregar;
    @FindBy(xpath = "//a[@class='close ng-scope']")
    private WebElementFacade botaoFechar;
    @FindBy(id = "sair")
    private WebElementFacade botaoSair;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static String getCredenciais(String credenciais, String tipo) {

        String credencial = "";
        String[] value = credenciais.split(":");
        ArrayList<String> cred = new ArrayList<>(Arrays.asList(value));

        if (tipo.equals(USUARIO)) {
            credencial = cred.get(0);
        } else if (tipo.equals(SENHA)) {
            credencial = cred.get(1);
        }

        return credencial;
    }

    private void navegarLoginEfisco(String url) {

        getDriver().manage().timeouts().setScriptTimeout(1, TimeUnit.HOURS);
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        openUrl(url);
    }

    private void informarUsuario(String usuario) {

        waitFor(campoUsuario);
        typeInto(campoUsuario, usuario);
    }

    private void informarSenha(String senha) {

        waitFor(campoSenha);
        typeInto(campoSenha, senha);
    }

    private void clicarAvancar() {

        waitFor(botaoAvancar);
        clickOn(botaoAvancar);
    }

    public void realizarLogin(String url, String credenciais) {

        navegarLoginEfisco(url);
        informarUsuario(getCredenciais(credenciais, USUARIO));
        informarSenha(getCredenciais(credenciais, SENHA));
        clicarAvancar();
        waitForCondition().until(ExpectedConditions.urlContains("inbox"));
        waitForAngularRequestsToFinish();
    }

    public void realizarLogoffAposOperacao() {

        waitFor(botaoFechar).click();
        waitFor(botaoSair).click();
    }

    /**
     * Utilzado para logoff durante qualquer ocasi�o no sistema.
     */
    public void realizarLogoff() {

        waitFor(botaoSair).click();
    }

}
