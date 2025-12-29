package Selenium_project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitleTest {

    @Test
    public void verifyWebsiteTitle() {

        VerifyTitle vt = new VerifyTitle();

        vt.openApplication();
        String title = vt.getTitle();

        Assert.assertEquals(title, "SuiteCRM");

        vt.closeBrowser();
    }
}
