package com.automationexercise.tests.register_user_tests;

import com.automationexercise.helpers.SecretManager;
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

        mainMenu
                .clickSignupLoginButton();

        new LoginPage(driver)
                .assertLoginToYourAccountTextIsVisible()
                .setOldUserEmail(SecretManager.get("USER_EMAIL"))
                .setOldUserPassword(SecretManager.get("USER_PASSWORD"))
                .clickLoginButton();

        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + SecretManager.get("USER_NAME"))
                .clickLogoutButton();
        mainMenu
                .assertUserNameIsNotDisplayed();
    }
}