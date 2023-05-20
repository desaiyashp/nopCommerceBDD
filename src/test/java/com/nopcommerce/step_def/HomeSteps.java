package com.nopcommerce.step_def;

import com.nopcommerce.driver.DriverManager;
import com.nopcommerce.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeSteps extends DriverManager {
    HomePage homePage = new HomePage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String homePageURL = getCurrentURL();
        assertThat(homePageURL,is(endsWith("demo.nopcommerce.com/")));
    }

    @When("^I click on login link in the header$")
    public void i_click_on_login_link_in_the_header() {
        homePage.clickLoginLink();
    }
}
