package com.chinook.dataaccess.models;

public class CustomerCountry {
    private String country;
    private String postalCode;

    public CustomerCountry(String country, String postalCode) {
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
