package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage extends BasePage {

    private static final By REMOVE_BUTTON = By.xpath("//button[text()='REMOVE']");
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]");
    private static final By CHECKOUT_SHOPPING_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    private static final By ICON_CART = By.tagName("path");
    private static final String URL_OPEN_YOUR_CART_PAGE ="https://www.saucedemo.com/cart.html";

    public YourCartPage(WebDriver driver) {

        super(driver);
    }

    public void goInCheckoutPage() {

        driver.findElement(ICON_CART).click();
    }

    public void remove() {

        driver.findElement(REMOVE_BUTTON).click();
    }

    public void goInPageCheckoutYourInformation() {

        driver.findElement(CHECKOUT_SHOPPING_BUTTON).click();
    }

    public void openPageYourCart() {

        driver.get(URL_OPEN_YOUR_CART_PAGE);
    }

    public void returnInPageProducts() {

        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

}