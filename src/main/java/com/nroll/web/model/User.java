package com.nroll.web.model;

import com.nroll.web.model.enums.UserType;

import java.util.Objects;

public class User extends AbstractModel {

    private final String email;
    private final String password;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final int companyId;
    private final UserType userType;

    public User(int id, String email, String password, String firstname, String middleName, String lastName, int companyId, UserType userType) {
        super(id);
        this.email = email;
        this.password = password;
        this.firstName = firstname;
        this.middleName = middleName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public int getCompanyId() {
        return companyId;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password);
    }
}


