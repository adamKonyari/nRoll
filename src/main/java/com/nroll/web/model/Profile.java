package com.nroll.web.model;

import com.nroll.web.model.enums.Gender;

import java.util.Date;

public class Profile extends AbstractModel {

    private final String email;
    private final Gender gender;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final Date dateOfBirth;
    private final int institutionId;
    private final int majorId;
    private final int studentId;
    private final int socialSecurityNumber;
    private final int taxNumber;

    public Profile(int id, String email, Gender gender, String firstName, String middleName, String lastName, Date dateOfBirth, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber) {
        super(id);
        this.email = email;
        this.gender = gender;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.institutionId = institutionId;
        this.majorId = majorId;
        this.studentId = studentId;
        this.socialSecurityNumber = socialSecurityNumber;
        this.taxNumber = taxNumber;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
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
}