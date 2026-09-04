package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":

                System.setProperty(
                        "webdriver.chrome.driver",
                        "C:\\Users\\parsian\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
                );

                webDriver = new ChromeDriver();
                break;

            case "firefox":

                System.setProperty(
                        "webdriver.gecko.driver",
                        "C:\\Users\\parsian\\Downloads\\geckodriver-v0.37.1-win64\\geckodriver.exe"
                );

                webDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        webDriver.manage().window().maximize();

        driver.set(webDriver);

        return webDriver;
    }

    public static WebDriver getDriver() {

        WebDriver webDriver = driver.get();

        if (webDriver == null) {
            throw new IllegalStateException(
                    "Driver is not initialized"
            );
        }

        return webDriver;
    }

    public static void quitDriver() {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}
