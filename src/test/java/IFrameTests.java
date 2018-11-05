import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://przyklady.javastart.pl:8095/nested_frames");
    }

    @Test
    public void iFrameTest() {

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        By bodyLocator = By.xpath("//body");
        String leftFrameText = driver.findElement(bodyLocator).getText();
        assertEquals(leftFrameText, "LEFT");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        String bottomFrameText = driver.findElement(bodyLocator).getText();
        assertEquals(bottomFrameText, "BOTTOM");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
