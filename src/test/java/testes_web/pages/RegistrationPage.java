package testes_web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testes_web.models.User;

public class RegistrationPage {

    private final WebDriver driver;

    // Locators
    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By emailField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("password-confirmation");

    private final By firstNameRequiredField = By.id("firstname-error");
    private final By lastNameRequiredField = By.id("lastname-error");
    private final By emailRequiredField = By.id("email_address-error");
    private final By passwordRequiredField = By.id("password-error");
    private final By confirmPasswordRequiredField = By.id("password-confirmation-error");

    private final By submitButton = By.cssSelector("button.submit");
    private final By messageSuccessAlert = By.cssSelector(".message-success");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getFirstNameFieldLocator() {
        return firstNameField;
    }

    public By getLastNameFieldLocator() {
        return lastNameField;
    }

    public By getEmailFieldLocator() {
        return emailField;
    }

    public By getPasswordFieldLocator() {
        return passwordField;
    }

    public By getConfirmPasswordFieldLocator() {
        return confirmPasswordField;
    }

    public By getMessageSuccessAlertLocator() {
        return messageSuccessAlert;
    }

    public By getFirstNameRequiredFieldLocator() {
        return firstNameRequiredField;
    }

    public By getLastNameRequiredFieldLocator() {
        return lastNameRequiredField;
    }

    public By getEmailRequiredFieldLocator() {
        return emailRequiredField;
    }

    public By getPasswordRequiredFieldLocator() {
        return passwordRequiredField;
    }

    public By getConfirmPasswordRequiredFieldLocator() {
        return confirmPasswordRequiredField;
    }

    public String getMessageErrorAlertLocator(By element) {
        return driver.findElement(element).getText();
    }

    public void fillRegistrationForm(User user) {
        if (user.getFirstName() != null) {
            driver.findElement(firstNameField).sendKeys(user.getFirstName());
        }
        if (user.getLastName() != null) {
            driver.findElement(lastNameField).sendKeys(user.getLastName());
        }
        if (user.getEmail() != null) {
            driver.findElement(emailField).sendKeys(user.getEmail());
        }
        if (user.getPassword() != null) {
            driver.findElement(passwordField).sendKeys(user.getPassword());
            driver.findElement(confirmPasswordField).sendKeys(user.getPassword());
        }
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}