package Pages;

import org.openqa.selenium.By;

public class MailBoxPage {
    public static final By EMAIL_INPUT = By.xpath("//input[@type=\"email\"]");
    public static final By NEXT_BUTTON = By.xpath("//span[contains(text(), \"Dalej\")]");
    public static final By PASSWORD_INPUT = By.xpath("//div[contains(text(), \"test.testowski66@gmail.com\")]//ancestor::div//input[@type='password']");
    public static String CODE_SPAN = "//span[contains(text(), \"Szanowny Kliencie, Twój kod jednorazowy nr %s\")]//ancestor::tr";
    public static final By CODE_NUMBER = By.xpath("//font[contains(text(),  \" Szanowny Kliencie\")]//ancestor::td//p");
}
