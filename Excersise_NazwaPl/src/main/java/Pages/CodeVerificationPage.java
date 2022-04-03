package Pages;

import org.openqa.selenium.By;

public class CodeVerificationPage {
    public static final By CODE_NUMBER = By.xpath("//span[@class=\"codeNumber\"]");
    public static final By CODE_INPUT = By.xpath("//input[@class=\"authenticationCode\"]");
    public static final By LOG_IN = By.xpath("//input[@class=\"na-button submit submitLogin\"]");
}
