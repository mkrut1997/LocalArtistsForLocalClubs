package com.techelevator;

import java.util.List;

public abstract class Artist {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String stageName;
    private String[] styles;

    public Artist(String firstName, String lastName, String email, String phoneNumber, String stageName, String[] styles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.stageName = stageName;
        this.styles = styles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStageName() {
        return stageName;
    }

    public String[] getStyles() {
        return styles;
    }
}
