package es.indra.autotestes.automation_project.pages.efisco;

import es.indra.autotestes.automation_project.utils.Gerencias;
import es.indra.autotestes.automation_project.utils.JSWaiter;
import es.indra.autotestes.automation_project.utils.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaginaPrincipalPage extends PageObject {


    @FindBy(id = "menu-atf")
    private WebElementFacade botaoMenu;
    @FindBy(xpath = "//body[@class='modal-open']/div[@class='modal ng-aside horizontal left fade ng-scope ng-isolate-scope in']/div[@class='modal-dialog modal-sm']/div[@class='modal-content']/div[@id='siderbarMenu']/ms-navigation[@class='scrollable ng-isolate-scope']/ul[@class='lst-menu list-group panel list']/li[1]/div[1]/a[1]")
    private WebElementFacade botaoAnexarDocumentacaoComplementar;
    @FindBy(xpath = "//body[@class='modal-open']/div[@class='modal ng-aside horizontal left fade ng-scope ng-isolate-scope in']/div[@class='modal-dialog modal-sm']/div[@class='modal-content']/div[@id='siderbarMenu']/ms-navigation[@class='scrollable ng-isolate-scope']/ul[@class='lst-menu list-group panel list']/li[5]/div[1]/a[1]")
    private WebElementFacade botaoProcesso;
    @FindBy(xpath = "//body[@class='modal-open']/div[@class='modal ng-aside horizontal left fade ng-scope ng-isolate-scope in']/div[@class='modal-dialog modal-sm']/div[@class='modal-content']/div[@id='siderbarMenu']/ms-navigation[@class='scrollable ng-isolate-scope']/ul[@class='lst-menu list-group panel list']/li[@class='ng-scope']/ul[@class='ng-scope']/li[4]/div[1]/a[1]")
    private WebElementFacade botaoProtocolizarProcesso;
    @FindBy(xpath = "//body[@class='modal-open']/div[@class='modal ng-aside horizontal left fade ng-scope ng-isolate-scope in']/div[@class='modal-dialog modal-sm']/div[@class='modal-content']/div[@id='siderbarMenu']/ms-navigation[@class='scrollable ng-isolate-scope']/ul[@class='lst-menu list-group panel list']/li[@class='ng-scope']/ul[@class='ng-scope']/li[@class='ng-scope']/ul[@class='ng-scope']/li[2]/div[1]/a[1]")
    private WebElementFacade botaoBeneficiosIcms;
    @FindBy(xpath = "//body[@class='modal-open']/div[@class='modal ng-aside horizontal left fade ng-scope ng-isolate-scope in']/div[@class='modal-dialog modal-sm']/div[@class='modal-content']/div[@id='siderbarMenu']/ms-navigation[@class='scrollable ng-isolate-scope']/ul[@class='lst-menu list-group panel list']/li[@class='ng-scope']/ul[@class='ng-scope']/li[@class='ng-scope']/ul[@class='ng-scope']/li[@class='ng-scope']/ul[@class='ng-scope']/li[1]/div[1]/a[1]")
    private WebElementFacade botaoIsencaoIcms;
    @FindBy(xpath = "//body[@class='modal-open']//ul[@class='ng-scope']//ul[@class='ng-scope']//ul[@class='ng-scope']//ul[@class='ng-scope']//li[1]//div[1]//a[1]")
    private WebElementFacade botaoReceberIcmsDiversos;
    @FindBy(xpath = "//button[@class='btn btn-danger pull-right']")
    private WebElementFacade botaoOk;
    @FindBy(xpath = "//button[@class='confirm']")
    private WebElementFacade botaoConfirmarOperacao;
    @FindBy(xpath = "//a[@class='close ng-scope']")
    private WebElementFacade botaoFecharOperacao;
    @FindBy(xpath = "//a[@class='close']")
    private WebElementFacade botaoFecharModal;
    @FindBy(id = "tipo_identificacao")
    private WebElementFacade comboboxTipoIdentificacao;
    @FindBy(xpath = "//select[@id='tipo_identificacao']//option[contains(text(),'CPF')]")
    private WebElementFacade opcaoCpf;
    @FindBy(xpath = "//select[@id='tipo_identificacao']//option[contains(text(),'CNPJ')]")
    private WebElementFacade opcaoCnpj;
    @FindBy(id = "numero")
    private WebElementFacade campoNumero;
    @FindBy(id = "email")
    private WebElementFacade campoEmail;
    @FindBy(id = "consultar")
    private WebElementFacade botaoConsultar;
    @FindBy(xpath = "//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']")
    private WebElementFacade comboboxOrgaoFormalizacao;
    @FindBy(xpath = "//option[contains(text(),'Gerência Executiva de Tributação da Secretaria de')]")
    private WebElementFacade opcaoGet;
    @FindBy(name = "btConfirmar")
    private WebElementFacade botaoConfirmar;
    @FindBy(id = "REQ_FILE_ID")
    private WebElementFacade botaoAnexarId;
    @FindBy(id = "consultar")
    private WebElementFacade botaoConcluir;
    @FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']//button[@class='confirm']")
    private WebElementFacade botaoAssinar;

    // mapeamento das gerencias
    @FindBy(id = "encaminhar-para")
    private WebElementFacade comboboxEncaminhar;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GET - Gerência Executiva de Tributação da Secretar')]")
    private WebElementFacade encaminharGET;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'ASS-GET - Assessoria da Get')]")
    private WebElementFacade encaminharASSGET;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GOBF-GET - Gerência Operacional de Benefício Fisca')]")
    private WebElementFacade encaminharGOBF;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GOIOT-GET - Gerência Operacional de Interpretação')]")
    private WebElementFacade encaminharGOIOT;
    @FindBy(xpath = "//select[@id='encaminhar-para']//option[contains(text(),'GORC-GET - Gerência Operacional de Relacionamento')]")
    private WebElementFacade encaminharGORC;

    private By obrigatorio0 = By
            .xpath("//tbody//tr[1]//td[6]//div[1]//input[1]");
    private By obrigatorio1 = By
            .xpath("//tbody//tr[3]//td[6]//div[1]//input[1]");
    private By obrigatorio2 = By
            .xpath("//tbody//tr[5]//td[6]//div[1]//input[1]");
    private By operacaoSucesso = By
            .xpath("//div[@class='sa-icon sa-success animate']");
    private By numeroProcesso = By
            .xpath("//h4[@class='ng-binding']");
    private By botaoAnexar = By
            .xpath("//div[@class='btn btn-danger btn-xs buttonUpload ng-scope ng-isolate-scope']//input");
    private By modal = By
            .xpath("//h3[contains(text(),'Órgão de Formalização')]");

    private WebElement parecer;
    private WebElement anexador;
    private Utils utils;
    private JSWaiter jswaiter;

    private void clicarBotaoMenu() {

        waitForAngularRequestsToFinish();
        waitFor(botaoMenu).click();
    }

    private void clicarBotaoAnexarDocumentacaoComplementar() {

        waitForAngularRequestsToFinish();
        waitFor(botaoAnexarDocumentacaoComplementar).click();
    }

    private void clicarBotaoProcesso() {

        waitForAngularRequestsToFinish();
        waitFor(botaoProcesso).click();
    }

    private void clicarBotaoProtocolizarProcesso() {

        waitFor(botaoProtocolizarProcesso).click();
    }

    private void clicarBotaoBeneficiosIcms() {

        waitFor(botaoBeneficiosIcms).click();
    }

    private void clicarBotaoIsencaoIcsm() {

        waitFor(botaoIsencaoIcms).click();
    }

    private void clicarBotaoReceberIcmsDiversos() {

        waitFor(botaoReceberIcmsDiversos).click();
    }

    private void selecionarTipoIdentificacaoCpf() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxTipoIdentificacao).click();
        waitFor(opcaoCpf).click();
    }

    private void selecionarTipoIdentificacaoCnpj() {

        waitForAngularRequestsToFinish();
        waitFor(comboboxTipoIdentificacao).click();
        waitFor(opcaoCnpj).click();
    }

    private void informarNumeroIdentificacao(String numero) {

        typeInto(campoNumero, numero);
        campoNumero.sendKeys(Keys.ENTER);
        waitForAngularRequestsToFinish();
    }

    public void informarIdentificacaoInteressado(@NotNull String identificacao) {

        if (identificacao.trim().length() > 11) {
            selecionarTipoIdentificacaoCnpj();
        } else {
            selecionarTipoIdentificacaoCpf();
        }
        informarNumeroIdentificacao(identificacao);
    }

    public void informarEmail() {

        if (campoEmail.getText().isEmpty()) {
            campoEmail.type("teste@teste.com");
        }
    }

    public String identificarProcesso() {

        return moveTo(numeroProcesso).getText().substring(11);
    }

    public void selecionarParecer(String nrProtocolo) {

        parecer = utils.identificarElemento(nrProtocolo, parecer);
        waitFor(parecer).click();
        if (botaoConsultar.isVisible()) {
            waitFor(botaoConsultar).click();
        } else if (botaoOk.isVisible()) {
            waitFor(botaoOk).click();
        }
        waitForAngularRequestsToFinish();
    }

    public void fecharOperacao() {

        waitFor(botaoFecharOperacao).click();
    }

    public void confirmarOperacao() {

        waitFor(botaoConfirmarOperacao).click();
        waitForAngularRequestsToFinish();
    }

    public void confirmarEFecharModal() {

        waitFor(botaoConfirmarOperacao).click();
        waitFor(botaoFecharModal).click();
    }

    public synchronized WebElement getResultadoSucesso() throws Throwable {

        wait(5000);
        waitForAngularRequestsToFinish();
//        utils.aguardarTransacao();
        return moveTo(operacaoSucesso).getWrappedElement();
    }


    /*
     * NAVEGACAO ENTRE O MENU
     */
    public void navegarAoPedidoIsencaoIcmsDiversos() {

        clicarBotaoMenu();
        clicarBotaoProcesso();
        clicarBotaoProtocolizarProcesso();
        clicarBotaoBeneficiosIcms();
        clicarBotaoIsencaoIcsm();
        clicarBotaoReceberIcmsDiversos();
        waitForAngularRequestsToFinish();
    }

    public void navagarAoAnexarDocumentacaoComplementar() {

        clicarBotaoMenu();
        clicarBotaoAnexarDocumentacaoComplementar();
    }

    public synchronized void anexarDocumento(String caminho) throws Throwable {

        waitForAngularRequestsToFinish();

        List<By> anexadores = utils.identificarDocumentoObrigatorio();

        for (By obrigatorio : anexadores) {
            moveTo(obrigatorio).sendKeys(caminho);
        }

        waitFor(botaoConcluir).click();
//        waitFor(botaoAssinar).click();
        waitForAngularRequestsToFinish();
        wait(5000);
//        utils.aguardarTransacao();
    }

    public synchronized void anexarDocumentacaoComplementar(String caminho) {

        waitForAngularRequestsToFinish();
        moveTo(obrigatorio0).sendKeys(caminho);
        waitFor(botaoConcluir).click();
        waitFor(botaoAssinar).click();
        utils.aguardarTransacao();
    }

    /**
     * Verifica se o modal de seleção de orgão de formalização é exibido
     */
    public void verificarModalOrgaoFormalizacao() {

        // se sim, selecione a gerência de tributação
        if (containsElements(modal)) {

            waitFor(comboboxOrgaoFormalizacao).click();
            waitFor(opcaoGet).click();
            waitFor(botaoConfirmar).click();
        }

    }

    public WebElement getGerencias(Gerencias gerencia) {

        return null;
    }

}
