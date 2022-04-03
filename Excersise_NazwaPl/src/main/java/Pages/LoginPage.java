package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public class LoginPage {
    public static By LOGIN_WIDGET = By.xpath("//h2[contains(text(), \"Zaloguj się\")]//ancestor::form");
    public static By LOGIN_INPUT = new ByChained(LOGIN_WIDGET, By.xpath(".//input[@class=\"login\"]"));
    public static By PASSWORD_INPUT = new ByChained(LOGIN_WIDGET, By.xpath(".//input[@class=\"password\"]"));
    public static By SUBMIT_BUTTON = new ByChained(LOGIN_WIDGET, By.xpath(".//input[@class=\"na-button submit\"]"));
}
