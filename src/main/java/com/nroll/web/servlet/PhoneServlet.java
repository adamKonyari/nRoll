package com.nroll.web.servlet;


import com.nroll.web.dao.PhoneDao;
import com.nroll.web.dao.database.DatabasePhoneDao;
import com.nroll.web.service.PhoneService;
import com.nroll.web.service.exception.ServiceException;
import com.nroll.web.service.simple.SimplePhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/phone")
public class PhoneServlet extends AbstractServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            PhoneDao phoneDao = new DatabasePhoneDao(connection);
            PhoneService phoneService = new SimplePhoneService(phoneDao);
            int profileId = (int) req.getAttribute("profileId");
            String phoneNumber = req.getParameter("phone");
            phoneService.addPhone(profileId, phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
