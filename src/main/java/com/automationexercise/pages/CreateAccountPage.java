package com.automationexercise.pages;

import com.automationexercise.models.UserRegistrationDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By genderMrRadioButtonLocator = By.id("id_gender1");
    private final By genderMrsRadioButtonLocator = By.id("id_gender2");

    public CreateAccountPage clickGenderRadioButton(UserRegistrationDetails.Gender title){
        if (title.equals(UserRegistrationDetails.Gender.MR)){
            click(genderMrRadioButtonLocator);
        } else {
            click(genderMrsRadioButtonLocator);
        }
        return this;
    }
}