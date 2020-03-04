package es.indra.autotestes.automation_project.steps.efisco.icms;

import net.thucydides.core.annotations.Step;

public class IsencaoIcmsDiversosSteps extends IsencaoIcmsSteps {

    @Step
    public void receberPedidoDeIsencaoDeIcms(String credenciais, String cpf) throws Throwable {

        realizarLoginEfisco(credenciais);
        navegarPaginaReceberPedidoIcmsDiversos();
        verificarPaginaReceberPedidoIcmsDiversos();
        informarIdentificacao(cpf);
        informarEmail();
        anexarDocumento();
        verificarResultadoOperacao();
        identificarNumeroProtocoloProcesso();
        realizarLogoffAposInclusao();
    }

    @Step
    public void distribuirEEmitirParecerGETSemParecerista(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        selecionarParecer();
        validarSituacaoDocumentacaoCompleta();
        encaminharDocumentacaoGET();
        distribuirPedidoGE();
        analisarPedidoSimples();
        assinarParecer();
        informarAssuntoPedido();
        veriricarAssinaturaParecerDecisorio();
        realizarLogoffAposOperacao();
    }

    @Step
    public void distribuirParecerGETComParecerista(String credenciais) {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        selecionarParecer();
        validarSituacaoDocumentacaoCompleta();
        encaminharDocumentacaoGET();
        distribuirPedidoParecerista();
        realizarLogoff();
    }

    @Step
    public void distribuirParecerGOBFSemParecerista(String credenciais) {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        selecionarParecer();
        validarSituacaoDocumentacaoCompleta();
        encaminahrDocumentacaoGOBF();
//        distribuirPedidoGO();
        realizarLogoff();
    }

    @Step
    public void distribuirEAssinarParecerGOBF(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        selecionarParecer();
        distribuirPedidoGO();
        analisarPedidoSimples();
        assinarParecer();
        informarAssuntoPedido();
        veriricarAssinaturaParecerDecisorio();
        realizarLogoffAposOperacao();
    }

    @Step
    public void analisarEAssinarParecer(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        selecionarParecer();
        analisarPedidoSimples();
        assinarParecer();
        informarAssuntoPedido();
        veriricarAssinaturaParecerDecisorio();
        realizarLogoffAposOperacao();
    }

    @Step
    public void assinarMinutasDosPareceresDecisorioEFinal(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        selecionarParecer();
        assinarMinutaParecerDecisorio();
        assinarMinutaParecerFinal();
        verificarAssinaturaMinutaParecerFinal();
        realizarLogoffAposOperacao();
    }

    @Step
    public void assinarMinutaParecerDaGerenciaExecutiva(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        selecionarParecer();
        assinarMinutaParecerGerenciaExecutiva();
//        verificarResultadoSucesso();
        realizarLogoff();
    }

    @Step
    public void assinarMinutaParecerFinal(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        selecionarParecer();
        assinarMinutaParecerFinal();
        verificarResultadoSucesso();
        realizarLogoffAposOperacao();
    }

    @Step
    public void receberPedidoDeIsencaoDeIcmsComCnpjContribuinte(String credenciais, String cnpj) {

        realizarLoginEfisco(credenciais);
        navegarPaginaReceberPedidoIcmsDiversos();
        verificarPaginaReceberPedidoIcmsDiversos();
        informarIdentificacao(cnpj);
        verificarImpossibilidadeOperacao();
        confirmarEFecharModalOperacao();
        realizarLogoff();
    }

    @Step
    public void validarDocumentacaoIncompleta(String credenciais) throws Throwable {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        selecionarParecer();
        validarSituacaoDocumentacaoIncompleta();
        verificarResultadoSucesso();
        confirmarOperacao();
        realizarLogoff();
    }

    @Step
    public void anexarDocumentacaoComplementar(String credenciais, String cpf) throws Throwable {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        navegarPaginaAnexarDocumentacaoComplementar();
        informarIdentificacao(cpf);
        selecionarParecer();
        anexarDocumentoComplementar();
        encaminharDocumentacaoGET();
        distribuirPedidoGE();
        analisarPedidoSimples();
        assinarParecer();
        informarAssuntoPedido();
        verificarResultadoSucesso();
        confirmarOperacao();
        realizarLogoff();
    }

    @Step
    public void anexarDocumentacaoComplementarEAssinarPareceres(String credenciais, String cpf)
            throws Throwable {

        realizarLoginEfisco(credenciais);
        verificarOrgaoDeFormalizacao();
        navegarPaginaAnexarDocumentacaoComplementar();
        informarIdentificacao(cpf);
        selecionarParecer();
        anexarDocumento();
        encaminharDocumentacaoGET();
        distribuirPedidoGE();
        analisarPedidoSimples();
        assinarParecer();
        informarAssuntoPedido();
        assinarMinutaParecerDecisorio();
        assinarMinutaParecerFinal();
        verificarAssinaturaMinutaParecerFinal();
        realizarLogoffAposOperacao();
    }

}
