package com.nopcommerce.pages;

import com.nopcommerce.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends DriverManager {
    @FindBy(css = ".ico-account")
    WebElement myAccountLinkElement;
    @FindBy(css = ".ico-logout")
    WebElement logOutLinkElement;

    public boolean checkMyAccountLink(){
        return myAccountLinkElement.isDisplayed();
    }

    public boolean checkLogOutLink(){
        return logOutLinkElement.isDisplayed();
    }
}
