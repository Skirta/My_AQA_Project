package com.automationexercise.pages;

import com.automationexercise.models.UserRegistrationDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By genderMrRadioButtonLocator = By.id("id_gender1");
    private final By genderMrsRadioButtonLocator = By.id("id_gender2");
    private final By inputNameLocator = By.id("name");
    private final By inputEmailLocator = By.id("email");
    private final By inputPasswordLocator = By.id("password");
    private final By dayDropdownLocator = By.id("days");
    private final By monthDropdownLocator = By.id("months");
    private final By yearDropdownLocator = By.id("years");
    private final By inputFirstNameLocator = By.id("first_name");
    private final By inputLastNameLocator = By.id("last_name");
    private final By inputCompanyLocator = By.id("company");
    private final By inputFirstAddressLocator = By.id("address1");
    private final By inputSecondAddressLocator = By.id("address2");
    private final By countryDropdownLocator = By.id("country");
    private final By inputStateLocator = By.id("state");
    private final By inputCityLocator = By.id("city");
    private final By inputZipcodeLocator = By.id("zipcode");
    private final By inputMobileNumberLocator = By.id("mobile_number");
    private final By createAccountButtonLocator = By.xpath("//button[@data-qa='create-account']");
    private final By enterAccountInformationTextLocator = By.xpath("//b[text()='Enter Account Information']");

    //Methods
    public CreateAccountPage assertCreateAccountPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(enterAccountInformationTextLocator);
        return this;
    }

    public CreateAccountPage clickGenderRadioButton(UserRegistrationDetails.Gender title) {
        if (title.equals(UserRegistrationDetails.Gender.MR)) {
            click(genderMrRadioButtonLocator);
        } else {
            click(genderMrsRadioButtonLocator);
        }
        return this;
    }

    public CreateAccountPage verifyNameField(String expectedName) {
        String actualName = find(inputNameLocator).getAttribute("value");
        assertThat(actualName)
                .as("Перевірка поля Name на сторінці реєстрації")
                .isEqualTo(expectedName);
        return this;
    }

    public CreateAccountPage verifyEmailField(String expectedEmail) {
        String actualEmail = find(inputEmailLocator).getAttribute("value");
        assertThat(actualEmail)
                .as("Перевірка поля Email на сторінці реєстрації")
                .isEqualTo(expectedEmail);
        return this;
    }

    public CreateAccountPage setPassword(String password) {
        type(inputPasswordLocator, password);
        return this;
    }

    public CreateAccountPage setDayOfBirth(String year) {
        WebElement yearsSelectorLocator = find(dayDropdownLocator);
        Select yearsSelect = new Select(yearsSelectorLocator);
        yearsSelect.selectByVisibleText(year);
        return this;
    }

    public CreateAccountPage setMonthOfBirth(String year) {
        WebElement yearsSelectorLocator = find(monthDropdownLocator);
        Select yearsSelect = new Select(yearsSelectorLocator);
        yearsSelect.selectByVisibleText(year);
        return this;
    }

    public CreateAccountPage setYearOfBirth(String year) {
        WebElement yearsSelectorLocator = find(yearDropdownLocator);
        Select yearsSelect = new Select(yearsSelectorLocator);
        yearsSelect.selectByVisibleText(year);
        return this;
    }

    public CreateAccountPage setFirstName(String firstName) {
        type(inputFirstNameLocator, firstName);
        return this;
    }

    public CreateAccountPage setLastName(String lastName) {
        type(inputLastNameLocator, lastName);
        return this;
    }

    public CreateAccountPage setCompany(String companyName) {
        type(inputCompanyLocator, companyName);
        return this;
    }

    public CreateAccountPage setFirstAddress(String firstAddress) {
        type(inputFirstAddressLocator, firstAddress);
        return this;
    }

    public CreateAccountPage setSecondAddress(String secondAddress) {
        type(inputSecondAddressLocator, secondAddress);
        return this;
    }

    public CreateAccountPage setCountry(String country) {
        WebElement countrySelectorLocator = find(countryDropdownLocator);
        Select countrySelect = new Select(countrySelectorLocator);
        countrySelect.selectByVisibleText(country);
        return this;
    }

    public CreateAccountPage setState(String state) {
        type(inputStateLocator, state);
        return this;
    }

    public CreateAccountPage setCity(String city) {
        type(inputCityLocator, city);
        return this;
    }

    public CreateAccountPage setZipcode(String zipcode) {
        type(inputZipcodeLocator, zipcode);
        return this;
    }

    public CreateAccountPage setMobileNumber(String mobileNumber) {
        type(inputMobileNumberLocator, mobileNumber);
        return this;
    }

    public HomePage clickCreateAccountButton() {
        click(createAccountButtonLocator);
        return new HomePage(driver);
    }
}