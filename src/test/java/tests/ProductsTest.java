package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.ProductsPage.reviveList;

public class ProductsTest extends BaseTest {
    public static final String  LABEL ="//span[text()='Sign in']";

    @BeforeMethod
    public void setUpProductsTest(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

    }

//    @Test (retryAnalyzer = Retry.class)
//    public void productsShouldBeAvailableInCart() {
//        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
//        productsPage.buyProduct("Sauce Labs Fleece Jacket");
//
//    }

    @Test (retryAnalyzer = Retry.class)
    public void shouldBeSortByAlphabeticalOrderAtoZ (){

        Assert.assertTrue (reviveList(productsPage.choiceNameAtoZ()),
               "Sort by alphabetical order   from A to Z is failed to execute");
    }



      @Test (retryAnalyzer = Retry.class)
    public void shouldBeGoPageAbout(){
        productsPage.choiceAbout();
        String signIn = driver.findElement(By.xpath(LABEL)).getText();
          Assert.assertEquals("Sign in",signIn,
                  "You did not gou to page (SAUCELABS)");

      }
}

