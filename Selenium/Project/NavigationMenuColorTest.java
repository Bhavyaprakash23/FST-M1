package Selenium_project;

import org.testng.annotations.Test;

public class NavigationMenuColorTest {

    @Test
    public void printNavigationMenuColor() {

        NavigationMenuColor nm = new NavigationMenuColor();

        nm.openApplicationAndLogin();

        String color = nm.getNavigationMenuColor();

        System.out.println("Navigation menu color: " + color);

        nm.closeBrowser();
    }
}
