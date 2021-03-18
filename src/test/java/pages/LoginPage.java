package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By LOGIN_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    private static final String URL_OPEN_LOGIN_PAGE = "https://www.saucedemo.com";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_OPEN_LOGIN_PAGE);
    }

    public void login(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}

