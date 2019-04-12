package com.mbasic.servlet;

import com.mbasic.dal.model.User;
import com.mbasic.dal.service.model.ModelService;
import com.mbasic.dal.service.user.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*This servlet handles login's, GET requests get get login page,
* POST requests check if posted user is in database.
* If true redirect to /store servlet*/
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    //TODO: checkbox remember me ne radi ništa
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("eMail");
        String password = request.getParameter("password");
        User user = userService.login(email, password);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/store");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("badLogin", "Wrong credentials.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }
}
