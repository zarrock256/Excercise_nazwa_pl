package Actions;

import Entities.Config;
import Entities.Driver;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageActions {

    public static void typeLoginAndPasswordFromJsonAndSubmit(Driver driver, Config config) {
        driver.findByXpath(MainPage.CLIENTS_PANEL)
                .click();
        driver.findByXpath(LoginPage.LOGIN_INPUT)
                .sendKeys(config.getAttribute("login"));
        driver.findByXpath( LoginPage.PASSWORD_INPUT)
                .sendKeys(config.getAttribute("password"));
        driver.findByXpath(LoginPage.SUBMIT_BUTTON)
                .click();
    }
}
