package es.indra.autotestes.automation_project.steps.efisco.common;

import es.indra.autotestes.automation_project.pages.efisco.LoginPage;
import es.indra.autotestes.automation_project.pages.efisco.PaginaPrincipalPage;
import es.indra.autotestes.automation_project.utils.Dados;
import es.indra.autotestes.automation_project.utils.Mensagens;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

public class CommonSteps {

    LoginPage login;
    PaginaPrincipalPage paginaPrincipal;

    long localvar;

    @Step
    public void realizarLoginEfisco(String credenciais) {

        login.realizarLogin(Dados.URL_LOGIN, credenciais);
        assumeThat(login.getDriver().getCurrentUrl(), equalTo(Dados.URL_INBOX));
    }

    /**
     * Utilizado após realizar uma operação como, por exemplo, inclusão de um
     * novo parecer.
     */
    @Step
    public void realizarLogoffAposInclusao() {

        paginaPrincipal.fecharOperacao();
        login.realizarLogoff();
    }

    /**
     * Utilizado após realizar uma operação como, por exemplo, a assinatura de
     * um parecer.
     */
    @Step
    public void realizarLogoffAposOperacao() {

        paginaPrincipal.confirmarOperacao();
        login.realizarLogoff();
    }

    @Step
    public void realizarLogoff() {

        login.realizarLogoff();
    }

    @Step
    public void confirmarEFecharModalOperacao() {

        paginaPrincipal.confirmarEFecharModal();
    }

    @Step
    public void confirmarOperacao() {

        paginaPrincipal.confirmarOperacao();
    }

    @Step
    public void identificarNumeroProtocoloProcesso() {

        // armazenando o número do protocolo do processo na sessão
        Serenity.setSessionVariable(Mensagens.NUMERO_PROTOCOLO)
                .to(paginaPrincipal.identificarProcesso());
    }

    @Step
    public String retornarProcesso() {

        return Serenity.sessionVariableCalled(Mensagens.NUMERO_PROTOCOLO);
    }

    @Step
    public void selecionarParecer() {

        paginaPrincipal.selecionarParecer(retornarProcesso());
    }

    @Step
    public void verificarResultadoSucesso() throws Throwable {

        assertTrue(paginaPrincipal.getResultadoSucesso().isDisplayed());
    }

    @Step
    public void informarIdentificacao(String identificacao) {

        paginaPrincipal.informarIdentificacaoInteressado(identificacao);
    }

    @Step
    public void informarEmail() {

        paginaPrincipal.informarEmail();
    }

    @Step
    public void anexarDocumento() throws Throwable {

        paginaPrincipal.anexarDocumento(Dados.PDF_TESTE);
    }

    @Step
    public void anexarDocumentoComplementar() throws Throwable {

        paginaPrincipal.anexarDocumento(Dados.PDF_TESTE);
    }

    @Step
    public void verificarOrgaoDeFormalizacao() {

        paginaPrincipal.verificarModalOrgaoFormalizacao();
    }

}
