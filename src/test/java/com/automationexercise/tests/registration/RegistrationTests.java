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

        HomePage homePage = new HomePage(driver);
        homePage
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
                .clickGenderRadioButton(user.getGender())
                .verifyNameField(user.getFirstName() + " " + user.getLastName())
                .verifyEmailField(user.getEmail())
                .setPassword(user.getPassword())
                .setDayOfBirth(user.getDayOfBirth())
                .setMonthOfBirth(user.getMonthOfBirth())
                .setYearOfBirth(user.getYearOfBirth())
                .selectNewsletterCheckbox()
                .selectSpecialOffersCheckbox()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setCompany(user.getCompanyName())
                .setFirstAddress(user.getFirstAddress())
                .setSecondAddress(user.getSecondAddress())
                .setCountry(user.getCountry())
                .setState(user.getState())
                .setCity(user.getCity())
                .setZipcode(user.getZipCode())
                .setMobileNumber(user.getMobileNumber())
                .clickCreateAccountButton();

        new AccountCreatedPage(driver)
                .assertAccountCreatedPageIsSuccessfullyLoaded()
                .clickContinueButton();

        homePage
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + user.getFirstName() + " " + user.getLastName());
        mainMenu
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