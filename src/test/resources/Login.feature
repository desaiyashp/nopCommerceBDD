@Regression
Feature: Testing nopCommerce Login functionality
  As a user
  I want to add login functionality
  So that the customer can use it

  @Test1
  Scenario: Loading Login Page from Home Page
    Given I am on homepage
    When I click on login link in the header
    Then I should see "Welcome, Please Sign In!" text
    And the URL should contain "/login"

  @Test2
  Scenario: Validating Login Feature on Login Page
    Given I am on Login Page
    When  I enter valid creditials
    And I click on LOG IN button
    Then I should see My Account link
    And I should see Logout link

#Scenario: Login with invalid credential
#  Given I am on homepage
#  And I click on login link in the header
#  When I enter invalid credentials
#  Then I should see error message "Login was unsuccessful. Please correct the errors and try again. No customer account found"
