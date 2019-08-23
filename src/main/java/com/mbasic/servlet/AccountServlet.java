package com.mbasic.servlet;

import com.mbasic.dal.model.log.OrderLog;
import com.mbasic.dal.model.user.User;
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
import java.util.List;

/*This servlet handles all account information,
* only requests with attribute "user" in their session object (users that are logged in)
* can access this servlet, otherwise they get redirected to /login servlet.*/
@WebServlet(name = "AccountServlet", urlPatterns = {"/account"})
public class AccountServlet extends HttpServlet {

    @Inject
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<OrderLog> orderLogs = userService.findMyOrders(user);
        request.setAttribute("orderList", orderLogs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/account.jsp");
        dispatcher.forward(request, response);
    }

}
