package com.automationexercise.tests.cart;

import com.automationexercise.components.CartModal;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(description = "Test Case 17: Remove Products From Cart")
    public void shouldRemoveProductsFromCart() {
        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();
        ProductsPage productsPage = mainMenu
                .clickProductsButton()
                .assertProductsPageIsSuccessfullyLoaded()
                .addRandomProductToCart();
        new CartModal(driver)
                .assertAddedModalIsSuccessfullyLoaded()
                .clickViewCartButton(productsPage.getProductsList())
                .assertCartPageIsSuccessfullyLoaded()
                .clickDeleteProductButton()
                .assertCartIsEmpty();
    }
}