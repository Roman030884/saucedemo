package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CARD = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    private static final By PRODUCT_SORT_CONTAINER = By.className("product_sort_container");
    private static final By INVENTORY_CONTAINER = By.className("inventory_item_name");
    private static final By REACT_BURGER_MENU= By.id("react-burger-menu-btn");
    private static final By ABOUT_SIDEBAR_LINK= By.xpath("//*[text()='About']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void buyProduct(String productName) {

        driver.findElement(By.xpath(String.format(ADD_TO_CARD, productName))).click();
    }
    public List<WebElement> choiceNameAtoZ () {
        driver.findElement(PRODUCT_SORT_CONTAINER).click();
        Select dropdown = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropdown.selectByVisibleText("Name (A to Z)");
        List<WebElement> expectedAtoZ = driver.findElements(INVENTORY_CONTAINER);
        return expectedAtoZ;
    }


//    public String choiceNameZtoA() {
//        driver.findElement(PRODUCT_SORT_CONTAINER).click();
//        Select dropdown = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
//        dropdown.selectByVisibleText("Name (Z to A)");
//        return driver.findElements(INVENTORY_CONTAINER).toString();
//    }
//
//    public void choiceLowToHigh() {
//        driver.findElement(PRODUCT_SORT_CONTAINER).click();
//        Select dropdown = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
//        dropdown.selectByVisibleText("Price (low to high)");
//    }
//
//    public void choiceHighToLow() {
//        driver.findElement(PRODUCT_SORT_CONTAINER).click();
//        Select dropdown = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
//        dropdown.selectByVisibleText("Price (high to low)");
//    }

    public List<WebElement> getElementList() {
         List<WebElement> actual = driver.findElements(INVENTORY_CONTAINER);
         return actual ;
    }

    public void choiceAbout(){
        driver.findElement(REACT_BURGER_MENU).click();
        driver.findElement(ABOUT_SIDEBAR_LINK).click();

    }
    public static Boolean reviveList(List<WebElement> list){

        String previous = ""; // empty string: guaranteed to be less than or equal to any other

        for (final WebElement current: list) {
            if (current.getText().compareTo(previous) < 0)
                return false;
            previous = current.getText();
        }
        return true;
    }
}