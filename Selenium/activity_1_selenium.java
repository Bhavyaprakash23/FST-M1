package Activity1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class activity_1_selenium {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

        // Open the page
        driver.get("https://training-support.net");
        System.out.println("Page title is: " + driver.getTitle());
        // Find the About Us link and click it
        driver.findElement(By.linkText("About Us")).click();
        // Print the page title of the About Us page
        System.out.println("New page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    
	}

}
