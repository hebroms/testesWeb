package testes_web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;

    // Locators
    private final By createAccountLink = By.xpath("(//a[contains(.,'Create an Account')])[1]");
    private final By signInLink = By.xpath("(//a[contains(.,'Sign In')])[1]");
    private final By loggedAccountSpan = By.xpath("(//span[@class='logged-in'])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkCreateAccount() {
        driver.findElement(createAccountLink).click();
    }

    public void clickLinkSignIn() {
        driver.findElement(signInLink).click();
    }

    public By getLoggedAccountSpanLocator() {
        return loggedAccountSpan;
    }

    public boolean isDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

}