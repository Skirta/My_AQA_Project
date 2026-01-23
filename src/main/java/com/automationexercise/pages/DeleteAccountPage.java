package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteAccountPage extends BasePage {
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By accountDeletedTextLocator = By.xpath("//h2[@data-qa='account-deleted']");
    private final By continueButtonLocator = By.xpath("//a[@data-qa='continue-button']");

    //Methods
    public DeleteAccountPage assertAccountIsDeletedSuccessfully(String expectedText) {
        String actualText = waitUntilVisibilityOfElementLocated(accountDeletedTextLocator).getText();
        assertThat(actualText).isEqualTo(expectedText);
        return this;
    }

    public HomePage clickContinueButton(){
        click(continueButtonLocator);
        return new HomePage(driver);
    }
}
