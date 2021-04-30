package stepsdefinitions;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("User has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps();
        String uName = credList.get(0).get("username");
        String pwd = credList.get(0).get("password");
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
        accountsPage = loginPage.doLogin(uName, pwd);
    }

    @Given("user is on the Accounts page")
    public void user_is_on_the_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts page title" + title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionTable) {
        List<String> expectedSectionList = sectionTable.asList();
        System.out.println("expected section account list --" + expectedSectionList);
        List<String> actualSectionList = accountsPage.getAccountSectionList();
        System.out.println("expected section account list" + actualSectionList);
        Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
    }

    @Then("Accounts count should be {int}")
    public void accounts_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
    }
}
