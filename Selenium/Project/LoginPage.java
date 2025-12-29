package Selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public void openApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {

        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("username_password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("bigbutton"));
        loginButton.click();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
