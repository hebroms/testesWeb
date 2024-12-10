package testes_web.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import testes_web.utils.ConfigUtil;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigUtil.get("baseUrl"));
    }

    @AfterEach
    public void teardown() {
        DriverManager.quitDriver();
    }
}
