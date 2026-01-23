package com.automationexercise.components;

import com.automationexercise.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    // Locators

    private final By homeButtonLocator = By.xpath("//a[contains(text(), 'Home')]");
    private final By productsButtonLocator = By.xpath("//a[@href='/products']");
    private final By cartButtonLocator = By.xpath("//a[@href='/view_cart' and contains(text(), 'Cart')]");
    private final By signupAndLoginButtonLocator = By.xpath("//a[@href='/login']");
    private final By testCasesButtonLocator = By.xpath("//a[@href='/test_cases']");
    private final By apiTestingButtonLocator = By.xpath("//a[@href='/api_list']");
    private final By contactUsButtonLocator = By.xpath("//a[@href='/contact_us']");
    private final By loggedInAsButtonLocator = By.xpath("//i[contains(@class,'fa-user')]/parent::a");
    private final By deleteButtonLocator = By.xpath("//a[@href='/delete_account']");

    // Methods

    public HomePage clickHomeButton() {
        click(homeButtonLocator);
        return new HomePage(driver);
    }

    public ProductsPage clickProductsButton() {
        click(productsButtonLocator);
        return new ProductsPage(driver);
    }

    public CartPage clickCartButton() {
        click(cartButtonLocator);
        return new CartPage(driver);
    }

    public LoginPage clickSignupLoginButton() {
        click(signupAndLoginButtonLocator);
        return new LoginPage(driver);
    }

    public TestCasesPage clickTestCasesButton() {
        click(testCasesButtonLocator);
        return new TestCasesPage(driver);
    }

    public ApiTestingPage clickApiTestingButton() {
        click(apiTestingButtonLocator);
        return new ApiTestingPage(driver);
    }

    public ContactUsPage clickContactUsButton() {
        click(contactUsButtonLocator);
        return new ContactUsPage(driver);
    }

    public DeleteAccountPage clickDeleteAccountButton() {
        click(deleteButtonLocator);
        return new DeleteAccountPage(driver);
    }
}