package com.automationexercise.tests.checkout;

import com.automationexercise.components.CartModal;
import com.automationexercise.helpers.DataRandomizer;
import com.automationexercise.helpers.UserFactory;
import com.automationexercise.models.UserRegistrationDetails;
import com.automationexercise.pages.*;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(description = "Test Case 14: Place Order: Register while Checkout")
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
                .fillAllFieldsForRegistration(user)
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
                .assertCheckoutPageIsSuccessfullyLoaded()
                .assertAddressDetailsIsVisible()
                .assertReviewYourOrderIsVisible()
                .inputRandomComment()
                .clickPlaceOrderButton()
                .assertPaymentPageSuccessfullyLoaded()
                .inputNameOnCard(user.getFirstName())
                .inputCardNumber(DataRandomizer.getRandomCardNumber())
                .inputCardCvc(DataRandomizer.getRandomCvcNumber())
                .inputExpirationMonth(DataRandomizer.getRandomMonthNumber())
                .inputExpirationYear(DataRandomizer.getRandomYearNumber())
                .clickPayAndConfirmOrderButton()
                .assertPaymentDonePageSuccessfullyLoaded();
        mainMenu
                .clickDeleteAccountButton()
                .assertAccountIsDeletedSuccessfully("ACCOUNT DELETED!")
                .clickContinueButton();
    }

    @Test (description = "Test Case 15: Place Order: Register before Checkout")
    public void shouldPlaceOrderWithRegisteredUser() {
        UserRegistrationDetails user = UserFactory.createNewUser();

        HomePage homePage = new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();
        mainMenu
                .clickSignupLoginButton()
                .assertNewUserSignupTextsVisible()
                .setNewUserName(user.getFirstName() + " " + user.getLastName())
                .setNewUserEmail(user.getEmail())
                .clickSignupButton()
                .assertCreateAccountPageIsSuccessfullyLoaded()
                .fillAllFieldsForRegistration(user)
                .clickCreateAccountButton()
                .assertAccountCreatedPageIsSuccessfullyLoaded()
                .clickContinueButton()
                .assertHomePageIsSuccessfullyLoaded()
                .removeAds();
        mainMenu
                .assertUserNameIsDisplayed("Logged in as " + user.getFirstName() + " " + user.getLastName())
                .clickProductsButton()
                .assertProductsPageIsSuccessfullyLoaded()
                .addRandomProductToCart();
        new CartModal(driver)
                .assertAddedModalIsSuccessfullyLoaded()
                .clickViewCartButton()
                .assertCartPageIsSuccessfullyLoaded()
                .clickProceedToCheckoutAsLoggedIn();




    }
}
