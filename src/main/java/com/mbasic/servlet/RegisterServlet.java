package com.mbasic.servlet;

import com.mbasic.dal.model.User;
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

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
//TODO: attribute validation
//TODO: ne sprema rvacke znakove u bazu
//TODO: ne redirecta na /store servlet nakon što se user registrira, ali sesija radi čini mi se.....
    @Inject
    private ModelService modelService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("eMail"),
                request.getParameter("password"),
                request.getParameter("address1"),
                request.getParameter("address2"),
                request.getParameter("state"),
                request.getParameter("city"),
                request.getParameter("zip")
        );

        if (modelService.add(user)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/store");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }
}
