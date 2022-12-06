package com.techelevator.Models;

public class Equipment {
    private int eqId;
    private String eqName;

    public int getEqId() {
        return eqId;
    }

    public void setEqId(int eqId) {
        this.eqId = eqId;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    @Override
    public String toString() {
        return eqId + ") " + eqName;
    }
}
