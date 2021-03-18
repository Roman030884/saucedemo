package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static pages.OverviewPage.countTax;

public class OverviewTest extends BaseTest {

    private static final double TAX_RATE = 1.08;
    public static final String DIV_CLASS_SUMMARY_SUBTOTAL_LABEL = "//div[@class=\"summary_subtotal_label\"]";
    public static final String DIV_CLASS_SUMMARY_TAX_LABEL = "//div[@class=\"summary_tax_label\"]";
    public static final String DIV_CLASS_SUMMARY_TOTAL_LABEL = "//div[@ class=\"summary_total_label\"]";

    @BeforeMethod
    public void setUpOverviewTest()  {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        yourCartPage.goInCheckoutPage();
        yourCartPage.goInPageCheckoutYourInformation();
        checkoutYourInformationPage.inputData("Roman", "Ivanov", "789");
    }

    @Test(retryAnalyzer = Retry.class)
    public void aShouldBeGetSumItemTotal()  {
        String itTot = driver.findElement(By.xpath(DIV_CLASS_SUMMARY_SUBTOTAL_LABEL)).getText();
        double sumItemTotal = Double.parseDouble(itTot.substring(13));
        double itemTotal = overviewPage.countItemTotal();
        Assert.assertEquals(itemTotal, sumItemTotal,
                "The summa of products  do not match " +
                        "the summa in the field (Item total) in the internet shop");

    }

    @Test(retryAnalyzer = Retry.class)
    public void cShouldBeGetTax() {
        String taxProducts = driver.findElement(By.xpath(DIV_CLASS_SUMMARY_TAX_LABEL)).getText();
        double taxShop = Double.parseDouble(taxProducts.substring(6));
        double tax = countTax(overviewPage.countItemTotal(), TAX_RATE);
        Assert.assertEquals(new BigDecimal(tax).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                new BigDecimal(taxShop).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                "The summa of tax  do not match " +
                        "the summa of tax in the field (Tax) in the internet shop");
    }

    @Test(retryAnalyzer = Retry.class)
    public void fShouldBeGetTotal() {
        String totalProducts = driver.findElement(By.xpath(DIV_CLASS_SUMMARY_TOTAL_LABEL)).getText();
        double totalShop = Double.parseDouble(totalProducts.substring(8));
        double total = overviewPage.countTotal(TAX_RATE);
        Assert.assertEquals(new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                new BigDecimal(totalShop).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                "The total of products  do not match the total " +
                        "in the field (Total) in the internet shop");
    }

    @Test(retryAnalyzer = Retry.class)
    public void bShouldBeGoToTheFinishPage()  {
        loginAndGoToOverview();
        overviewPage.goToTheFinishPage();
        String finish = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(finish, "Finish", " You did not gou to page (Finish) ");

    }

    @Test(retryAnalyzer = Retry.class)
    public void dShouldBeGoToTheProductPage() {
        overviewPage.goToTheProductsPage();
        String product = driver.findElement(By.className("product_label")).getText();
        Assert.assertEquals(product, "Products", " You did not gou to page (Products) ");
    }

    private void loginAndGoToOverview() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        overviewPage.openOverviewPage();
    }
}
