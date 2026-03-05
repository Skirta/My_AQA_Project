package com.automationexercise.tests.testcases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCasesPageTests extends BaseTest {

    @Test(description = "Test Case 7: Verify Test Cases Page")
    public void shouldVerifyTestCasesPageIsVisible() {

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickTestCasesButton()
                .assertTestCasesPageIsSuccessfullyLoaded();
    }
}