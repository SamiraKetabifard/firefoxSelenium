package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class firefox {

    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeMethod
    public void setup() {
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\Users\\parsian\\Downloads\\geckodriver-v0.37.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @Test
    public void googleTest() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}