package com.nopcommerce.step_def;

import com.nopcommerce.driver.DriverManager;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class LoginSteps extends DriverManager {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedText;

    @Then("^I should see \"([^\"]*)\" text$")
    public void i_should_see_text(String expectedText) {
        String actualText = loginPage.getWelcomeText();
        assertEquals(expectedText, actualText);
    }

    @Then("^the URL should contain \"([^\"]*)\"$")
    public void the_URL_should_contain(String expectedText) {
        this.expectedText = expectedText;
        String currentURL = getCurrentURL();
        assertThat(currentURL,containsString(expectedText));
    }

    @Given("^I am on Login Page$")
    public void iAmOnLoginPage() {
        homePage.clickLoginLink();
        String currentURL = getCurrentURL();
        assertThat(currentURL,containsString("login"));
    }

    @When("^I enter valid creditials$")
    public void iEnterValidCreditials() {
        loginPage.inputEmail();
        loginPage.inputPassword();
    }

    @And("^I click on LOG IN button$")
    public void iClickOnLOGINButton() {
        loginPage.clickLoginButton();
    }
}
