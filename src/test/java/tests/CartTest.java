package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    //Добавление в корзину Рюкзака и Флисовой кофты, проверка их наличия в корзине.
    @Test
    public void checkCartForAddedGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.moveToCartPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.isProductDisplayedInCart("Sauce Labs Backpack"), "Товар Backpack не отображается в корзине");
        softAssert.assertTrue(cartPage.isProductDisplayedInCart("Sauce Labs Fleece Jacket"), "Товар Fleece Jacket не отображается в корзине");
        softAssert.assertAll();
    }

    //Удаление товара в корзине, проверка отображения товаров в корзине.
    @Test
    public void removeGoodsFromCartPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.moveToCartPage();
        cartPage.RemoveFromCartButton("Sauce Labs Onesie");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.isProductDisplayedInCart("Sauce Labs Bolt T-Shirt"), "Товар Bolt T-Shirt не отображается в корзине");
        softAssert.assertFalse(cartPage.isProductDisplayedInCart("Sauce Labs Onesie"), "Товар Onesie отображается в корзине");
        softAssert.assertAll();
    }
    
}
