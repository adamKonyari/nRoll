package com.nroll.web.dao.database;

import com.nroll.web.dao.AddressDao;
import com.nroll.web.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAddressDao extends AbstractDao implements AddressDao {

    public DatabaseAddressDao(Connection connection) {
        super(connection);
    }

    @Override
    public void addAddress(int profileId, int zip, String address, String city, String country) throws SQLException {
        String sql = "INSERT INTO address (profile_id, zip, address, city, country) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, profileId);
            statement.setInt(2, zip);
            statement.setString(3, address);
            statement.setString(4, city);
            statement.setString(5, country);
            executeInsert(statement);
        }
    }

    @Override
    public List<Address> findAllByProfileId(int profileId) throws SQLException {
        List<Address> addressList = new ArrayList<>();
        String sql = "SELECT * FROM address WHERE profile_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, profileId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    addressList.add(fetchAddress(resultSet));
                }
            }
        }
        return addressList;
    }

    private Address fetchAddress(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int profileId = resultSet.getInt("profile_id");
        int zip = resultSet.getInt("zip");
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String country = resultSet.getString("country");
        return new Address(id, profileId, zip, city, address, country);
    }
}
