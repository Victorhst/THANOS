package es.indra.autotestes.automation_project.pages.atf;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class ATFPage extends PageObject {

    private final WebDriver driver;

    @FindBy(name = "edtNoLogin")
    private WebElement usuarioField;

    @FindBy(name = "edtDsSenha")
    private WebElement senhaField;

    @FindBy(name = "btnAvancar")
    private WebElement loginButton;

    @FindBy(name = "cmbLotacao")
    private WebElement comboLotacao;

    @FindBy(xpath = "//select[@name='cmbLotacao']//option[text()='CONSELHO DE RECURSOS FISCAIS']")
    private WebElement conselhoRecursosFiscais;

    @FindBy(xpath = "//select[@name='cmbLotacao']//option[text()='GABINETE DO SECRET�RIO DE ESTADO DA RECEITA']")
    private WebElement gabineteSecretario;

    @FindBy(xpath = "//select[@name='cmbLotacao']//option[text()='CHEFIA DE GABINETE DA SECRETARIA DE ESTADO DA RECEITA']")
    private WebElement chefiaGabinete;

    @FindBy(xpath = "//select[@name='cmbLotacao']//option[@value='214']")
    private WebElement gerenciaTecnologiaInformacao;
    // text()='GER�NCIA  DE TECNOLOGIA DA INFORMA��O DA SECRETARIA DE ESTADO DA RECEITA'

    @FindBy(name = "btnAvancar")
    private WebElement botaoAvancar;

    @FindBy(css = "table.fontePadrao.atf-login table.fontePadrao.atf-login-form tbody:nth-child(1) tr.tdPadrao.atf-login-submit:nth-child(8) td:nth-child(2) > input.botoes")
    private WebElement botaoAvancarComboLotacao;

    @FindBy(className = "atf-link-certificado")
    private WebElement acessoViaCertificado;

    @FindBy(xpath = "//td[@class='atf-app-title']")
    private WebElement tdBemVindo;

    @FindBy(name = "cabecalho")
    private WebElement frameCabecalho;

    @FindBy(name = "contents")
    private WebElement frameContents;

    @FindBy(name = "principal")
    private WebElement framePrincipal;

    @FindBy(id = "Acesso")
    private WebElement linkAcessoViaLoginSenha;


    public ATFPage(WebDriver driver) {
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public static ATFPage usando(WebDriver driver) {
        return new ATFPage(driver);
    }

    public ATFPage navegarLoginIntegracao() {
        openUrl("https://ap1hom.receita.pb.gov.br/atf/");
        return this;
    }

    public ATFPage loginPadrao(String usuario, String senha) {
        waitFor(frameContents);
        getDriver().switchTo().frame(frameContents);
        waitFor(usuarioField).type(usuario);
        waitFor(senhaField).type(senha);
        clickOn(loginButton);
        return this;
    }

    public ATFPage verificarLogin() {
        waitFor(framePrincipal);
        getDriver().switchTo().frame(framePrincipal);
        assertTrue(waitFor(tdBemVindo).containsText("Seja bem vindo"));
        return this;
    }

}
