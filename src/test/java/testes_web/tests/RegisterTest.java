package testes_web.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import testes_web.config.BaseTest;
import testes_web.models.User;
import testes_web.pages.CustomerLoginPage;
import testes_web.pages.HomePage;
import testes_web.pages.RegistrationPage;
import testes_web.utils.ConfigUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web Tests")
@Feature("Register Tests")
public class RegisterTest extends BaseTest {

    Faker faker = new Faker();

    @Test
    @Description("Test valid presence form to register")
    @Severity(SeverityLevel.NORMAL)
    void testRegistrationFormFieldsPresence() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkCreateAccount();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Validar se formulário existe e está completo
        assertTrue(registrationPage.isDisplayed(registrationPage.getFirstNameFieldLocator()), "Campo Nome não está presente.");
        assertTrue(registrationPage.isDisplayed(registrationPage.getLastNameFieldLocator()), "Campo Sobrenome não está presente.");
        assertTrue(registrationPage.isDisplayed(registrationPage.getEmailFieldLocator()), "Campo Email não está presente.");
        assertTrue(registrationPage.isDisplayed(registrationPage.getPasswordFieldLocator()), "Campo Senha não está presente.");
        assertTrue(registrationPage.isDisplayed(registrationPage.getConfirmPasswordFieldLocator()), "Campo Confirmar Senha não está presente.");
    }

    @Test
    @Description("Test valid register")
    @Severity(SeverityLevel.NORMAL)
    void testValidRegistration() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkCreateAccount();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Criar objeto User com apenas email e password preenchidos
        User user = new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(ConfigUtil.get("passwordSuccess"));

        // Preencher o formulário completo
        registrationPage.fillRegistrationForm(user);

        // Submeter o formulário
        registrationPage.submitForm();

        // Validar que a mensagem de sucesso foi exibida
        assertTrue(registrationPage.isDisplayed(registrationPage.getMessageSuccessAlertLocator()), "Mensagem de sucesso não foi exibida.");
    }

    @Test
    @Description("Test valid to register partial")
    @Severity(SeverityLevel.NORMAL)
    void testPartialRegistrationWithEmailAndPassword() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkCreateAccount();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Criar objeto User com apenas email e password preenchidos
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(ConfigUtil.get("passwordSuccess"));

        // Preencher o formulário e submeter
        registrationPage.fillRegistrationForm(user);
        registrationPage.submitForm();

        // Validar comportamento do sistema
        assertTrue(registrationPage.isDisplayed(registrationPage.getFirstNameRequiredFieldLocator()));
        assertEquals(registrationPage.getMessageErrorAlertLocator(registrationPage.getFirstNameRequiredFieldLocator()), ConfigUtil.get("requiredField"));

        assertTrue(registrationPage.isDisplayed(registrationPage.getLastNameRequiredFieldLocator()));
        assertEquals(registrationPage.getMessageErrorAlertLocator(registrationPage.getLastNameRequiredFieldLocator()), ConfigUtil.get("requiredField"));

    }

}