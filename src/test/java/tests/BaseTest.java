package tests;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {

        System.out.println("Running on browser: " + browser);

        driver = DriverManager.initDriver(browser);

        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}