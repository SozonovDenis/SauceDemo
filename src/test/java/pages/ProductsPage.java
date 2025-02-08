package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[class='title']");
    By firstAddToCartButton = By.cssSelector("[id*='add-to-cart-sauce-labs']");
    By firstRemoveButton = By.cssSelector("[id*='remove-sauce-labs']");
    By goodsCounterBadge = By.cssSelector("[class='shopping_cart_badge']");
    By cartIcon = By.cssSelector("[class='shopping_cart_link']");
    String addToCartPattern = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String titleMessage() {
        return driver.findElement(title).getText();
    }

    @Step("Добавление товаров в корзину")
    public void addGoods(int goodsCount) {
        for (int i = 0; i < goodsCount; i++) {
            driver.findElement(firstAddToCartButton).click();
        }
    }

    @Step("Удаление товаров из корзины")
    public void removeGoods(int goodsCount) {
        for (int i = 0; i < goodsCount; i++) {
            driver.findElement(firstRemoveButton).click();
        }
    }

    public String getGoodsCount() {
        return driver.findElement(goodsCounterBadge).getText();
    }

    @Step("Нажатие на кнопку корзины")
    public void moveToCartPage() {
        driver.findElement(cartIcon).click();
    }

    @Step("Добавление товара с названием {product} в корзину")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartPattern, product))).click();
    }
}