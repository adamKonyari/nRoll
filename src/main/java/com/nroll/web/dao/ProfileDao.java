package com.nroll.web.dao;

import com.nroll.web.model.Profile;

import java.sql.SQLException;
import java.util.List;

public interface ProfileDao {
    List<Profile> findAllActive() throws SQLException;
    List<Profile> findAllByNameOrEmail(String searchParam) throws SQLException;
}
