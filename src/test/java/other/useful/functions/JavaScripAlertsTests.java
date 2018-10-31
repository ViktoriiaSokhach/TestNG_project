package other.useful.functions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import other.useful.functions.page.objects.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;

public class JavaScripAlertsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/javascript_alerts");
    }


    @Test
    public void javaScriptAlertTest() {

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.clickOnJSAlert();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        assertEquals(alertText, "I am a JS Alert");
    }

    @Test
    public void javaScriptAcceptAlertTest() {

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.clickOnJSAlert();

        driver.switchTo().alert().accept();

        String result = javaScriptAlertsPage.resultAcceptAlertMessage();

        assertEquals(result, "You successfuly clicked an alert");
    }

    @Test
    public void javaScriptAlertConfirmTest() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.clickOnJSConfirm();
        driver.switchTo().alert().accept();
        String result = javaScriptAlertsPage.resultAcceptAlertMessage();
        assertEquals(result, "You clicked: Ok");

        javaScriptAlertsPage.clickOnJSConfirm();
        driver.switchTo().alert().dismiss();
        result = javaScriptAlertsPage.resultAcceptAlertMessage();
        assertEquals(result, "You clicked: Cancel");
    }

    @Test
    public void javaScriptAlertPromptTest() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.clickOnJSPrompt();

        String typedText = "Selenium is cool";

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(typedText);
        alert.accept();
        String result = javaScriptAlertsPage.resultAcceptAlertMessage();

        assertEquals(result, "You entered: " + typedText);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
