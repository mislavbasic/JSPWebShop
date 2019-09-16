package com.mbasic.servlet;

import com.mbasic.dal.model.log.OrderLog;
import com.mbasic.dal.model.log.PaymentMethod;
import com.mbasic.dal.model.order.Order;
import com.mbasic.dal.model.user.User;
import com.mbasic.dal.service.model.ModelService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {
    @Inject
    private ModelService modelService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (session.getAttribute("cart") == null){
            response.sendRedirect("/WebShop/cart");
        } else {
            List<Order> cart = (List<Order>) session.getAttribute("cart");
            for (Order order : cart) {
                sb.append(order.getItem().getName());
                sb.append("[");
                sb.append(order.getQty());
                sb.append("]");
                sb.append(",");
            }
            OrderLog orderLog = new OrderLog(user, sb.toString(), new Date(), PaymentMethod.CASH);

            modelService.add(orderLog);

            session.removeAttribute("cart");
            response.sendRedirect("/WebShop/success");
        }
    }
}
