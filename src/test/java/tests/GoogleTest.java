package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class GoogleTest extends BaseTest {


    @Test
    public void googleSearchTest() {


        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );


        // wait until search box visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("q")
                )
        );


        driver.findElement(By.name("q"))
                .sendKeys("Selenium WebDriver", Keys.ENTER);


        // wait until result page title loaded
        wait.until(
                ExpectedConditions.titleContains("Selenium")
        );


        String actualTitle = driver.getTitle();

        System.out.println("TITLE = " + actualTitle);


        Assert.assertTrue(
                actualTitle.contains("Selenium"),
                "Title does not contain Selenium"
        );
    }
}