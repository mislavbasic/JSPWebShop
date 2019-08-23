package com.mbasic.servlet;

import com.mbasic.dal.model.log.LoginLog;
import com.mbasic.dal.model.log.OrderLog;
import com.mbasic.dal.service.user.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    @Inject
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LoginLog> logList =  userService.findAllLog();
        request.setAttribute("logList", logList);

        List<OrderLog> orderLogs = userService.findAllOrders();
        request.setAttribute("orderList", orderLogs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin.jsp");
        dispatcher.forward(request, response);
    }
}
