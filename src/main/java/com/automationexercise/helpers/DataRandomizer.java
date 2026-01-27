package com.automationexercise.helpers;

import com.automationexercise.models.UserRegistrationDetails;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataRandomizer {
    private static final Faker faker = new Faker();

    public static UserRegistrationDetails.Gender getRandomGender() {
        UserRegistrationDetails.Gender[] genders = UserRegistrationDetails.Gender.values();
        return genders[faker.random().nextInt(genders.length)];
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomCompanyName() {
        return faker.company().name();
    }

    public static String getRandomFirstAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomSecondAddress() {
        return faker.address().secondaryAddress();
    }

    public static String getRandomCountry() {
        List<String> countryList = List.of("India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore");
        return countryList.get(new Random().nextInt(countryList.size()));
    }

    public static String getRandomState() {
        return faker.address().state();
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomZipCode() {
        return faker.address().zipCode();
    }

    public static String getRandomMobileNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String[] getRandomBirthDate() {
        Date birthday = faker.date().birthday(18, 70);
        LocalDate localDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        String formattedData = localDate.format(formatter);
        return formattedData.split(" ");
    }

    public static String getRandomSubject() {
        return faker.lorem().sentence();
    }

    public static String getRandomMessage() {
        return faker.lorem().paragraph();
    }

}