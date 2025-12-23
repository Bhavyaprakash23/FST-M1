package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7_TestNG {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/login-form");
    }

    @DataProvider(name = "Authentication")
    public Object[][] credentials() {
        return new Object[][] {
                { "admin", "password" },
                { "wrongUser", "wrongPass" }
        };
    }

    @Test(dataProvider = "Authentication")
    public void loginTest(String username, String password) {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
