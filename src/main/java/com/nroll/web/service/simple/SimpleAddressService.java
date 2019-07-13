package com.nroll.web.service.simple;

import com.nroll.web.dao.AddressDao;
import com.nroll.web.model.Address;
import com.nroll.web.service.AddressService;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleAddressService implements AddressService {

    private AddressDao addressDao;

    public SimpleAddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void addAddress(int profileId, int zip, String address, String city, String country) throws SQLException, ServiceException {
        addressDao.addAddress(profileId, zip, address, city, country);
    }

    @Override
    public List<Address> findAllByProfileId(int profileId) throws SQLException, ServiceException {
        return addressDao.findAllByProfileId(profileId);
    }
}
