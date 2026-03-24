package com.automationexercise.tests.checkout;

import com.automationexercise.components.CartModal;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test (description = "Test Case 14: Place Order: Register while Checkout")
    public void shouldPlaceOrderWithRegistrationDuringCheckout() {

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
                .clickProceedToCheckoutButton();

    }
}
