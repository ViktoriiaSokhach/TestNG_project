package other.useful.functions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ScreenShotMakerTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.pl/");
    }

    @Test
    public void screenshotMakeTest() {
        ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
        screenShotMaker.makeScreenshot("GoogleBeforeTypingQueryPage.png");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Kurs Selenium");
        screenShotMaker.makeScreenshot("GoogleAfterTypingQueryPage.png");
        searchField.submit();
        screenShotMaker.makeScreenshot("GoogleSearchResultsPage.png");
        assertTrue(driver.getTitle().contains("Kurs Selenium"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
