package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    //Добавление в корзину Рюкзака и Флисовой кофты, проверка их наличия в корзине.
    @Test
    public void checkCartForAddedGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addBackpack();
        productsPage.addFleeceJacket();
        productsPage.moveToCartPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("item_4_title_link")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("item_5_title_link")).isDisplayed());
        softAssert.assertAll();
    }
}
