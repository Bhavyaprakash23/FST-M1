package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2_TestNG {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice/");
    }

    // 1️⃣ First test: getTitle and assert title
    @Test
    public void verifyPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    // 2️⃣ Second test: find black button and make WRONG assertion (intentional failure)
    @Test
    public void incorrectAssertionTest() {
        boolean isBlackButtonDisplayed =
                driver.findElement(By.id("blackButton")).isDisplayed();

        // Intentionally wrong assertion
        Assert.assertFalse(isBlackButtonDisplayed);
    }

    // 3️⃣ Third test: skipped using enabled = false
    @Test(enabled = false)
    public void skippedTestUsingEnabledFalse() {
        System.out.println("This test should be skipped but not shown as skipped");
    }

    // 4️⃣ Fourth test: skipped using SkipException
    @Test
    public void skippedTestUsingException() {
        throw new SkipException("Skipping this test using SkipException");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
