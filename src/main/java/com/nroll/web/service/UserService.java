package com.nroll.web.service;

import com.nroll.web.model.User;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface UserService {

    User loginUser(String email, String password) throws SQLException, ServiceException;

    void addUser(String forename, String lastName, String email, String password) throws SQLException, ServiceException;

}
