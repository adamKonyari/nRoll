package com.nroll.web.model;

public class Phone extends AbstractModel {

    private final int profileId;
    private final String number;

    public Phone(int id, int profileId, String number) {
        super(id);
        this.profileId = profileId;
        this.number = number;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getNumber() {
        return number;
    }
}
