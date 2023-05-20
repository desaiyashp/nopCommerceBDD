package com.nopcommerce.pages;

import com.nopcommerce.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {
    @FindBy(xpath = "//div[@class=\"page-title\"]/h1")
    WebElement welcomeTextElement;

    @FindBy(id="Email")
    WebElement emailInputElement;
    @FindBy(id="Password")
    WebElement passwordInputElement;
    @FindBy(xpath = "//div[@class=\"buttons\"]/button[@type=\"submit\"]")
    WebElement loginButtonElement;

//    returning welcome text
    public String getWelcomeText() {
        return welcomeTextElement.getText();
    }

    public void inputEmail(){
        emailInputElement.sendKeys("abcd@wxyz.com");
    }
    public void inputPassword(){
        passwordInputElement.sendKeys("abcd@123");
    }
    public void clickLoginButton(){
        waitForElementVisibility(loginButtonElement, 20, "Element is not visible");
        loginButtonElement.click();
    }

}

