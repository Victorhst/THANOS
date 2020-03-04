package es.indra.autotestes.automation_project.steps.efisco;

import es.indra.autotestes.automation_project.factory.DriverFactory;
import es.indra.autotestes.automation_project.factory.DriverType;
import es.indra.autotestes.automation_project.pages.efisco.LoginPage;
import es.indra.autotestes.automation_project.pages.efisco.ReceberIsencaoIcmsDiversosPage;
import es.indra.autotestes.automation_project.utils.Dados;
import es.indra.autotestes.automation_project.utils.Excecoes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class StepsOld {

    private static WebDriver driver;
    private static String url = Dados.URL_LOGIN;
    LoginPage login = new LoginPage(driver);
    //PaginaPrincipalPage				menu = new PaginaPrincipalPage(driver);
    ReceberIsencaoIcmsDiversosPage isencaoIcms = new ReceberIsencaoIcmsDiversosPage(driver);

    @BeforeClass
    public static void setup() {

        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
        driver.quit();
    }

	/*@Step
	public void receberPedidoIsencaoIcms() throws Throwable {

		try {

			ReceberIsencaoIcmsDiversosPage.usando(driver)
					.navegarAoPedidoIsencaoIcmsDiversos()
					.verificarPaginaRecebimentoIsencao();

		} catch (Throwable e) {

			Excecoes.tratarExcecoes(e);

		} // try-catch

	} // receberPedidoIsencaoIcms()
	
	@Step
	public void submeterDocumentacaoObrigatoria() throws Throwable {
		
		try {
			
			ReceberIsencaoIcmsDiversosPage.usando(driver)
					.informarCpfInteressado("37184516893")
					.submeterDocumentacaoObrigatoria(
					"C:\\Users\\victor.teixeira\\Downloads\\teste.pdf")
					.verificarResultadoOperacao();
			
		} catch (Throwable e) {
			
			Excecoes.tratarExcecoes(e);
			
		}
		
	}*/

    @Test
    public void realizarLoginEfisco()
            throws Throwable {

        try {

			/*LoginPage.usando(driver)
					.realizarLogin(url, "forte", "asd01asd")
					.verificarLogin();*/

            //login.verificarLogin();
			/*login.realizarLogin(url, "forte", "asd01asd");
			menu.navegarAoPedidoIsencaoIcmsDiversos();
			isencaoIcms.informarCpfInteressado("37184516893");
			isencaoIcms.submeterDocumentacaoObrigatoria("C:\\Users\\victor.teixeira\\Downloads\\teste.pdf");*/


        } catch (Throwable e) {

            Excecoes.tratarExcecoes(e);

        } // try-catch

    } // realizarLoginEfisco()

}
