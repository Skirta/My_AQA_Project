package com.automationexercise.tests;

import com.automationexercise.components.MainMenu;
import com.automationexercise.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected MainMenu mainMenu;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        driver = DriverManager.getDriver();
        mainMenu = new MainMenu(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        DriverManager.quitDriver();
    }
}
