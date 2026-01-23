package com.automationexercise.tests.register_user_tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    @Test
    public void testCase2() {
        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu.clickSignupLoginButton();

        new LoginPage(driver)
                .assertLoginToYourAccountTextIsVisible();



    }
}