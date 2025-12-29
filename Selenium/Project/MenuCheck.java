package Selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MenuCheck {

    WebDriver driver;
    WebDriverWait wait;

    public void openApplicationAndLogin() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")))
                .sendKeys("admin");

        driver.findElement(By.id("username_password"))
                .sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();
    }

    public boolean isActivitiesMenuClickable() {

        WebElement activitiesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='Activities']")));

        return activitiesMenu.isDisplayed() && activitiesMenu.isEnabled();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
