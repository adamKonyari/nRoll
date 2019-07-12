package com.nroll.web.model;

public class Address extends AbstractModel {

    private final int profileId;
    private final int zip;
    private final String city;
    private final String address;
    private final String country;

    public Address(int id, int profileId, int zip, String city, String address, String country) {
        super(id);
        this.profileId = profileId;
        this.zip = zip;
        this.city = city;
        this.address = address;
        this.country = country;
    }

    public int getProfileId() {
        return profileId;
    }

    public int getZip() {
        return zip;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }
}
