package es.indra.autotestes.automation_project.factory;

import net.thucydides.core.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Fábrica de instâncias do WebDriver com a interface Supplier.			<br><br>
 * O método getDriver() recebe como parâmetro o tipo de navegador desejado e
 * invoca uma instância Supplier com o driver necessário para o navegador
 * solicitado. 															<br><br>
 * Essa classe atua como um singleton para o WebDriver, visto que só invoca a
 * instância do Supplier caso nâo haja um outro objeto do driver previamente
 * instanciado.
 *
 * @author victor.teixeira@receita.pb.gov.br
 * @author vhsilvat@indracompany.com
 */
public class DriverFactory extends WebDriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<DriverType, Supplier<WebDriver>>();
    private static final int TIMEOUT_SECONDS = 10;
    private static WebDriver driver;

    private DriverFactory() {
    }

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        if (driver == null) {
            // o path dos drivers foi modificado
            System.setProperty("webdriver.chrome.driver", "Utils.CHROME_DRIVER_PATH");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
        return driver;
    };
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        if (driver == null) {
            // o path dos drivers foi modificado
            System.setProperty("webdriver.gecko.driver", "Utils.FIREFOX_DRIVER_PATH");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
        return driver;
    };

    private static final Supplier<WebDriver> phantomJSDriverSupplier = () -> {
        if (driver == null) {
            // o path dos drivers foi modificado
            System.setProperty("phantomjs.binary.path", "Utils.PHANTOM_DRIVER_PATH");
            driver = new PhantomJSDriver();
            driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
        return driver;
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.PHANTOM, phantomJSDriverSupplier);
    }

    public static WebDriver getDriver(DriverType navegador) {
        return driverMap.get(navegador).get();
    }

}
