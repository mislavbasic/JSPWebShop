package com.mbasic.servlet;

import com.mbasic.dal.model.log.LoginLog;
import com.mbasic.dal.model.user.User;
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
import java.util.Date;

/*This servlet handles login's.
* POST requests check if posted user is in database.
* If true add user to session, save login time and redirect to /store servlet*/
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Inject
    private ModelService modelService;

    //TODO: checkbox remember me ne radi ništa
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = findUser(request);

        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            LoginLog loginLog = new LoginLog(user, new Date(), request.getRemoteAddr());
            modelService.add(loginLog);
            response.sendRedirect("/WebShop/store");
        } else {
            request.setAttribute("badLogin", "Wrong credentials.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }

    private User findUser(HttpServletRequest request) {
        String email = request.getParameter("eMail");
        String password = request.getParameter("password");
        return userService.login(email, password);
    }
}
