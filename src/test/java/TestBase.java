import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class TestBase {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    String browser;

    @BeforeMethod()
    public void setUp() {
        String path;
        browser = System.getProperty("browser");
        if ("FIREFOX".equalsIgnoreCase(browser)) {
            path = System.getenv("firefoxDriver");
            System.getProperty("webdriver.gecko.driver", path);
            driver = new FirefoxDriver();
        } else if ("EDGE".equalsIgnoreCase(browser)) {
            path = System.getenv("edgeDriver");
            System.getProperty("webdriver.edge.driver", path);
            driver = new EdgeDriver();
        }
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}

