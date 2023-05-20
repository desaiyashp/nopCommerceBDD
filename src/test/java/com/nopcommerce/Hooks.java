package com.nopcommerce;

import com.nopcommerce.driver.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    DriverManager manager = new DriverManager();
    @Before
    public void setUp() throws IllegalAccessException {
        manager.openLocalBrowser();
        manager.maximiseBrowser();
        manager.openURL();
        manager.applyImplicitWait();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            manager.takeScreenshot(scenario);
        }
        manager.closeBrowser();
    }
}
