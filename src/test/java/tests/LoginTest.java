package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resoucres.Base;

import java.io.IOException;

public class LoginTest extends Base {

    WebDriver driver;

    @Test
    public void login() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.myAccountDropdown().click();
        landingPage.loginButtonOption().click();


    }

}
