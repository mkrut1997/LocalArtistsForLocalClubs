package com.techelevator;


import java.util.List;

public class DJ extends Artist {
    private String numberOfDecks;

    public DJ(String firstName, String lastName, String email, String phoneNumber, String stageName, String[] styles, String numberOfDecks) {
        super(firstName, lastName, email, phoneNumber, stageName, styles);
        this.numberOfDecks = numberOfDecks;
    }

    public String getNumberOfDecks() {
        return numberOfDecks;
    }
}
