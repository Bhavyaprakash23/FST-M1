package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5_TestNG {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/target-practice");
    }

    // ---------------- Page Title Test ----------------
    @Test
    public void checkPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    // ---------------- Header Tests ----------------
    @Test(groups = {"HeaderTests"})
    public void checkThirdHeaderText() {
        WebElement thirdHeader = driver.findElement(By.xpath("//h3"));
        String text = thirdHeader.getText();
        System.out.println("Third header text: " + text);
        Assert.assertEquals(text, "Third header");
    }

    @Test(groups = {"HeaderTests"})
    public void checkFifthHeaderColor() {
        WebElement fifthHeader = driver.findElement(By.xpath("//h5"));
        String colorValue = fifthHeader.getCssValue("color");
        String actualColor = Color.fromString(colorValue).asHex();
        System.out.println("Fifth header color: " + actualColor);
        Assert.assertEquals(actualColor, "#000000"); // black
    }

    // ---------------- Button Tests ----------------
    @Test(groups = {"ButtonTests"})
    public void checkEmeraldButtonText() {
        WebElement emeraldButton = driver.findElement(By.className("emerald"));
        String text = emeraldButton.getText();
        System.out.println("Emerald button text: " + text);
        Assert.assertEquals(text, "Emerald");
    }

    @Test(groups = {"ButtonTests"})
    public void checkFirstButtonInThirdRowColor() {
        WebElement button = driver.findElement(
                By.xpath("(//div[@class='ui buttons'])[3]/button[1]")
        );
        String colorValue = button.getCssValue("background-color");
        String actualColor = Color.fromString(colorValue).asHex();
        System.out.println("Button color: " + actualColor);
        Assert.assertEquals(actualColor, "#2185d0"); // blue
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
