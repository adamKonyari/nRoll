package com.nroll.web.service.simple;

import com.nroll.web.dao.ProfileDao;
import com.nroll.web.model.Profile;
import com.nroll.web.model.enums.Gender;
import com.nroll.web.model.enums.ProfileStatus;
import com.nroll.web.service.ProfileService;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleProfileService implements ProfileService {

    private final ProfileDao profileDao;

    public SimpleProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public List<Profile> findAllByNameOrEmail(String searchParam) throws SQLException, ServiceException {
        String[] params = searchParam.split("\\s+");
        List<Profile> profileList = new ArrayList<>();
        for (String param : params) {
            for (Profile profile : profileDao.findAllByOne(param)) {
                if (!profileList.contains(profile)) {
                    profileList.add(profile);
                }
            }
        }
        return profileList;
    }

    @Override
    public int addProfile(String email, String firstName, String middleName, String lastName, String dateOfBirth, Gender gender, String phone, String country, String zip, String city, String address, int institutionId, int majorId, int studentId, int socialSecurityNumber, int taxNumber, ProfileStatus profileStatus) throws SQLException, ServiceException {
        try {
            return profileDao.addProfile(email, firstName, middleName, lastName, dateOfBirth, gender, phone, country, zip, city, address, institutionId, majorId, studentId, socialSecurityNumber, taxNumber, profileStatus);
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
