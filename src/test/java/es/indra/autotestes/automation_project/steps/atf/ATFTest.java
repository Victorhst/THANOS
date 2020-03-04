package es.indra.autotestes.automation_project.steps.atf;

import es.indra.autotestes.automation_project.factory.DriverFactory;
import es.indra.autotestes.automation_project.factory.DriverType;
import es.indra.autotestes.automation_project.pages.atf.ATFPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ATFTest {

    private static WebDriver driver;

    @Before
    public static void setup() {

        driver = DriverFactory.getDriver(DriverType.FIREFOX);
    }

    @Test
    public void teste() {
        ATFPage.usando(driver)
                .navegarLoginIntegracao()
                .loginPadrao("alsilva", "asd02asd")
                .verificarLogin();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
