package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resoucres.Base;

import java.io.IOException;

public class LoginTest extends Base {

    WebDriver driver;

    @Test(dataProvider = "LoginData")
    public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.myAccountDropdown().click();
        landingPage.loginButtonOption().click();

        Thread.sleep(3000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailField().sendKeys(email);
        loginPage.passwordField().sendKeys(password);
        loginPage.loginBtn().click();

        AccountPage accountPage = new AccountPage(driver);
        System.out.println(accountPage.editAccountInfomationOption().isDisplayed());

        String actualResult = "";
        try {
            if(accountPage.editAccountInfomationOption().isDisplayed()){
                actualResult = "Successful";
            }
            else {
                actualResult = "Failure";
            }
        } catch (Exception e){
            actualResult = "Failure";
        }

        Assert.assertEquals(actualResult, expectedStatus);

    }

    @BeforeMethod
    public void openApplication() throws IOException{
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void closure(){
        driver.close();
    }

    @DataProvider
    public Object[][] LoginData(){
        Object[][] data = { {"arun.selenium@gmail.com", "Second@123", "Successful"}, {"dummy@test.com", "dummny", "Failure"} };
        return data;
    }

}
