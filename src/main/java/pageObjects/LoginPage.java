package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;



    public WebElement emailField(){
        return emailField;
    }

    public WebElement passwordField(){
        return passwordField;
    }

    public WebElement loginBtn(){
        return loginBtn;
    }


}
