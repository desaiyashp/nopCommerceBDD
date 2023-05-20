package com.nopcommerce.pages;

import com.nopcommerce.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {

//    searching for login link on home page
    @FindBy(css = ".ico-login")
    public WebElement loginElement;

    public void clickLoginLink(){
        waitUntilElementIsClickable(loginElement);
        loginElement.click();
    }
}
