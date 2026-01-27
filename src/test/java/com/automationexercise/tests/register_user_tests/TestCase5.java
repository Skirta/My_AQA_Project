package com.automationexercise.tests.register_user_tests;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase5 extends BaseTest {

    @Test
    public void testCase5() {
        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickSignupLoginButton();

        new LoginPage(driver)
                .assertNewUserSignupTextsVisible()
                .setNewUserName(SecretManager.get("USER_NAME"))
                .setNewUserEmail(SecretManager.get("USER_EMAIL"))
                .clickSignupButton();

        new LoginPage(driver)
                .assertErrorEmailAddressAlreadyExistIsVisible();

    }
}
