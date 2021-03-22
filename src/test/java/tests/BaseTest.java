package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    YourCartPage yourCartPage;
    ProductsPage productsPage;
    LoginPage loginPage;
    OverviewPage overviewPage;
    CheckoutYourInformationPage checkoutYourInformationPage;
    FinishPage finishPage;

    @BeforeClass
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        yourCartPage = new YourCartPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        overviewPage = new OverviewPage(driver);
        finishPage = new FinishPage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
