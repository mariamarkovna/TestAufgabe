package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    static SelenideElement userField = $(By.name("username"));
    static SelenideElement passwordField = $(By.name("password"));
    static SelenideElement loginButton = $(By.name("button"));

    public void login(String userName, String password) {
        $(userField).val(userName);
        $(passwordField).val(password);
        $(loginButton).click();
    }
}