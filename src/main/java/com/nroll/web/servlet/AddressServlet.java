package com.nroll.web.servlet;

import com.nroll.web.dao.AddressDao;
import com.nroll.web.dao.database.DatabaseAddressDao;
import com.nroll.web.service.AddressService;
import com.nroll.web.service.exception.ServiceException;
import com.nroll.web.service.simple.SimpleAddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/address")
public class AddressServlet extends AbstractServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            AddressDao addressDao = new DatabaseAddressDao(connection);
            AddressService addressService = new SimpleAddressService(addressDao);
            int profileId = (int) req.getAttribute("profileId");
            int zip = Integer.parseInt(req.getParameter("zip"));
            String address = req.getParameter("address");
            String city = req.getParameter("city");
            String country = req.getParameter("country");
            addressService.addAddress(profileId, zip, address, city, country);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
