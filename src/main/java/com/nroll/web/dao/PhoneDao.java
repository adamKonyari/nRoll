package com.nroll.web.dao;

import com.nroll.web.model.Phone;

import java.sql.SQLException;
import java.util.List;

public interface PhoneDao {
    List<Phone> findAllByProfileId(int profileID) throws SQLException;
    void addPhone(int profileId, String phoneNumber) throws SQLException;
}
