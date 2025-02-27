package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameField = By.cssSelector("[data-test=username]");
    By passwordField = By.cssSelector("[data-test=password]");
    By loginButton = By.cssSelector("[data-test=login-button]");
    By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы LoginPage")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Вход в систему с логином: {username} и паролем: {password}")
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}