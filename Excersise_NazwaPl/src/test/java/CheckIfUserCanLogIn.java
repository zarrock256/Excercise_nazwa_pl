import Actions.LoginPageActions;
import Entities.Config;
import Entities.Driver;
import Pages.CodeVerificationPage;
import Pages.LoginPage;
import Pages.MailBoxPage;
import Pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.ArrayList;


public class CheckIfUserCanLogIn {
    private Driver driver;
    private Config config;


    @BeforeEach
    public void prepareEntryConditions() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new Driver();
        config = new Config("C:\\Users\\Kamil\\Desktop\\Excersise_NazwaPl\\src\\main\\resources\\confs\\data.json");
        driver.manage().window().maximize();
    }

    @Test
    public void CheckIfUserCanLogInTest() {
        driver.get(config.getAttribute("nazwaPlUrl"));
        LoginPageActions.typeLoginAndPasswordFromJsonAndSubmit(driver);
        String codeNumber = driver.findByXpath(CodeVerificationPage.CODE_NUMBER)
                .getText();

        driver.findByXpath(CodeVerificationPage.CODE_INPUT)
                .sendKeys(getMailCode(codeNumber));
        driver.findByXpath(CodeVerificationPage.LOG_IN)
                .click();

        Assertions.assertEquals(String.format(MainPage.CLIENTS_NICK, config.getAttribute("login")), config.getAttribute("login"));

        //driver.closeAndQuit();
    }

    private String getMailCode(String codeNumber) {
        driver.openNewTabAndGetURL(config.getAttribute("mailUrl"));
        driver.findByXpath(MailBoxPage.EMAIL_INPUT)
                .sendKeys(config.getAttribute("mailLogin"));
        driver.findByXpath(MailBoxPage.NEXT_BUTTON)
                .click();
        driver.findByXpath(MailBoxPage.PASSWORD_INPUT)
                .sendKeys(config.getAttribute("mailPassword"));
        driver.findByXpath(MailBoxPage.NEXT_BUTTON)
                .click();
        driver.findByXpath(By.xpath(String.format(MailBoxPage.CODE_SPAN, codeNumber)))
                .click();
        String code = driver.findAllByXpath(MailBoxPage.CODE_NUMBER)
                .get(0).getText();
        driver.closeSecondTabAndSwitchToTheFirstOne();
        return code;
    }

}
