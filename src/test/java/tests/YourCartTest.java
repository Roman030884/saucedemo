package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class YourCartTest extends BaseTest {


    @BeforeMethod
    public void setUpYourCartTest(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        yourCartPage.goInCheckoutPage();
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkCountingOfOrderedProducts() {
        int numberOfOrders = driver.findElements(By.xpath("//button[text()='REMOVE']")).size();
        String counterCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        int counter = Integer.parseInt(counterCart);
        Assert.assertEquals(numberOfOrders, counter, " The number of orders in the customer's list " +
                "does not match the number of orders in the cart counter");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkButtonRemoveProduct() {
        yourCartPage.remove();
        int numberOfOrders = driver.findElements(By.xpath("//button[text()='REMOVE']")).size();
        String counterCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        int counter = Integer.parseInt(counterCart);
        Assert.assertEquals(numberOfOrders, counter, " The number of orders in the customer's list " +
                "does not match the number of orders in the cart counter");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkButtonCheckout() {
        yourCartPage.goInPageCheckoutYourInformation();
        String namePage = driver.findElement(By.id("first-name")).getAttribute("placeholder");
        Assert.assertEquals(namePage,"First Name" , "The transition to a new " +
                "page (Checkout: Your Information) was not completed");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkButtonContinueShopping() {
        yourCartPage.returnInPageProducts();
        String namePage = driver.findElement(By.className("product_label")).getText();
        Assert.assertEquals(namePage,"Products" , "The transition to a new " +
                "page (Products) was not completed");
    }

    @Test (retryAnalyzer = Retry.class)
    public void shouldBeInterInTheProductDescriptionPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        yourCartPage.goInCheckoutPage();
        driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).click();
        String backPage = driver.findElement(By.className("inventory_details_back_button"))
                .getText();
        Assert.assertEquals(backPage,"<- Back" , "The transition to a new " +
                "page (Description of product) was not completed");
    }
}