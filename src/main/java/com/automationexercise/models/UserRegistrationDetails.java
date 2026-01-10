package com.automationexercise.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationDetails {

    public enum Gender {MR, MRS}
    private Gender gender;

    private String email;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String firstName;
    private String lastName;
    private String companyName;
    private String firstAddress;
    private String secondAddress;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;
}