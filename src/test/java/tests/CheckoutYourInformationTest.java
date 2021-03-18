package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.CheckoutYourInformationPage.CHECKOUT_OVERVIEW_PAGE_NAME_;

public class CheckoutYourInformationTest extends BaseTest {

    @BeforeMethod
    public void setUpCheckoutYourInformationTest(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkoutYourInformationPage.openCheckoutYourInformationPage();

    }

    @Test (retryAnalyzer = Retry.class)
    public void checkGoInCheckoutOverviewPage() {
        checkoutYourInformationPage.inputData("Roman", "Ivanov", "789");
        String namePage = driver.findElement(CHECKOUT_OVERVIEW_PAGE_NAME_).getText();
        Assert.assertEquals(namePage,"Checkout: Overview",
                "The transition to a new page (Checkout: Overview) was not completed");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkReturnYourCartPage() {
        checkoutYourInformationPage.returnYourCartPage();
        Assert.assertEquals(checkoutYourInformationPage.elementCheckoutOverview(),
                "Your Cart",
                "The transition to a new page (Your Cart) was not completed");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkFormFieldFirstNameEmpty() {
        checkoutYourInformationPage.inputData("", "Ivanov", "789");
        Assert.assertEquals("Error: First Name is required", checkoutYourInformationPage.getErrorMessage(),
                "The error notification doesn't work");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkFormFieldLastNameEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("Roman", "", "789");
        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(),
                "Error: Last Name is required",
                "The error notification doesn't work");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkFormFieldPostalCodeEmpty() {
        checkoutYourInformationPage.inputData("Roman", "Ivanov", "");
        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(),
                "Error: Postal Code is required" ,
                "The error notification doesn't work");
    }
    @Test (retryAnalyzer = Retry.class)
    public void checkFormFieldPostalCodeSpace() {
        checkoutYourInformationPage.inputData("Roman", "Ivanov", " ");
        Assert.assertEquals(checkoutYourInformationPage.elementCheckoutOverview(),
                "Checkout: Overview" ,
                "The error notification work");
    }
    @Test (retryAnalyzer = Retry.class)
    public void checkFormFieldFirstNameSpace() {
        checkoutYourInformationPage.inputData(" ", "Ivanov", "789");
        Assert.assertEquals(checkoutYourInformationPage.elementCheckoutOverview(),
                "Checkout: Overview" ,
                "The error notification work");
    }
    @Test (retryAnalyzer = Retry.class)
    public void checkFormFieldLastNameSpace() {
        checkoutYourInformationPage.inputData("Roman", " ", "789");
        Assert.assertEquals(checkoutYourInformationPage.elementCheckoutOverview(),
                "Checkout: Overview" ,
                "The error notification work");
    }
}