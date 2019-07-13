package com.nroll.web.service.simple;

import com.nroll.web.dao.PhoneDao;
import com.nroll.web.model.Phone;
import com.nroll.web.service.PhoneService;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimplePhoneService implements PhoneService {

    private PhoneDao phoneDao;

    public SimplePhoneService(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public List<Phone> findAllByProfileId(int profileID) throws SQLException, ServiceException {
        return phoneDao.findAllByProfileId(profileID);
    }

    @Override
    public void addPhone(int profileId, String phoneNumber) throws SQLException, ServiceException {
        phoneDao.addPhone(profileId, phoneNumber);
    }
}
