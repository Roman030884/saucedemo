package tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class LoginTest extends BaseTest {

    @Test (retryAnalyzer = Retry.class)
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test (retryAnalyzer = Retry.class)
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(),
                "Error message is not correct",
                "Error message is not correct");
    }

}
