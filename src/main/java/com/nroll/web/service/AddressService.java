package com.nroll.web.service;

import com.nroll.web.model.Address;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    public void addAddress(int profileId, int zip, String address, String city, String country) throws SQLException, ServiceException;
    List<Address> findAllByProfileId(int profileId) throws SQLException, ServiceException;
}
