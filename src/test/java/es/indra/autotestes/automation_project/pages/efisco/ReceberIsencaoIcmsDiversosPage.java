package es.indra.autotestes.automation_project.pages.efisco;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReceberIsencaoIcmsDiversosPage extends PageObject {

    // By.xpath
    org.openqa.selenium.By obrigatorio1 = org.openqa.selenium.By
            .xpath("//tbody//tr[3]//td[6]//div[1]//input[1]");
    org.openqa.selenium.By obrigatorio2 = org.openqa.selenium.By
            .xpath("//tbody//tr[5]//td[6]//div[1]//input[1]");
    org.openqa.selenium.By operacaoInvalida = org.openqa.selenium.By
            .xpath("//div[@class='sa-icon sa-warning pulseWarning']");
    org.openqa.selenium.By numeroProcesso = org.openqa.selenium.By
            .xpath("//h4[@class='ng-binding']");
    org.openqa.selenium.By operacaoSucesso = org.openqa.selenium.By
            .xpath("//h3[contains(text(),'Operacao Realizada com Sucesso!')]");
    // Mapeamento dos elementos de página
    @FindBy(id = "consultar")
    private WebElementFacade botaoConsultar;
    @FindBy(xpath = "//tr[2]//td[6]")
    private WebElementFacade anexarDocumentacao;
    @FindBy(xpath = "//tbody//tr[2]//td[6]//div[1]//input[1]")
    private WebElementFacade botaoAnexarDocumento;
    @FindBy(css = "//h3[contains(text(),'Operacao Realizada com Sucesso!')]")
    private WebElementFacade resultadoOperacao;
    @FindBy(xpath = "//a[@class='close ng-scope']")
    private WebElementFacade botaoFechar;
    @FindBy(id = "sair")
    private WebElementFacade botaoSair;

    public ReceberIsencaoIcmsDiversosPage(WebDriver driver) {
        super(driver);
    }

    private void submeterDocumento(String caminho) {

        waitForAngularRequestsToFinish();
        moveTo(obrigatorio1).sendKeys(caminho);
        moveTo(obrigatorio2).sendKeys(caminho);
        waitFor(botaoConsultar).click();
    }

    public void submeterDocumentacaoObrigatoria(String caminho) {

        submeterDocumento(caminho);
    }

    public String getResultado() {

        waitForAngularRequestsToFinish();
        return moveTo(operacaoSucesso).getText();
    }

    public String identificarProcesso() {

        return moveTo(numeroProcesso).getText().substring(11);
    }

    public WebElement verificarImpossibilidade() {

        waitForAngularRequestsToFinish();
        return moveTo(operacaoInvalida).getWrappedElement();
    }


}
