package testes_web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private final WebDriver driver;

    // Locators
    private final By myAccountTitle = By.xpath("//span[@class='base'][contains(.,'My Account')]");
    private final By loggedAccountSpan = By.cssSelector("logged-in");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getMyAccountTitleLocator() {
        return myAccountTitle;
    }

    public By getLoggedAccountSpanLocator() {
        return loggedAccountSpan;
    }

    public boolean isDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}