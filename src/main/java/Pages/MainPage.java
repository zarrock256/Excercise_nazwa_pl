package Pages;

import org.openqa.selenium.By;

public class MainPage {
    public static By CLIENTS_PANEL = By.xpath("//a[contains(text(), \"Panel Klienta\")]");
    public static By CLIENTS_NICK = By.xpath("//div[@id=\"login_user_name\"]");
}
