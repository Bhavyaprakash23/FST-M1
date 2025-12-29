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

public class TraverseAccountsTable {

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

    public void navigateToAccounts() {

        // Click Sales menu
        WebElement salesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='Sales']")));
        salesMenu.click();

        // Click Accounts
        WebElement accountsMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='Accounts']")));
        accountsMenu.click();
    }

    public void printFirstFiveOddRowNames() {

        // Locate account name column cells
        List<WebElement> accountNames = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//table[contains(@class,'listView')]//tr[contains(@class,'oddListRowS1') or contains(@class,'evenListRowS1')]/td[3]/a")
                ));

        int count = 0;

        // Odd rows: index 0,2,4,6,8
        for (int i = 0; i < accountNames.size(); i += 2) {
            System.out.println("Row " + (i + 1) + " Account Name: " + accountNames.get(i).getText());
            count++;
            if (count == 5) {
                break;
            }
        }
    }

    public void closeBrowser() {
        driver.quit();
    }
}
