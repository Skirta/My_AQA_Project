package com.automationexercise.tests.register_user_tests;

import com.automationexercise.helpers.UserFactory;
import com.automationexercise.models.UserRegistrationDetails;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.CreateAccountPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test //(invocationCount = 10, successPercentage = 100)
    public void testCase1() {
        UserRegistrationDetails user = UserFactory.createNewUser();

        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu.clickSignupLoginButton();

        new LoginPage(driver)
                .assertNewUserSignupTextsVisible()
                .setName(user.getFirstName() + " " + user.getLastName())
                .setEmail(user.getEmail())
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
                .assertHomePageIsSuccessfullyLoaded()
                .assertUserNameIsDisplayed("Logged in as " + user.getFirstName() + " " + user.getLastName());

        mainMenu
                .clickDeleteAccountButton()
                .assertAccountIsDeletedSuccessfully("ACCOUNT DELETED!")
                .clickContinueButton();
    }
}