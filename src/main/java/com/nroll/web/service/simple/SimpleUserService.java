package com.nroll.web.service.simple;

import com.nroll.web.dao.UserDao;
import com.nroll.web.model.User;
import com.nroll.web.service.UserService;
import com.nroll.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleUserService implements UserService {

    private final UserDao userDao;

    public SimpleUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loginUser(String email, String password) throws SQLException, ServiceException {
        try {
            User user = userDao.findByEmail(email);
            if (user == null || !user.getPassword().equals(password)) {
                throw new ServiceException("Bad login!");
            }
            return user;
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void addUser(String forename, String lastName, String email, String password) throws SQLException, ServiceException {

    }
}
