package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6_TestNG {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Update this path if geckodriver is in a different location
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"url"})
    public void parameterTest(String url) {

        // Open URL from testng.xml
        driver.get(url);

        // Find an element and print text
        WebElement heading = driver.findElement(By.tagName("h1"));
        System.out.println("Heading text is: " + heading.getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
