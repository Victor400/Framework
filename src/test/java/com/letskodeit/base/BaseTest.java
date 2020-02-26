package com.letskodeit.base;

import com.letskodeit.pageclasses.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    protected String baseURL;
    protected LoginPage login;
    protected NavigationPage nav;
    protected SearchBarPage search;
    protected ResultsPage result;
    protected CategoryFilterPage category;


    @BeforeClass
    public void NewSetUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Victor\\OneDrive\\Desktop\\Selenium Jar\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        baseURL = "https://learn.letskodeit.com/";
        driver.get(baseURL);
        nav = new NavigationPage(driver);
        login = nav.login();

    }

    @AfterClass
    public void NewtTearDown() {
        // driver.quit();
    }
}
