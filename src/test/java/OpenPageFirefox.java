import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class OpenPageFirefox {

    WebDriver driver;

    @BeforeEach
    public void before() {
        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equals("gecko")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            FirefoxOptions capabilities = new FirefoxOptions();
            capabilities.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(capabilities);
        }
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com/");
        assertEquals("Google", driver.getTitle());
    }

    @Test
    public void openYoutube() {
        driver.get("https://www.youtube.com/");
        assertEquals("YouTube", driver.getTitle());
    }

    @Test
    public void openVoutube() {
        driver.get("https://www.facebook.com/");
        assertEquals("Facebook - log in or sign up", driver.getTitle());
    }
}

