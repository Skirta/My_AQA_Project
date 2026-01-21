package com.automationexercise.helpers;

import com.automationexercise.models.UserRegistrationDetails;

public class UserFactory {

    public static UserRegistrationDetails createNewUser() {
        String[] randomBirthDate = DataRandomizer.getRandomBirthDate();
        return UserRegistrationDetails.builder()
                .gender(DataRandomizer.getRandomGender())
                .email(DataRandomizer.getRandomEmail())
                .password(DataRandomizer.getRandomPassword())
                .dayOfBirth(randomBirthDate[0])
                .monthOfBirth(randomBirthDate[1])
                .yearOfBirth(randomBirthDate[2])
                .firstName(DataRandomizer.getRandomFirstName())
                .lastName(DataRandomizer.getRandomLastName())
                .companyName(DataRandomizer.getRandomCompanyName())
                .firstAddress(DataRandomizer.getRandomFirstAddress())
                .secondAddress(DataRandomizer.getRandomSecondAddress())
                .country(DataRandomizer.getRandomCountry())
                .state(DataRandomizer.getRandomState())
                .city(DataRandomizer.getRandomCity())
                .zipCode(DataRandomizer.getRandomZipCode())
                .mobileNumber(DataRandomizer.getRandomMobileNumber())
                .build();
    }
}