package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OverviewPage extends BasePage {

    private static final By BUTTON_CANCEL = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[1]");
    private static final By BUTTON_FINISH = By.xpath("//a[contains(text(),'FINISH')]");
    private static final By PRODUCT_1 = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]");
    private static final By PRODUCT_2 = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2] ");
    private static final String URL_OVERVIEW ="https://www.saucedemo.com/checkout-step-two.html";


    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public Double countItemTotal() {
        return getPriceByLocator(PRODUCT_1) + getPriceByLocator(PRODUCT_2);
    }

    public static Double countTax(Double sum, Double taxRate) {
        return (sum * taxRate) - sum;
    }

    public Double countTotal(Double taxRate) {
        return countItemTotal() * taxRate;
    }

    public void openOverviewPage() {
        driver.get(URL_OVERVIEW);
    }

    public void goToTheFinishPage() {
        driver.findElement(BUTTON_FINISH).click();
    }

    public void goToTheProductsPage() {
        driver.findElement(BUTTON_CANCEL).click();
    }

    private Double getPriceByLocator(By locator) {
        String PRODUCT1 = driver.findElement(locator).getText();
        String pr1 = PRODUCT1.substring(1);
        return Double.parseDouble(pr1);
    }

}
