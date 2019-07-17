package com.nroll.web.servlet;

import com.nroll.web.dao.ProfileDao;
import com.nroll.web.dao.database.DatabaseProfileDao;
import com.nroll.web.model.enums.Gender;
import com.nroll.web.model.enums.ProfileStatus;
import com.nroll.web.service.ProfileService;
import com.nroll.web.service.exception.ServiceException;
import com.nroll.web.service.simple.SimpleProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/profile")
public class ProfileServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            ProfileDao profileDao = new DatabaseProfileDao(connection);
            ProfileService profileService = new SimpleProfileService(profileDao);
            String email = req.getParameter("email");
            String firstName = req.getParameter("firstName");
            String middleName = req.getParameter("middleName");
            String lastName = req.getParameter("lastName");
            String dateOfBirth = req.getParameter("dateOfBirth");
            Gender gender = Gender.valueOf(req.getParameter("gender"));
            String phone = req.getParameter("phone");
            String country = req.getParameter("country");
            String zip = req.getParameter("zip");
            String city = req.getParameter("city");
            String address = req.getParameter("address");
            int institutionId = Integer.parseInt(req.getParameter("institutionId"));
            int majorId = Integer.parseInt(req.getParameter("majorId"));
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            int socialSecurityNumber = Integer.parseInt(req.getParameter("socialSecurityNumber"));
            int taxNumber = Integer.parseInt(req.getParameter("taxNumber"));
            ProfileStatus profileStatus = ProfileStatus.valueOf(req.getParameter("profileStatus"));
            int profileId = profileService.addProfile(email, firstName, middleName, lastName, dateOfBirth, gender, phone, country, zip, city, address, institutionId, majorId, studentId, socialSecurityNumber, taxNumber, profileStatus);
            sendMessage(resp, HttpServletResponse.SC_OK, "Profile added!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
