
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.open;


public class TestSite1LoginPage extends TestBase {

    String site = "https://thecompanytest1.de/";
    String loginPath = "Account/Login?culture=";

    @DataProvider(name = "UserData")
    public Object[][] getUserData() {
        return new Object[][]{
                {"de_DE", "", "Tset"},
                {"de_DE", "tset@company.de", ""},
                {"en_GB", "", "Tset"},
                {"en_GB", "tset@company.de", ""},
                {"fr_FR", "", "Tset"},
                {"fr_FR", "tset@company.de", ""},
                {"pl_PL", "", "Tset"},
                {"pl_PL", "tset@company.de", ""},

        };
    }

    @Test(dataProvider = "UserData")
    public void positiveLoginAllLangTest(Object[] UserData) {
        open(site + loginPath + (String) UserData[0]);
        loginPage.login("test@company.de", "Test");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, site, "Url is not expected");
    }

    @Test(dataProvider = "UserData")
    public void negativeLoginTest(String language, String user, String password) {
        open(site + loginPath + language);
        LoginPage loginPage = new LoginPage();
        loginPage.login(user, password);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(actualUrl, site, "Url is not expected");
    }
}