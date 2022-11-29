package com.techelevator;

import java.util.List;

public class Band extends Artist{
    private String[] equipment;

    public Band(String firstName, String lastName, String email, String phoneNumber, String stageName, String[] styles, String[] equipment) {
        super(firstName, lastName, email, phoneNumber, stageName, styles);
        this.equipment = equipment;
    }

    public String[] getEquipment() {
        return equipment;
    }
}
