package testes_web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testes_web.models.User;

public class CustomerLoginPage {

    private final WebDriver driver;

    // Locators
    private final By customerLoginTitle = By.xpath("//span[@class='base'][contains(.,'My Account')]");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("pass");
    private final By submitButton = By.id("send2");
    private final By messageError = By.cssSelector(".message-error");
    private final By messageErrorAlert = By.xpath("//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]");
    private final By messageErrorPasswordField = By.id("pass-error");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getMessageErrorLocator() {
        return messageError;
    }

    public By getMessageErrorAlertLocator() {
        return messageErrorAlert;
    }

    public By getMessageErrorPasswordFieldLocator() {
        return messageErrorPasswordField;
    }

    public String getMessage(By element) {
        return driver.findElement(element).getText();
    }

    public void fillLoginForm(User user) {
        if (user.getEmail() != null) {
            driver.findElement(emailField).sendKeys(user.getEmail());
        }
        if (user.getPassword() != null) {
            driver.findElement(passwordField).sendKeys(user.getPassword());
        }
    }

    public void submitLogin() {
        driver.findElement(submitButton).click();
    }

    public boolean isDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}