package Pages;

import org.openqa.selenium.By;

public class MainPage {
    public static By CLIENTS_PANEL = By.xpath("//a[contains(text(), \"Panel Klienta\")]");
    public static String CLIENTS_NICK = "//span[contains(text(), \"%s\")]";
}
