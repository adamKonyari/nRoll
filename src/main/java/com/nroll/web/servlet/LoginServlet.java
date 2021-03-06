package com.nroll.web.servlet;

import com.nroll.web.dao.UserDao;
import com.nroll.web.dao.database.DatabaseUserDao;
import com.nroll.web.model.User;
import com.nroll.web.service.UserService;
import com.nroll.web.service.exception.ServiceException;
import com.nroll.web.service.simple.SimpleUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            UserDao userDao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUserService(userDao);
            User user = userService.loginUser(req.getParameter("email"), req.getParameter("password"));
            req.getSession().setAttribute("user", user);
            sendMessage(resp,HttpServletResponse.SC_OK, user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}