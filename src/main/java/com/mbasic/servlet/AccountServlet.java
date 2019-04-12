package com.mbasic.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*This servlet handles all account information,
* only requests with attribute "user" in their session object (users that are logged in)
* can access this servlet, otherwise they get redirected to /login servlet.*/
@WebServlet(name = "AccountServlet", urlPatterns = {"/account"})
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkLogIn(request)){
            prepareHeaderIcons(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/account.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    private boolean checkLogIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("user") != null;
    }

    private void prepareHeaderIcons(HttpServletRequest request) {
        request.setAttribute("loggedIn", 1);
    }
}
