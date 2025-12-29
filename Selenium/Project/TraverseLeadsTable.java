package Selenium_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TraverseLeadsTable {

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

        // Sales menu
        WebElement salesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='Sales']")));
        salesMenu.click();

        // Leads option
        WebElement leadsMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='Leads']")));
        leadsMenu.click();
    }

    public void printFirstTenNamesAndUsers() {

        // Name column (1st column with links)
        List<WebElement> names = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//table[contains(@class,'listView')]//tr[contains(@class,'ListRow')]//td[3]/a")));

        // User column
        List<WebElement> users = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//table[contains(@class,'listView')]//tr[contains(@class,'ListRow')]//td[8]")));

        int limit = Math.min(10, Math.min(names.size(), users.size()));

        for (int i = 0; i < limit; i++) {
            System.out.println(
                    "Row " + (i + 1) +
                    " | Name: " + names.get(i).getText() +
                    " | User: " + users.get(i).getText()
            );
        }
    }

    public void closeBrowser() {
        driver.quit();
    }
}
