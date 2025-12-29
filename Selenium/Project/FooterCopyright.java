package Selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterCopyright {

    WebDriver driver;
    WebDriverWait wait;

    public void openApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getFirstCopyrightText() {
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='footer']//span[1]")));
        return text.getText();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
