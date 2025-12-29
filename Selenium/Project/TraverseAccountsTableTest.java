package Selenium_project;

import org.testng.annotations.Test;

public class TraverseAccountsTableTest {

    @Test
    public void traverseAccountsTable() {

        TraverseAccountsTable ta = new TraverseAccountsTable();

        ta.openApplicationAndLogin();

        ta.navigateToAccounts();

        ta.printFirstFiveOddRowNames();

        ta.closeBrowser();
    }
}
