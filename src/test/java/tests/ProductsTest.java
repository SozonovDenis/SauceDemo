package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    //Добавление товаров в корзину и удаление кнопкой на странице с товарами.
    @Test
    public void removeGoodsFromProductsPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addGoods(4);  //добавление 4 товаров
        productsPage.removeGoods(2); //удаление 2 товаров
        assertEquals(productsPage.getGoodsCount(),
                "2",
                "Кол-во товаров в корзине не совпадает с ожидаемым."); //сравнение ожидаемого количества товара со счетчиком на иконке корзины.
    }

}