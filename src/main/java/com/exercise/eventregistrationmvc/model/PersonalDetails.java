package com.exercise.eventregistrationmvc.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Field required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters")
    @Size(min = 1, message = "Name is required")
    private String fullName;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Email is required")
    private String email;

    @NotNull(message = "Field required")
//    @Pattern(regexp = "^[0-9]", message = "Phone number must contain only numbers")
    @Size(min = 9, message = "Phone number must have min 9 digits")
    private String phoneNumber;

    @NotNull(message = "Field required")
    private LocalDate birthdate;

    @Valid
    @OneToOne(mappedBy = "personalDetails", cascade = CascadeType.ALL)
    private Address address;


    private String dietaryPreferences;


    private String session;


    private String additionalInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
