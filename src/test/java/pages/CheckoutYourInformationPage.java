package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {
    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");
    private static final By CANCEL_BUTTON = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/a");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input");
    public static final By CHECKOUT_OVERVIEW_PAGE_NAME_ = By.className("subheader");
    private static final By ERROR_MESSAGE = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3");


    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void inputData(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void returnYourCartPage() {

        driver.findElement(CANCEL_BUTTON).click();
    }

    public void openCheckoutYourInformationPage() {

        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();

    }

    public String elementCheckoutOverview() {

        return driver.findElement(CHECKOUT_OVERVIEW_PAGE_NAME_).getText();
    }
}
