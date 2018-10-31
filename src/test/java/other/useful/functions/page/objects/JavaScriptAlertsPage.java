package other.useful.functions.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {


    @FindBy(xpath = "//ul/li[1]/button")
    private WebElement clickForJSAlertButton;

    @FindBy(xpath = "//ul/li[2]/button")
    private WebElement clickForJSConfirmButton;

    @FindBy(xpath = "//ul/li[3]/button")
    private WebElement clickForJSPromptButton;

    public JavaScriptAlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnJSAlert() {
        clickForJSAlertButton.click();
    }

    public void clickOnJSConfirm() {
        clickForJSConfirmButton.click();
    }

    public void clickOnJSPrompt() {
        clickForJSPromptButton.click();
    }
}
