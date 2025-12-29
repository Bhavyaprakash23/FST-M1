package Selenium_project;

import org.testng.annotations.Test;

public class HeaderImageURLTest {

    @Test
    public void printHeaderImageURL() {

        HeaderImageURL hi = new HeaderImageURL();

        hi.openApplication();
        String url = hi.getHeaderImageURL();

        System.out.println("Header Image URL: " + url);

        hi.closeBrowser();
    }
}
