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
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    Faker faker = new Faker();

    @Test
    @Description("Test to logged")
    @Severity(SeverityLevel.NORMAL)
    void testValidLogged() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkSignIn();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        User user = new User();
        user.setEmail(ConfigUtil.get("username"));
        user.setPassword(ConfigUtil.get("password"));

        customerLoginPage.fillLoginForm(user);

        // Submeter o formulário
        customerLoginPage.submitLogin();

        // Validar que o usuário está Logado
        assertTrue(homePage.isDisplayed(homePage.getLoggedAccountSpanLocator()), "Usuário não está logado.");
    }

    @Test
    @Description("Test to try logged but invalid password")
    @Severity(SeverityLevel.NORMAL)
    void testInvalidPasswordLogged() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkSignIn();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        User user = new User();
        user.setEmail(ConfigUtil.get("username"));
        user.setPassword(ConfigUtil.get("passwordError"));

        customerLoginPage.fillLoginForm(user);

        // Submeter o formulário
        customerLoginPage.submitLogin();

        // Validar que a mensagem de erro foi exibida
        assertTrue(customerLoginPage.isDisplayed(customerLoginPage.getMessageErrorLocator()), "Usuário não está logado.");
        assertEquals(customerLoginPage.getMessage(customerLoginPage.getMessageErrorLocator()), ConfigUtil.get("accountIncorrect"));
    }

    @Test
    @Description("Test to try logged but dont password")
    @Severity(SeverityLevel.NORMAL)
    void testInvalidNotPasswordLogged() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkSignIn();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        User user = new User();
        user.setEmail(ConfigUtil.get("username"));

        customerLoginPage.fillLoginForm(user);

        // Submeter o formulário
        customerLoginPage.submitLogin();

        // Validar que a mensagem de erro foi exibida
        assertTrue(customerLoginPage.isDisplayed(customerLoginPage.getMessageErrorPasswordFieldLocator()), "Usuário não está logado.");
        assertEquals(customerLoginPage.getMessage(customerLoginPage.getMessageErrorPasswordFieldLocator()), ConfigUtil.get("requiredField"));
    }

    @Test
    @Description("Test to try logged but invalid password")
    @Severity(SeverityLevel.NORMAL)
    void testInvalidLogged() {

        // Acessar Formulário de Cadastro
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkSignIn();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(ConfigUtil.get("passwordError"));

        customerLoginPage.fillLoginForm(user);

        // Submeter o formulário
        customerLoginPage.submitLogin();

        // Validar que a mensagem de erro foi exibida
        assertTrue(customerLoginPage.isDisplayed(customerLoginPage.getMessageErrorLocator()), "Usuário não está logado.");
        assertEquals(customerLoginPage.getMessage(customerLoginPage.getMessageErrorAlertLocator()), ConfigUtil.get("accountIncorrect"));
    }
}