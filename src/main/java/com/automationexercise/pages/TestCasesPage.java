package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    public final By testCasesTextLocator = By.xpath("//h2/b[text()='Test Cases']");

    //Mothods
    public TestCasesPage assertTestCasesPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(testCasesTextLocator);
        return this;
    }
}