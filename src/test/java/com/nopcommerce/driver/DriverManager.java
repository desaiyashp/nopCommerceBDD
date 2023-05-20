package com.nopcommerce.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    String browser = "Chrome";
    String baseURL = "https://demo.nopcommerce.com/";

//    creating driver constructor
    public DriverManager(){
        PageFactory.initElements(driver,this);
    }

//    opening browsers in different conditions
    public void openLocalBrowser() throws IllegalAccessException {
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Windows\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalAccessException("unexpected browser");
        }
    }

//    maximising the browser
    public void maximiseBrowser(){
        driver.manage().window().maximize();
    }

//    applying implecit wait
    public void applyImplicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    opening URL
    public void openURL(){
        driver.get(baseURL);
    }

//    Get URL for assertion stored in the method
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

//    for closing the browser
    public void closeBrowser(){
        driver.quit();
    }

    public void sleepBrowser(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }
    public String getTitle(){
        return driver.getTitle();
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        return     wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element, int timeout, String failureMessage) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(failureMessage);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void takeElementscreenshot(WebElement element, String fileName)  {
        File scnFile =element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scnFile, new File("./target/screenshots/" +fileName+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(Scenario scenario){
//        Attaching screenshot for report generation in byte format
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
//        take a screenshot in system
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("/Users/Administrator/Desktop/ScreenShot/Error.jpg"));
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int generateRandomNumber(){
        Random random = new Random();
        // Obtain a number between [0 - 49].
        return random.nextInt(50);
    }

    public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }
}
