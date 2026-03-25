package com.automationexercise.tests.checkout;

import com.automationexercise.components.CartModal;
import com.automationexercise.helpers.UserFactory;
import com.automationexercise.models.UserRegistrationDetails;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.CreateAccountPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test (description = "Test Case 14: Place Order: Register while Checkout")
    public void shouldPlaceOrderWithRegistrationDuringCheckout() {

        UserRegistrationDetails user = UserFactory.createNewUser();

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();
        mainMenu
                .clickProductsButton()
                .assertProductsPageIsSuccessfullyLoaded()
                .addRandomProductToCart();
        new CartModal(driver)
                .assertAddedModalIsSuccessfullyLoaded()
                .clickViewCartButton();
        new CartPage(driver)
                .assertCartPageIsSuccessfullyLoaded()
                .clickProceedToCheckoutAsGuest()
                .assertCheckoutModalIsSuccessfullyLoaded()
                .clickRegisterLoginButton()
                .assertNewUserSignupTextsVisible()
                .setNewUserName(user.getFirstName() + " " + user.getLastName())
                .setNewUserEmail(user.getEmail())
                .clickSignupButton();
        new CreateAccountPage(driver)
                .assertCreateAccountPageIsSuccessfullyLoaded()
//TO DO refactor this part - need to create separate method for filling all details in CreateAccountPage
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
        new HomePage(driver)
                .assertHomePageIsSuccessfullyLoaded();
        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + user.getFirstName() + " " + user.getLastName())
                .clickCartButton()
                .clickProceedToCheckoutAsLoggedIn()
                .assertCheckoutPageIsSuccessfullyLoaded();


    }
}
