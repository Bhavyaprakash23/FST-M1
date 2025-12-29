package Selenium_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {

    WebDriver driver;

    public void openApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
