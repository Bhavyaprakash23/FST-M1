package Selenium_project;

import org.testng.annotations.Test;

public class FooterCopyrightTest {

    @Test
    public void printCopyrightText() {

        FooterCopyright fc = new FooterCopyright();

        fc.openApplication();
        String text = fc.getFirstCopyrightText();

        System.out.println("First copyright text: " + text);

        fc.closeBrowser();
    }
}
