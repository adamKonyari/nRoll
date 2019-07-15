package com.nroll.web.model;

import com.nroll.web.model.enums.Gender;
import com.nroll.web.model.enums.ProfileStatus;

import java.util.Date;

public class Profile extends AbstractModel {

    private final String email;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dateOfBirth;
    private final Gender gender;
    private final String phone;
    private final String country;
    private final String zip;
    private final String city;
    private final String address;
    private final int institutionId;
    private final int majorId;
    private final int studentId;
    private final int socialSecurityNumber;
    private final int taxNumber;
    private final ProfileStatus profileStatus;

    public Profile(int id, String email, String firstName, String middleName, String lastName, String dateOfBirth, Gender gender, String phone, String country, String zip, String city, String address, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber, ProfileStatus profileStatus) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.country = country;
        this.zip = zip;
        this.city = city;
        this.address = address;
        this.institutionId = institutionId;
        this.majorId = majorId;
        this.studentId = studentId;
        this.socialSecurityNumber = socialSecurityNumber;
        this.taxNumber = taxNumber;
        this.profileStatus = profileStatus;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public int getMajorId() {
        return majorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public ProfileStatus getProfileStatus() {
        return profileStatus;
    }
}