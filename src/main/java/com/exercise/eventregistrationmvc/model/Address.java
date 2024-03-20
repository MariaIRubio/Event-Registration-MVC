package com.exercise.eventregistrationmvc.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @OneToOne
    @JoinColumn(name = "personalDetails_id")
    private PersonalDetails personalDetails;

    @NotNull(message = "Field required")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Street must contain only letters or numbers")
    @Size(min = 1, message = "Street is required")
    private String street;

    @NotNull(message = "Field required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City must contain only letters")
    @Size(min = 1, message = "City is required")
    private String city;

    @NotNull(message = "Field required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "State must contain only letters")
    @Size(min = 1, message = "State is required")
    private String state;

    @NotNull(message = "Field required")
//    @Pattern(regexp = "^[0-9]", message = "ZIP must contain only numbers")
    @Size(min = 5, message = "ZIP must have min 5 digits")
    private String zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
