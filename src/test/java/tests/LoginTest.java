package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.titleMessage(),
                "Products",
                "Страница с продуктами не открыта или заголовок не соответствует ожидаемому");
    }

    @Test
    public void loginInvalidUsername() {
        loginPage.open();
        loginPage.login("NOTstandard_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не отобразилось или не совпадает с ожидаемым");
    }

}
