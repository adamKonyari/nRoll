package com.nroll.web.model;

import java.util.Date;
import java.util.Objects;

public class Profile extends AbstractModel{

    private final String email;
    private final String firstname;
    private final String middleName;
    private final String lastName;
    private final Date dateOfBirth;
    private final int institutionId;
    private final int majorId;
    private final int studentId;
    private final int socialSecurityNumber;
    private final int taxNumber;

    public Profile(int id, String email, String firstname, String middleName, String lastName, Date dateOfBirth, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber) {
        super(id);
        this.email = email;
        this.firstname = firstname;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.institutionId = institutionId;
        this.majorId = majorId;
        this.studentId = studentId;
        this.socialSecurityNumber = socialSecurityNumber;
        this.taxNumber = taxNumber;
    }
}
