package com.nroll.web.dao.database;

import com.nroll.web.dao.UserDao;
import com.nroll.web.model.User;
import com.nroll.web.model.enums.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUserDao extends AbstractDao implements UserDao {
    DatabaseUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        if (email == null || "".equals(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        String sql = "SELECT id, email, password, firstname, middle_name, last_name, company_id, type FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchUser(resultSet);
                }
            }
        }
        return null;
    }

    private User fetchUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String firstname = resultSet.getString("firstname");
        String middleName = resultSet.getString("middle_name");
        String lastName = resultSet.getString("last_name");
        int companyId = resultSet.getInt("company_id");
        UserType userType = UserType.valueOf(resultSet.getString("type"));
        return new User(id, email, password, firstname, middleName, lastName, companyId, userType);
    }
}
