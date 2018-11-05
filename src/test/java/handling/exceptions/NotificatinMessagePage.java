package handling.exceptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificatinMessagePage {

    private WebDriver driver;

    @FindBy(css="a[href='/notification_message']")
    private WebElement clickHereButton;

    @FindBy(css = "#flash")
    private WebElement message;

    public NotificatinMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnClickHereButton() {
        clickHereButton.click();
    }

    public String getNotificationMessage() {
        return(message.getText());
    }

}
