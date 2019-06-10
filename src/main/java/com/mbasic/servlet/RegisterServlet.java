package com.mbasic.servlet;

import com.mbasic.dal.model.Address;
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
    @Inject
    private ModelService modelService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = createUserObject(request);

        if (modelService.add(user)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/WebShop/store");
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
                "USER",
                new Address(
                        request.getParameter("address1"),
                        request.getParameter("address2"),
                        request.getParameter("state"),
                        request.getParameter("city"),
                        request.getParameter("zip"))
        );
    }
}
