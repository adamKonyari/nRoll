package com.nroll.web.service;

import com.nroll.web.model.Profile;
import com.nroll.web.model.enums.Gender;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ProfileService {
    List<Profile> findAllByNameOrEmail(String searchParam) throws SQLException, ServiceException;
    int addProfile(String email, String firstName, String middleName, String lastName, String dateOfBirth, Gender gender, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber) throws SQLException, ServiceException;
}
