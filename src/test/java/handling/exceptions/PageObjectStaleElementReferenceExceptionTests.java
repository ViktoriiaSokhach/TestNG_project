package handling.exceptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PageObjectStaleElementReferenceExceptionTests {
    private static final String ACTION_SUCCESSFUL = "Action successful";
    private static final String ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN = "Action unsuccesful, please try again";

    private WebDriver driver;
    private NotificatinMessagePage notificatinMessagePage;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://przyklady.javastart.pl:8095/notification_message_rendered");
    }

    @Test
    public void staleElementWorkingTest() {

        notificatinMessagePage = new NotificatinMessagePage(driver);

        assertThatCorrectActionMessageIsDisplayed(ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN);
        assertThatCorrectActionMessageIsDisplayed(ACTION_SUCCESSFUL);
        assertThatCorrectActionMessageIsDisplayed(ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN);

    }

    private void assertThatCorrectActionMessageIsDisplayed(String message){
        boolean isMessageHavingCorrectText;

        do {
            notificatinMessagePage.clickOnClickHereButton();
            isMessageHavingCorrectText = notificatinMessagePage.getNotificationMessage().contains(message);
            System.out.println("Message label had correct text: " + isMessageHavingCorrectText);
        } while (!isMessageHavingCorrectText);

        assertTrue(isMessageHavingCorrectText);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}

