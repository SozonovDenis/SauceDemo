package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    String inCartProductPattern = "//div[text()='%s']";
    String RemoveFromCartButtonPattern = "//div[text()='%s']//ancestor::div[@class='cart_item_label']//button";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isProductDisplayedInCart(String product) {
        return !driver.findElements(By.xpath(String.format(inCartProductPattern, product))).isEmpty();
    }

    @Step("Удаление товара с названием {product}")
    public void RemoveFromCartButton(String product) {
        driver.findElement(By.xpath(String.format(RemoveFromCartButtonPattern, product))).click();
    }
}