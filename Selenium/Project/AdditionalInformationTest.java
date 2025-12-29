package Selenium_project;

import org.testng.annotations.Test;

public class AdditionalInformationTest {

    @Test
    public void readAdditionalInformationPopup() {

        AdditionalInformation ai = new AdditionalInformation();

        ai.openApplicationAndLogin();

        ai.navigateToLeads();

        String phone = ai.getPhoneNumberFromPopup();

        System.out.println("Phone number from popup: " + phone);

        ai.closeBrowser();
    }
}
