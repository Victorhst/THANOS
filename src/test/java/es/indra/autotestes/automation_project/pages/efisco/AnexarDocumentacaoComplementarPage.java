package es.indra.autotestes.automation_project.pages.efisco;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AnexarDocumentacaoComplementarPage extends PageObject {

    org.openqa.selenium.By button = org.openqa.selenium.By
            .xpath("//tbody//tr[2]//td[6]//div[1]//input[1]");
    @FindBy(id = "consultar")
    private WebElementFacade botaoConsultar;

    private void submeterDocumento(String caminho) {

        waitForAngularRequestsToFinish();
        moveTo(button).sendKeys(caminho);
        waitFor(botaoConsultar).click();
    }

    private void analisarResultadoSaida() {

        // TODO verificar documentacao complementar
    }

}
