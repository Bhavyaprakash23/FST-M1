package Selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeaderImageURL {

    WebDriver driver;
    WebDriverWait wait;

    public void openApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeaderImageURL() {
        WebElement logo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//img[contains(@src,'suitecrm')]")));
        return logo.getAttribute("src");
    }

    public void closeBrowser() {
        driver.quit();
    }
}
