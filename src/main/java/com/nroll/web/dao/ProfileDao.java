package com.nroll.web.dao;

import com.nroll.web.model.Profile;
import com.nroll.web.model.enums.Gender;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ProfileDao {
    List<Profile> findAllActive() throws SQLException;
    List<Profile> findAllByOne(String searchParam) throws SQLException;
    public int addProfile(String email, String firstName, String middleName, String lastName, String dateOfBirth, Gender gender, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber) throws SQLException;
}
