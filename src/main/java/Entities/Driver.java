package Entities;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Driver extends ChromeDriver {

    public static int SHORT_WAIT = 30;
    public static int MEDIUM_WAIT = 60;
    public static int LONG_WAIT = 180;


    public Driver(){ super(); }

    public WebElement findByXpath(By by) {
        try {
            FluentWait wait = new FluentWait(this);
            wait.withTimeout(Duration.ofSeconds(SHORT_WAIT))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(ElementNotInteractableException.class, NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return this.findElement(by);
        }catch(Exception e){
            Assertions.fail("Element located by " + by.toString() + " couldn't be found");
            return null;
        }
    }

    public List<WebElement> findAllByXpath(By by) {
        try {
            FluentWait wait = new FluentWait(this);
            wait.withTimeout(Duration.ofSeconds(SHORT_WAIT))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(ElementNotInteractableException.class, NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return this.findElements(by);
        }catch(Exception e){
            Assertions.fail("Element located by " + by.toString() + " couldn't be found");
            return null;
        }
    }

    public void closeSecondTabAndSwitchToTheFirstOne() {
        ArrayList<String> tabs = new ArrayList<> (this.getWindowHandles());
        try {
            this.switchTo().window(tabs.get(1))
                    .close();
            this.switchTo().window(tabs.get(0));
        }catch(IndexOutOfBoundsException e){
            Assertions.fail("There is only one tab opened, can't close the second one.\n" + e);
        }
    }

    public void openNewTabAndGetURL(String url) {

        FluentWait wait = new FluentWait(this);
        wait.withTimeout(Duration.ofSeconds(SHORT_WAIT))
                .pollingEvery(Duration.ofMillis(500));
        this.switchTo().newWindow(WindowType.TAB);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        this.get(url);
    }


    public void exit() {
        this.close();
        this.quit();
    }


}
