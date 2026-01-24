package com.automationexercise.tests.login_user_tests;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {

    @Test
    public void testCase3() {

        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickSignupLoginButton()
                .assertLoginToYourAccountTextIsVisible()
                .setOldUserEmail(SecretManager.get("USER_INCORRECT_EMAIL"))
                .setOldUserPassword(SecretManager.get("USER_INCORRECT_PASSWORD"))
                .clickLoginButton();

        new LoginPage(driver)
                .assertErrorIncorrectEmailOrPasswordIsVisible();



    }
}
