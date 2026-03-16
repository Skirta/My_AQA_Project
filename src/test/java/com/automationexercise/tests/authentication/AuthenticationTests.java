package com.automationexercise.tests.authentication;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest {

    @Test(description = "Test Case 2: Login User with correct email and password")
    public void shouldLoginSuccessfullyWithValidCredentials() {
        new HomePage(driver)
                .openHomePage()
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
        mainMenu
                .assertUserNameIsNotDisplayed();
    }

    @Test(description = "Test Case 3: Login User with incorrect email and password")
    public void shouldNotLoginWithIncorrectCredentials() {

        new HomePage(driver)
                .openHomePage()
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

    @Test(description = "Test Case 4: Logout User")
    public void shouldLogoutSuccessfully() {
        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickSignupLoginButton()
                .assertLoginToYourAccountTextIsVisible()
                .setOldUserEmail(SecretManager.get("USER_EMAIL"))
                .setOldUserPassword(SecretManager.get("USER_PASSWORD"))
                .clickLoginButton();

        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + SecretManager.get("USER_NAME"))
                .clickLogoutButton()
                .assertLoginToYourAccountTextIsVisible();

        mainMenu.assertUserNameIsNotDisplayed();
    }
}