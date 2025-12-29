package Selenium_project;

import org.testng.annotations.Test;

public class TraverseLeadsTableTest {

    @Test
    public void traverseLeadsTable() {

        TraverseLeadsTable tl = new TraverseLeadsTable();

        tl.openApplicationAndLogin();

        tl.navigateToLeads();

        tl.printFirstTenNamesAndUsers();

        tl.closeBrowser();
    }
}
