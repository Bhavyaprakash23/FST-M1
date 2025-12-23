package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3_TestNg {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/login-form/");
    }

    @Test
    public void loginAndVerifyMessage() {

        // Find username field and enter value
        driver.findElement(By.id("username"))
              .sendKeys("admin");

        // Find password field and enter value
        driver.findElement(By.id("password"))
              .sendKeys("password");

        // Click Login button
        driver.findElement(By.xpath("//button[text()='Log in']"))
              .click();

        // Read confirmation message
        String actualMessage =
                driver.findElement(By.id("action-confirmation"))
                      .getText();

        System.out.println("Confirmation Message: " + actualMessage);

        // Assert confirmation message
        Assert.assertEquals(actualMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
