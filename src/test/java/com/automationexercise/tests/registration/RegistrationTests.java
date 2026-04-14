package com.automationexercise.tests.registration;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.helpers.UserFactory;
import com.automationexercise.models.UserRegistrationDetails;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.CreateAccountPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test(description = "Test Case 1: Register User")
    public void shouldRegisterNewUserSuccessfully() {
        UserRegistrationDetails user = UserFactory.createNewUser();

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu.clickSignupLoginButton();

        new LoginPage(driver)
                .assertNewUserSignupTextsVisible()
                .setNewUserName(user.getFirstName() + " " + user.getLastName())
                .setNewUserEmail(user.getEmail())
                .clickSignupButton();

        new CreateAccountPage(driver)
                .assertCreateAccountPageIsSuccessfullyLoaded()
                .fillAllFieldsForRegistration(user)
                .clickCreateAccountButton();

        new AccountCreatedPage(driver)
                .assertAccountCreatedPageIsSuccessfullyLoaded()
                .clickContinueButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + user.getFirstName() + " " + user.getLastName())
                .clickDeleteAccountButton()
                .assertAccountIsDeletedSuccessfully("ACCOUNT DELETED!")
                .clickContinueButton();
    }


    @Test(description = "Test Case 5: Register User with existing email")
    public void shouldNotRegisterNewUserWithExistingEmail() {
        new HomePage(driver)
                .openHomePage()
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