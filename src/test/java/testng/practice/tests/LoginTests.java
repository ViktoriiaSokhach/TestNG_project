package testng.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import testng.practice.tests.page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/login");
    }

   /* @Test
    public void loginUsingBadPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeInUsername();
        loginPage.typeInPassword();
        loginPage.clickOnLoginButton();

        assertTrue(loginPage.getWarningMessage().contains("Your password is invalid"));
    }*/

    //@Parameters({"username", "password", "expectedWarning"})
    @Test(dataProvider = "incorrectLoginData")
    public void asUserLoginUsingIncorrectCredentials(String username, String password, String expectedWarning) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeInUsername(username);
        loginPage.typeInPassword(password);
        loginPage.clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(expectedWarning));
    }

    @DataProvider
    public Object[][] incorrectLoginData() {
        Object[][] inputDataArray = {
                {"","", "Your username is invalid!"},
                {"tomsmith","wrong password","Your password is invalid!"},
                {"wrong username","SuperSecretPassword", "Your username is invalid!"}};
        return inputDataArray;
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
