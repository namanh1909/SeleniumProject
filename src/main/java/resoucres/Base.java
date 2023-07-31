package resoucres;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        String propertiesPath = "/Users/hoanhnam/IdeaProjects/AutomationProject/src/main/java/resoucres/data.properties";
        File file = new File(propertiesPath);
        prop = new Properties();

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
            String browserName = prop.getProperty("browser");

            if (browserName.equalsIgnoreCase("chrome")) {
//                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                System.out.println("Invalid or unsupported browser specified in the properties file.");
            }
        } else {
            System.out.println("data.properties file not found at the specified location.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
