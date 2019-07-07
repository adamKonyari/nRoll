package com.nroll.web.model;

import java.util.Date;

public class Profile extends AbstractModel{

    private final String email;
    private final String firstname;
    private final String middleName;
    private final String lastName;
    private final Date dateOfBirth;
    private final Institution institution;
    private final Major major;
    private final int studentId;
    private final int socialSecurityNumber;
    private final int taxNumber;

    public Profile(int id, String email, String firstname, String middleName, String lastName, Date dateOfBirth, Institution institution, Major major, int studentId, int socialSecurityNumber, int taxNumber) {
        super(id);
        this.email = email;
        this.firstname = firstname;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.institution = institution;
        this.major = major;
        this.studentId = studentId;
        this.socialSecurityNumber = socialSecurityNumber;
        this.taxNumber = taxNumber;
    }
}
