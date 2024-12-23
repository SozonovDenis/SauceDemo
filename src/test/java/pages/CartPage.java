package pages;

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
        Boolean isProductDisplayed = !driver.findElements(By.xpath(String.format(inCartProductPattern, product))).isEmpty();
        return isProductDisplayed;
    }

    public void RemoveFromCartButton(String product) {
        driver.findElement(By.xpath(String.format(RemoveFromCartButtonPattern, product))).click();
    }

}