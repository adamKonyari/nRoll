package com.nroll.web.dao.database;

import com.nroll.web.dao.PhoneDao;
import com.nroll.web.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePhoneDao extends AbstractDao implements PhoneDao {
    public DatabasePhoneDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Phone> findAllByProfileId(int profileId) throws SQLException {
        List<Phone> phoneList = new ArrayList<>();
        String sql = "SELECT * FROM phone WHERE profile_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, profileId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    phoneList.add(fetchPhone(resultSet));
                }
            }
            return phoneList;
        }
    }

    @Override
    public void addPhone(int profileId, String phoneNumber) throws SQLException {
        String sql = "INSERT INTO phone (profile_id, number) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, profileId);
            statement.setString(2, phoneNumber);
            executeInsert(statement);
        }
    }


    private Phone fetchPhone(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int profileId = resultSet.getInt("profile_id");
        String number = resultSet.getString("number");
        return new Phone(id, profileId, number);
    }

}
