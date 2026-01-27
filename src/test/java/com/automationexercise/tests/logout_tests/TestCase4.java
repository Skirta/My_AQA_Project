package com.automationexercise.tests.logout_tests;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase4 extends BaseTest {

    @Test
    public void testCase4(){
        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickSignupLoginButton()
                .assertLoginToYourAccountTextIsVisible()
                .setOldUserEmail(SecretManager.get("USER_EMAIL"))
                .setOldUserPassword(SecretManager.get("USER_PASSWORD"))
                .clickLoginButton();

        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + SecretManager.get("USER_NAME"))
                .clickLogoutButton();

        mainMenu.assertUserNameIsNotDisplayed();
    }
}
