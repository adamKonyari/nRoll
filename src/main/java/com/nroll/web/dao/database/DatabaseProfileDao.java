package com.nroll.web.dao.database;

import com.nroll.web.dao.ProfileDao;
import com.nroll.web.model.Profile;
import com.nroll.web.model.enums.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseProfileDao extends AbstractDao implements ProfileDao {

    public DatabaseProfileDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Profile> findAllActive() throws SQLException {
        return null;
    }

    @Override
    public List<Profile> findAllByOne(String searchParam) throws SQLException {
        if (searchParam == null || "".equals(searchParam)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        List<Profile> profileList = new ArrayList<>();
        String sql = "SELECT * FROM profile WHERE first_name = ? OR middle_name = ? OR last_name = ? OR email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, searchParam);
            statement.setString(2, searchParam);
            statement.setString(3, searchParam);
            statement.setString(4, searchParam);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    profileList.add(fetchProfile(resultSet));
                }
            }
        }
        return profileList;
    }

    private Profile fetchProfile(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String email = resultSet.getString("email");
        Gender gender = Gender.valueOf(resultSet.getString("gender"));
        String firstName = resultSet.getString("first_name");
        String middleName = resultSet.getString("middle_name");
        String lastName = resultSet.getString("last_name");
        Date dateOfBirth = resultSet.getDate("dob");
        int institutionId = resultSet.getInt("institution_id");
        int majorId = resultSet.getInt("major_id");
        int studentId = resultSet.getInt("student_id");
        int socialSecurityNumber = resultSet.getInt("ss_number");
        int taxNumber = resultSet.getInt("tax_number");
        return new Profile(id, email, gender, firstName, middleName, lastName, dateOfBirth, institutionId, majorId, studentId, socialSecurityNumber, taxNumber);
    }
}
