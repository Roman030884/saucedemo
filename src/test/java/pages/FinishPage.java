package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage {
    public static final By TEXT_THANKS = By.className("complete-header");
    public static final By TEXT_DELIVERY = By.className("complete-text");
    private static final String URL_OPEN_FINISH ="https://www.saucedemo.com/checkout-complete.html";

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public void openFinishPage() {

        driver.get(URL_OPEN_FINISH);
    }
}
