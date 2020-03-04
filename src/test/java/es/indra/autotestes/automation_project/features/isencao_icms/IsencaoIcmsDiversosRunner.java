package es.indra.autotestes.automation_project.features.isencao_icms;

import es.indra.autotestes.automation_project.steps.efisco.icms.IsencaoIcmsDiversosSteps;
import es.indra.autotestes.automation_project.utils.Dados;
import es.indra.autotestes.automation_project.utils.Excecoes;
import es.indra.autotestes.automation_project.utils.Usuario;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IsencaoIcmsDiversosRunner {

    @Managed(uniqueSession = true)
    WebDriver driver;

    @Steps
    IsencaoIcmsDiversosSteps usuario;

    @BeforeTest
    //public void initUsuarios()

    @Test
    @Title("Pedido de isenção de ICMS diverso com CNPJ contribuinte")
    public void testeAIsencaoIcmsDiversoCnpjContribuinte()
            throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcmsComCnpjContribuinte(
                    Usuario.ACESSOR_DE_PROTOCOLO, Dados.CNPJ_CONTRIBUINTE_COM_DTE);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);

        }
    }

    @Test
    @Title("Pedido de isenção com documentação complementar")
    public void testeBIsencaoIcmsDiversoDocumentacaoComplementar()
            throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO, Dados.CPF);
            usuario.validarDocumentacaoIncompleta(Usuario.GERENTE_EXECUTIVO);
            usuario.anexarDocumentacaoComplementar(Usuario.GERENTE_EXECUTIVO, Dados.CPF);

//            usuario.assinarMinutaParecerDecisorio(Usuario.ACESSOR_DE_PROTOCOLO);
//            usuario.assinarMinutaParecerFinal(Usuario.SECRETARIO_RECEITA);

            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("GE sem parecerista")
    public void testeCReceberIsencaoDeIcmsDiversoGESemParecerista()
            throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO,
                    Dados.CPF);
            usuario.distribuirEEmitirParecerGETSemParecerista(Usuario.GERENTE_EXECUTIVO);
            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("GE com parecerista")
    public void testeDReceberIsencaoDeIcmsDiversoGEComParecerista() throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO, Dados.CPF);
            usuario.distribuirParecerGETComParecerista(Usuario.GERENTE_EXECUTIVO);
            usuario.analisarEAssinarParecer(Usuario.PARECERISTA);
            usuario.assinarMinutaParecerDaGerenciaExecutiva(Usuario.GERENTE_EXECUTIVO);
            //usuario.assinarMinutaParecerDaGerenciaExecutiva(Usuario.GERENTE_EXECUTIVO);
            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("GO sem parecerista")
    public void testeEReceberIsencaoDeIcmsDiversoGESemParecerista() throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO, Dados.CPF);
            usuario.distribuirParecerGOBFSemParecerista(Usuario.GERENTE_EXECUTIVO);
            usuario.distribuirEAssinarParecerGOBF(Usuario.GERENTE_OPERACIONAL);
            usuario.assinarMinutaParecerDaGerenciaExecutiva(Usuario.GERENTE_EXECUTIVO);
            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("Pedido de isenção com documentação complementar")
    public void testeFIsencaoIcmsDiversoDocumentacaoComplementarCNPJ()
            throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO, Dados.CNPJ_NAO_CONTRIBUINTE);
            usuario.validarDocumentacaoIncompleta(Usuario.GERENTE_EXECUTIVO);
            usuario.anexarDocumentacaoComplementar(Usuario.GERENTE_EXECUTIVO, Dados.CNPJ_NAO_CONTRIBUINTE);

//            usuario.assinarMinutaParecerDecisorio(Usuario.ACESSOR_DE_PROTOCOLO);
//            usuario.assinarMinutaParecerFinal(Usuario.SECRETARIO_RECEITA);

            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("GE sem parecerista")
    public void testeGReceberIsencaoDeIcmsDiversoGESemPareceristaCNPJ()
            throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO,
                    Dados.CNPJ_NAO_CONTRIBUINTE);
            usuario.distribuirEEmitirParecerGETSemParecerista(Usuario.GERENTE_EXECUTIVO);
            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("GE com parecerista")
    public void testeHReceberIsencaoDeIcmsDiversoGEComPareceristaCNPJ() throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO, Dados.CNPJ_NAO_CONTRIBUINTE);
            usuario.distribuirParecerGETComParecerista(Usuario.GERENTE_EXECUTIVO);
            usuario.analisarEAssinarParecer(Usuario.PARECERISTA);
            usuario.assinarMinutaParecerDaGerenciaExecutiva(Usuario.GERENTE_EXECUTIVO);
//            usuario.assinarMinutaParecerDaGerenciaExecutiva(Usuario.GERENTE_EXECUTIVO);
            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

    @Test
    @Title("GO sem parecerista")
    public void testeIReceberIsencaoDeIcmsDiversoGESemPareceristaCNPJ() throws Throwable {

        try {

            usuario.receberPedidoDeIsencaoDeIcms(Usuario.ACESSOR_DE_PROTOCOLO, Dados.CNPJ_NAO_CONTRIBUINTE);
            usuario.distribuirParecerGOBFSemParecerista(Usuario.GERENTE_EXECUTIVO);
            usuario.distribuirEAssinarParecerGOBF(Usuario.GERENTE_OPERACIONAL);
            usuario.assinarMinutaParecerDaGerenciaExecutiva(Usuario.GERENTE_EXECUTIVO);
            usuario.assinarMinutasDosPareceresDecisorioEFinal(Usuario.ACESSOR_DE_PROTOCOLO);

        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);
        }
    }

}
