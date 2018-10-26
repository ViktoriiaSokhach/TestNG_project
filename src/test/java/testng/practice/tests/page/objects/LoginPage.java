package testng.practice.tests.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button.radius")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement messageLabel;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeInUsername(String username) {
        userNameField.sendKeys(username);
    }

    public void typeInPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getWarningMessage(){
        return messageLabel.getText();
    }
}
