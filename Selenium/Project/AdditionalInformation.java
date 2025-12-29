package Selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionalInformation {

    WebDriver driver;
    WebDriverWait wait;

    public void openApplicationAndLogin() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")))
                .sendKeys("admin");

        driver.findElement(By.id("username_password"))
                .sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();
    }

    public void navigateToLeads() {

        // Hover or click Sales menu
        WebElement salesMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[text()='Sales']")));
        salesMenu.click();

        // Click Leads
        WebElement leadsOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[text()='Leads']")));
        leadsOption.click();
    }

    public String getPhoneNumberFromPopup() {

        // Click additional information (ⓘ icon) of first lead
        WebElement infoIcon = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[contains(@class,'listViewTdTools')])[1]")));
        infoIcon.click();

        // Read phone number from popup
        WebElement phoneNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='ui-dialog-content']//span[contains(text(),'Mobile')]")));

        return phoneNumber.getText();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
