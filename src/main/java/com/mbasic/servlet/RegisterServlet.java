package com.mbasic.servlet;

import com.mbasic.dal.model.user.Address;
import com.mbasic.dal.model.log.LoginLog;
import com.mbasic.dal.model.user.Role;
import com.mbasic.dal.model.user.User;
import com.mbasic.dal.service.model.ModelService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Inject
    private ModelService modelService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = createUserObject(request);
        Address address = createAddressObject(request, user);

        if (modelService.add(user)){
            modelService.add(address);
            response.sendRedirect("/WebShop/login");
        } else {
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
        dispatcher.forward(request, response);
    }

    private User createUserObject(HttpServletRequest request) {
        return new User(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("eMail"),
                request.getParameter("password"),
                Role.USER);
    }

    private Address createAddressObject(HttpServletRequest request, User user) {
        return new Address(
                request.getParameter("address1"),
                request.getParameter("address2"),
                request.getParameter("state"),
                request.getParameter("city"),
                request.getParameter("zip"),
                user);
    }
}
