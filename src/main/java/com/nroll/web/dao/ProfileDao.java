package com.nroll.web.dao;

import com.nroll.web.model.Profile;
import com.nroll.web.model.enums.Gender;
import com.nroll.web.model.enums.ProfileStatus;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ProfileDao {
    List<Profile> findAllActive() throws SQLException;
    List<Profile> findAllByOne(String searchParam) throws SQLException;
    public int addProfile(String email, String firstName, String middleName, String lastName, String dateOfBirth, Gender gender, String phone, String country, String zip, String city, String address, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber, ProfileStatus profileStatus) throws SQLException;
}
