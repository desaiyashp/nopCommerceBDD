package com.nopcommerce.step_def;

import com.nopcommerce.driver.DriverManager;
import com.nopcommerce.pages.MyAccountsPage;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class MyAccountsSteps extends DriverManager {
    MyAccountsPage myAccountsPage = new MyAccountsPage();

    @Then("^I should see My Account link$")
    public void i_should_see_My_Account_link() {
        boolean checkMyAccountLink = myAccountsPage.checkMyAccountLink();
        assertEquals(true, checkMyAccountLink);
    }

    @Then("^I should see Logout link$")
    public void i_should_see_Logout_link() {
        boolean logOutLink = myAccountsPage.checkLogOutLink();
        assertThat(logOutLink,is(true));
    }
}
