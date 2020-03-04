package es.indra.autotestes.automation_project.pages.efisco;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class AssinarParecerFinalIcmsDiversosPage extends PageObject {

    org.openqa.selenium.By operacaoSucesso = org.openqa.selenium.By
            .xpath("//div[@class='sa-icon sa-success animate']");
    @FindBy(id = "concordancia")
    private WebElementFacade comboboxConcordancia;
    @FindBy(xpath = "//option[contains(text(),'Desejo manter o parecer')]")
    private WebElementFacade manterParecer;
    @FindBy(id = "de-acordo")
    private WebElementFacade checkboxDeAcordo;
    @FindBy(id = "assinar")
    private WebElementFacade botaoAssinar;

    public synchronized void assinarMinutaParecerFinal() throws Throwable {

        wait(5000);
        waitForAngularRequestsToFinish();
        waitForTextToAppear("Assinar Parecer Final");
        waitFor(comboboxConcordancia).click();
        waitFor(manterParecer).click();
        waitFor(checkboxDeAcordo).click();
        waitFor(botaoAssinar).click();
        wait(5000);
        waitForAngularRequestsToFinish();
    }

    public WebElement getResultado() {

        waitForAngularRequestsToFinish();
        return moveTo(operacaoSucesso).getWrappedElement();
    }

}
