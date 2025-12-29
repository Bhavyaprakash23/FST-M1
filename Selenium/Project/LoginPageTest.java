package Selenium_project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest {

    @Test
    public void loginToSuiteCRM() {

        LoginPage lp = new LoginPage();

        lp.openApplication();

        lp.login("admin", "pa$$w0rd");

        String titleAfterLogin = lp.getHomePageTitle();

        Assert.assertTrue(titleAfterLogin.contains("SuiteCRM"));

        lp.closeBrowser();
    }
}
