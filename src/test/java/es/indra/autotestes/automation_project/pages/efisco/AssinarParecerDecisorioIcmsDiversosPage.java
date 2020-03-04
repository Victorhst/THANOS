package es.indra.autotestes.automation_project.pages.efisco;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AssinarParecerDecisorioIcmsDiversosPage extends PageObject {

    @FindBy(xpath = "//button[@class='btn btn-danger pull-right']")
    private WebElementFacade botaoOk;
    @FindBy(id = "concordancia")
    private WebElementFacade comboboxConcordancia;
    @FindBy(xpath = "//option[contains(text(),'Desejo manter o parecer')]")
    private WebElementFacade manterProcesso;
    @FindBy(id = "de-acordo")
    private WebElementFacade checkboxDeAcordo;
    @FindBy(id = "assinar")
    private WebElementFacade botaoAssinar;

    public synchronized void assinarMinutaParecerDecisorio() throws Throwable {

        wait(5000);
        waitForAngularRequestsToFinish();
        waitForTextToAppear("Assinar Minuta de Parecer Decisório");
        waitFor(comboboxConcordancia).click();
        waitFor(manterProcesso).click();
        waitFor(checkboxDeAcordo).click();
        waitFor(botaoAssinar).click();
        wait(8000);
        waitForAngularRequestsToFinish();
    }

    public synchronized void assinarMinutaParecerGerenciaExecutiva() throws Throwable {

        wait(5000);
        waitForAngularRequestsToFinish();
        waitForTextToAppear("Parecer da Gerência Executiva");
        waitFor(comboboxConcordancia).click();
        waitFor(manterProcesso).click();
        waitFor(checkboxDeAcordo).click();
        waitFor(botaoAssinar).click();
        wait(8000);
        waitForAngularRequestsToFinish();
    }

}
