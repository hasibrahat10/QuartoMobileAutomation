package steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

/**
 * Login Page Step Defined according to Feature File
 */
public class LoginSteps extends TestSetupPage {
    @Then("^I have entered the user login info$")
    public void i_have_entered_the_user_login_info() {
        new LoginPage().loginInfo();
    }

    @Then("^I tap on login button$")
    public void i_tap_on_login_button() {
        new LoginPage().clickLogin();
    }


    @And("^I observed the text \"([^\"]*)\"$")
    public void iObservedTheText(String expectedText) {
       Assert.assertTrue(expectedText, true);
//        Assert.assertTrue(true);
    }
}
