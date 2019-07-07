package com.nroll.web.servlet;

import com.nroll.web.dao.ProfileDao;
import com.nroll.web.dao.database.DatabaseProfileDao;
import com.nroll.web.model.Profile;
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
import java.util.List;

@WebServlet("/protected/search")
public class SearchServlet extends AbstractServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            ProfileDao profileDao = new DatabaseProfileDao(connection);
            ProfileService profileService = new SimpleProfileService(profileDao);
            List<Profile> profileList = profileService.findAllByNameOrEmail(req.getParameter("searchString"));
            sendMessage(resp,HttpServletResponse.SC_OK, profileList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
