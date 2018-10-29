package testng.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import testng.practice.tests.page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class FactoryLoginTests {

    private WebDriver driver;

    private String username;
    private String password;
    private String expectedWarning;

    public FactoryLoginTests(String username, String password, String expectedWarning) {
        this.username = username;
        this.password = password;
        this.expectedWarning = expectedWarning;
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/login");
    }

    @Test
    public void asUserLoginUsingIncorrectCredentials2() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeInUsername(username);
        loginPage.typeInPassword(password);
        loginPage.clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(expectedWarning));
    }

    @Factory
    public static Object[] factoryMethod() {
        FactoryLoginTests firstTestToExecute = new FactoryLoginTests("", "", "Your username is invalid!");
        FactoryLoginTests secondTestToExecute = new FactoryLoginTests("tomsmith", "wrong password", "Your password is invalid!");
        FactoryLoginTests thirdTestToExecute = new FactoryLoginTests("wrong username", "SuperSecretPassword", "Your username is invalid!");
        return new Object[] {
                firstTestToExecute,
                secondTestToExecute,
                thirdTestToExecute};
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
