package Selenium_project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuCheckTest {

    @Test
    public void verifyActivitiesMenuExistsAndClickable() {

        MenuCheck mc = new MenuCheck();

        mc.openApplicationAndLogin();

        boolean result = mc.isActivitiesMenuClickable();

        Assert.assertTrue(result, "Activities menu is NOT clickable!");

        System.out.println("Activities menu exists and is clickable");

        mc.closeBrowser();
    }
}
