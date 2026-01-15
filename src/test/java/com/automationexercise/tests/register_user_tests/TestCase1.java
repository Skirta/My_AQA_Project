package com.automationexercise.tests.register_user_tests;

import com.automationexercise.components.MainMenu;
import com.automationexercise.helpers.UserFactory;
import com.automationexercise.models.UserRegistrationDetails;
import com.automationexercise.pages.CreateAccountPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test
    public void testCase1() throws InterruptedException {
        UserRegistrationDetails user = UserFactory.createNewUser();

        new HomePage(driver)
                .openHomePage()
                .clickConsentButton();
        new MainMenu(driver).clickSignupLoginButton();
        new LoginPage(driver)
                .setName(user.getFirstName() + " " + user.getLastName())
                .setEmail(user.getEmail())
                .clickSignupButton();
        new CreateAccountPage(driver)
                .clickGenderRadioButton(user.getGender())
                .verifyNameField(user.getFirstName() + " " + user.getLastName())
                .verifyEmailField(user.getEmail())
                .setPassword(user.getPassword())
                .setDayOfBirth(user.getDayOfBirth())
                .setMonthOfBirth(user.getMonthOfBirth())
                .setYearOfBirth(user.getYearOfBirth())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setCompany(user.getCompanyName())
                .setFirstAddress(user.getFirstAddress())
                .setSecondAddress(user.getSecondAddress())
                .setCountry(user.getCountry())
                .setState(user.getState())
                .setCity(user.getCity())
                .setZipcode(user.getZipCode())
                .setMobileNumber(user.getMobileNumber());
    }
}
