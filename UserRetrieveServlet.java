package com.parking.servlet;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.dao.UserRetrieveDAO;
import com.parking.model.userretrive;



@WebServlet("/UserRetrieveServlet")
public class UserRetrieveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create an instance of UserRetrieveDAO to fetch users
        UserRetrieveDAO userDAO = new UserRetrieveDAO();
        List<userretrive> userList = userDAO.getAllUsers();

        // Set the user list as a request attribute
        request.setAttribute("users", userList);

        // Forward the request to the JSP page for displaying users
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }
}
