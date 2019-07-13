package com.nroll.web.service;

import com.nroll.web.model.Phone;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface PhoneService {

    List<Phone> findAllByProfileId(int profileID) throws SQLException, ServiceException;
    void addPhone(int profileId, String phoneNumber) throws SQLException, ServiceException;

}
