package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteAccountPage extends BasePage {
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By accountDeletedTextLocator = By.xpath("//h2[@data-qa='account-deleted']");

    public DeleteAccountPage assertAccountIsDeletedSuccessfully(String expectedText) {
        String actualText = waitUntilVisibilityOfElementLocated(accountDeletedTextLocator).getText();
        assertThat(actualText).isEqualTo(expectedText);
        return this;
    }
}
