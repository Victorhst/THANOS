package es.indra.autotestes.automation_project.steps.efisco.icms;

import es.indra.autotestes.automation_project.pages.efisco.*;
import es.indra.autotestes.automation_project.steps.efisco.common.CommonSteps;
import es.indra.autotestes.automation_project.utils.Dados;
import es.indra.autotestes.automation_project.utils.Mensagens;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class IsencaoIcmsSteps extends CommonSteps {

    PaginaPrincipalPage paginaPrincipal;
    ReceberIsencaoIcmsDiversosPage receberIsencaoIcms;
    DistribuirEmitirParecerIsencaoIcmsDiversosPage distribuirParecer;
    AssinarParecerDecisorioIcmsDiversosPage assinarParecerDecisorio;
    AssinarParecerFinalIcmsDiversosPage assinarParecerFinal;

    @Step
    public void navegarPaginaReceberPedidoIcmsDiversos() {

        paginaPrincipal.navegarAoPedidoIsencaoIcmsDiversos();
    }

    @Step
    public void navegarPaginaAnexarDocumentacaoComplementar() {

        paginaPrincipal.navagarAoAnexarDocumentacaoComplementar();
    }

    @Step
    public void verificarPaginaReceberPedidoIcmsDiversos() {

        assertThat(paginaPrincipal.getDriver().getCurrentUrl(),
                equalTo(Dados.URL_PEDIDO_ISENCAO));
    }

    @Step
    public void submeterDocumentacaoObrigatoria() {

        receberIsencaoIcms.submeterDocumentacaoObrigatoria(Dados.PDF_TESTE);
    }

    @Step
    public void verificarResultadoOperacao() {

        assertThat(receberIsencaoIcms.getResultado(),
                equalTo(Mensagens.OPERACAO_COM_SUCESSO));
    }

    @Step
    public void verificarImpossibilidadeOperacao() {

        assertTrue(receberIsencaoIcms.verificarImpossibilidade().isDisplayed());
    }

    @Step
    public void validarSituacaoDocumentacaoCompleta() {

        distribuirParecer.selecionarSituacaoDocumentacaoCompleta();
    }

    @Step
    public void validarSituacaoDocumentacaoIncompleta() {

        distribuirParecer.selecionarSituacaoDocumentacaoIncompleta(Mensagens.TESTE);
    }

    @Step
    public void encaminharDocumentacaoGET() {

        distribuirParecer.encaminharDocumentacaoGet();
    }

    @Step
    public void encaminahrDocumentacaoGOBF() {

        distribuirParecer.encaminharDocumentacaoGobf();
    }

    @Step
    public void distribuirPedidoGE() {

        distribuirParecer.distribuirPedidoGE();
    }

    @Step
    public void distribuirPedidoParecerista() {

        distribuirParecer.distribuirPedidoPareceristaGE();
    }

    @Step
    public void distribuirPedidoGO() {

        distribuirParecer.distribuirPedidoGO();
    }

    @Step
    public void analisarPedidoSimples() {

        distribuirParecer.analisarPedidoSimples();
    }

    @Step
    public void assinarParecer() throws Throwable {

        distribuirParecer.assinarParecer(Dados.PDF_TESTE);
    }

    @Step
    public void informarAssuntoPedido() throws Throwable {

        distribuirParecer.informarAssuntoPedido();
    }

    @Step
    public void veriricarAssinaturaParecerDecisorio() throws Throwable {

        assertTrue(paginaPrincipal.getResultadoSucesso().isDisplayed());
    }

    @Step
    public void assinarMinutaParecerDecisorio() throws Throwable {

        assinarParecerDecisorio.assinarMinutaParecerDecisorio();
    }

    @Step
    public void assinarMinutaParecerGerenciaExecutiva() throws Throwable {

        assinarParecerDecisorio.assinarMinutaParecerGerenciaExecutiva();
    }

    @Step
    public void assinarMinutaParecerFinal() throws Throwable {

        assinarParecerFinal.assinarMinutaParecerFinal();
    }

    @Step
    public void verificarAssinaturaMinutaParecerFinal() {

        assertTrue(assinarParecerFinal.getResultado().isDisplayed());

    }


}
