package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[class='title']");
    By firstAddToCartButton = By.cssSelector("[id*='add-to-cart-sauce-labs']");
    By firstRemoveButton = By.cssSelector("[id*='remove-sauce-labs']");
    By goodsCounterBadge = By.cssSelector("[class='shopping_cart_badge']");
    By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    By addFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By cartIcon = By.cssSelector("[class='shopping_cart_link']");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String titleMessage() {
        return driver.findElement(title).getText();
    }

    public void addGoods(int goodsCount) {
        for (int i = 0; i < goodsCount; i++) {
            driver.findElement(firstAddToCartButton).click();
        }
    }

    public void removeGoods(int goodsCount) {
        for (int i = 0; i < goodsCount; i++) {
            driver.findElement(firstRemoveButton).click();
        }
    }

    public String getGoodsCount() {
        return driver.findElement(goodsCounterBadge).getText();
    }

    public void addBackpack() {
        driver.findElement(addBackpackButton).click();
    }

    public void addFleeceJacket() {
        driver.findElement(addFleeceJacket).click();
    }

    public void moveToCartPage() {
        driver.findElement(cartIcon).click();
    }

}
