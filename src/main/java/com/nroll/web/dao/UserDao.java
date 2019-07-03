package com.nroll.web.dao;

import com.nroll.web.model.User;

import java.sql.SQLException;

public interface UserDao {

    User findByEmail(String email) throws SQLException;
}
