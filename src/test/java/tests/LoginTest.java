package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Логин", retryAnalyzer = Retry.class)
    @Description("Логин")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("jira link")
    @Issue("Issue link")
    public void login() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.titleMessage(),
                "Products",
                "Страница с продуктами не открыта или заголовок не соответствует ожидаемому");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
                {"notstandard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test(testName = "Некорректный Логин", dataProvider = "LoginData")
    @Description("Некорректный Логин")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("jira link")
    @Issue("Issue link")
    public void login(String user, String password, String message) {
        loginPage.open();
        loginPage.login("NOTstandard_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не отобразилось или не совпадает с ожидаемым");
    }
}
