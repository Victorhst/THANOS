package es.indra.autotestes.automation_project.pages.efisco;

import es.indra.autotestes.automation_project.utils.Atores;
import es.indra.autotestes.automation_project.utils.Gerencias;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class DistribuirEmitirParecerIsencaoIcmsDiversosPage extends PageObject {

    private final Map<Gerencias, Supplier<WebElement>> gerenciasMap = new HashMap<>();
    private final Map<Atores, Supplier<WebElement>> atoresMap = new HashMap<>();
    private final Map<Gerencias, List<Atores>> setorAtorMap = new HashMap<>();
    @FindBy(xpath = "//button[@class='btn btn-danger pull-right']")
    private WebElementFacade botaoOk;
    @FindBy(id = "situacao-documentacao")
    private WebElementFacade comboboxSituacao;
    @FindBy(xpath = "//select[@id='situacao-documentacao']//option[contains(text(),'Completa')]")
    private WebElementFacade situacaoCompleta;
    @FindBy(xpath = "//select[@id='situacao-documentacao']//option[contains(text(),'Incompleta')]")
    private WebElementFacade situacaoIncompleta;
    @FindBy(id = "motivo")
    private WebElementFacade campoMotivo;
    @FindBy(id = "consultar")
    private WebElementFacade botaoConcluir;
    @FindBy(id = "consultar")
    private WebElementFacade botaoConsultar;
    @FindBy(id = "encaminhar-para")
    private WebElementFacade comboboxEncaminhar;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GET - Gerência Executiva de Tributação da Secretar')]")
    private WebElementFacade get;
    @FindBy(xpath = "")
    private WebElementFacade assget;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GOBF-GET - Gerência Operacional de Benefício Fisca')]")
    private WebElementFacade gobf;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GOIOT-GET - Gerência Operacional de Interpretação')]")
    private WebElementFacade goiot;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GORC-GET - Gerência Operacional de Relacionamento')]")
    private WebElementFacade gorc;
    @FindBy(id = "parecerista")
    private WebElementFacade comboboxParecerista;
    @FindBy(xpath = "//select[@id='parecerista']//option[contains(text(),'Alexa-55513')]")
    private WebElementFacade gerenteExecutivo;
    // TODO incluir path usuarios
    @FindBy(xpath = "//select[@id='parecerista']//option[contains(text(),'Alban-55368')]")
    private WebElementFacade parecerista;
    @FindBy(xpath = "//select[@id='parecerista']//option[contains(text(),'Rozan-55413')]")
    private WebElementFacade gerenteOperacional;
    @FindBy(id = "tipo-pedido")
    private WebElementFacade comboboxTipoPedido;
    @FindBy(xpath = "//select[@id='tipo-pedido']//option[contains(text(),'Simples')]")
    private WebElementFacade pedidoSimples;
    @FindBy(xpath = "//select[@id='tipo-pedido']//option[contains(text(),'Complexo')]")
    private WebElementFacade pedidoComplexo;
    @FindBy(id = "tipoParecer")
    private WebElementFacade comboBoxParecer;
    @FindBy(xpath = "//select[@id='tipoParecer']//option[contains(text(),'Deferido Total')]")
    private WebElementFacade deferidoTotal;
    @FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']//button[@class='confirm']")
    private WebElementFacade botaoAssinar;
    @FindBy(id = "grupoAssunto")
    private WebElementFacade comboboxGrupoAssunto;
    @FindBy(xpath = "//select[@id='grupoAssunto']//option[contains(text(),'A) TARE ATAC')]")
    private WebElementFacade opcaoA;
    @FindBy(xpath = "//div[@class='sa-button-container']//button[@class='cancel']")
    private WebElementFacade botaoNao;
    @FindBy(xpath = "//button[@class='cancel']")
    private WebElementFacade botaoNaoCarregador;
    private WebElement gerencia;
    private Gerencias gerenciaType;

    // Mapeamento das gerências executivas
    private Supplier<WebElement> getSupplier = () -> {

        gerencia = getDriver().findElement(By.xpath("//select[@id='encaminhar-para']//option[contains(text(),'GET - Gerência Executiva de Tributação da Secretar')]"));
        return gerencia;
    };
    private Supplier<WebElement> assGetSupplier = () -> {

        gerencia = getDriver().findElement(By.xpath("//select[@id='encaminhar-para']//option[contains(text(),'GET - Gerência Executiva de Tributação da Secretar')]"));
        return gerencia;
    };
    private Supplier<WebElement> gobfSupplier = () -> {

        gerencia = getDriver().findElement(By.xpath("//select[@id='encaminhar-para']//option[contains(text(),'GOBF-GET - Gerência Operacional de Benefício Fisca')]"));
        return gerencia;
    };
    private Supplier<WebElement> goiotSupplier = () -> {

        gerencia = getDriver().findElement(By.xpath("//select[@id='encaminhar-para']//option[contains(text(),'GOIOT-GET - Gerência Operacional de Interpretação')]"));
        return gerencia;
    };
    private Supplier<WebElement> gorcSupplier = () -> {

        gerencia = getDriver().findElement(By.xpath("//select[@id='encaminhar-para']//option[contains(text(),'GORC-GET - Gerência Operacional de Relacionamento')]"));
        return gerencia;
    };

    // Mapeamento dos elementos de página
    private org.openqa.selenium.By button = org.openqa.selenium.By
            .xpath("//tbody//tr[2]//td[6]//div[1]//input[1]");
    private org.openqa.selenium.By operacaoSucesso = org.openqa.selenium.By
            .xpath("//div[@class='sa-icon sa-success animate']");
    private org.openqa.selenium.By assinador = org.openqa.selenium.By.xpath(
            "//h2[contains(text(),'Não foi possível carregar o assinador!')]");

    {
        gerenciasMap.put(Gerencias.GET, getSupplier);
        gerenciasMap.put(Gerencias.ASSGET, assGetSupplier);
        gerenciasMap.put(Gerencias.GOBF, gobfSupplier);
        gerenciasMap.put(Gerencias.GOIOT, goiotSupplier);
        gerenciasMap.put(Gerencias.GORC, gorcSupplier);
    }

    private WebElement getGerencia(Gerencias gerencia) {
        return gerenciasMap.get(gerencia).get();
    }
    // Mapeamento dos atores pareceristas


    public void setGerenciasType(Gerencias ger) {
        gerenciaType = ger;
    }

    public void selecionarSituacaoDocumentacaoIncompleta(String mensagem) {

        waitForAngularRequestsToFinish();
        waitFor(comboboxSituacao).click();
        waitFor(situacaoIncompleta).click();
        waitFor(campoMotivo).type(mensagem);
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void selecionarSituacaoDocumentacaoCompleta() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxSituacao).click();
        waitFor(situacaoCompleta).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    /*
     * GERÊNCIAS
     */
    public void encaminharDocumentacaoGet() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxEncaminhar).click();
        waitFor(get).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void encaminharDocumentacaoAssGet() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxEncaminhar).click();
        waitFor(assget).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void encaminharDocumentacaoGobf() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxEncaminhar).click();
        waitFor(gobf).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void encaminharDocumentacaoGoiot() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxEncaminhar).click();
        waitFor(goiot).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void encaminharDocumentacaoGorc() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxEncaminhar).click();
        waitFor(gorc).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }
    /*
     * GERÊNCIAS
     */

    /*
     * ATORES
     */
    public void distribuirPedidoGE() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxParecerista).click();
        waitFor(gerenteExecutivo).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void distribuirPedidoPareceristaGE() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxParecerista).click();
        waitFor(parecerista).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void distribuirPedidoGO() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxParecerista).click();
        waitFor(gerenteOperacional).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }
    /*
     * ATORES
     */

    public void analisarPedidoSimples() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxTipoPedido).click();
        waitFor(pedidoSimples).click();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
    }

    public void analisarPedidoComplexo() {


    }

    public void teste() {

        Set<String> pareceristas = getSelectedOptionLabelsFrom(comboboxEncaminhar);
    }
    // TODO gerar um deferimento especifico para cada complexidade da lista

    private synchronized void deferirParecer() throws Throwable {

        waitForAngularRequestsToFinish();
        waitFor(comboBoxParecer).click();
        waitFor(deferidoTotal).click();
        waitForAngularRequestsToFinish();
    }

    private void submeterDocumento(String caminho) {

        waitForAngularRequestsToFinish();
        moveTo(button).sendKeys(caminho);
        waitFor(botaoConcluir).click();
        waitFor(botaoAssinar).click();
    }

    public void assinarParecer(String caminho) throws Throwable {

        deferirParecer();
        submeterDocumento(caminho);
    }

    public synchronized void informarAssuntoPedido() throws Throwable {

        wait(7000);
        waitForAngularRequestsToFinish();
        waitForTextToAppear("Informar Assuntos do Pedido");
        waitFor(comboboxGrupoAssunto).click();
        waitFor(opcaoA).click();
        waitForAngularRequestsToFinish();
        waitFor(botaoConcluir).click();
        waitForAngularRequestsToFinish();
        waitFor(botaoNao).click();
        waitForAngularRequestsToFinish();
    }

    public WebElement getResultado() {
        waitForAngularRequestsToFinish();
        return moveTo(operacaoSucesso).getWrappedElement();
    }

    public By getAtor(Gerencias g, Atores a) {
        if (this.setorAtorMap.containsKey(g)) {
            return this.setorAtorMap.get(g).stream()
                    .filter((Atores item) -> {
                        return (item.getId() == a.getId()) && item.getSetor().equals(g.getName());
                    })
                    .findFirst()
                    .get().getPath();
        }
        return null;
    }

}
