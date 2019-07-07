package com.nroll.web.service;

import com.nroll.web.model.Profile;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ProfileService {
    List<Profile> findAllByNameOrEmail(String searchParam) throws SQLException, ServiceException;
}
