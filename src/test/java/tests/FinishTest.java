package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.FinishPage.TEXT_DELIVERY;
import static pages.FinishPage.TEXT_THANKS;

public class FinishTest extends BaseTest {

    @BeforeMethod
    public void setUpFinishTest(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        finishPage.openFinishPage();
    }

    @Test(retryAnalyzer = Retry.class)
    public void shouldBeFindTextWithGratitude() {
        String thanks = driver.findElement(TEXT_THANKS).getText();
        Assert.assertEquals(thanks, "THANK YOU FOR YOUR ORDER", "The gratitude for order text   " +
                "was not found or the context doesn't match");

    }

    @Test(retryAnalyzer = Retry.class)
    public void shouldBeFindTextAboutDelivery() {
        String thanks = driver.findElement(TEXT_DELIVERY).getText();
        Assert.assertEquals(thanks, "Your order has been dispatched, and will arrive just " +
                "as fast as the pony can get there!", "The gratitude for order text   " +
                "was not found or the context doesn't match");
    }

}
