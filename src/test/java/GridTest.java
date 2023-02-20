import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public void testF() throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.140:4444/wd/hub"), capabilities);
        driver.get("https://uk-ua.facebook.com/");
        Assertions.assertTrue(driver.getTitle().contains("Facebook"));
        Thread.sleep(5000);
        driver.quit();
    }
}
