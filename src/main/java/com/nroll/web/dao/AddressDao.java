package com.nroll.web.dao;

import com.nroll.web.model.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    void addAddress(int profileId, int zip, String address, String city, String country) throws SQLException;
    List<Address> findAllByProfileId(int profileId) throws SQLException;
}
