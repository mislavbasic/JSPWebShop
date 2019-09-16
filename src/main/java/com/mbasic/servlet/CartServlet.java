package com.mbasic.servlet;

import com.mbasic.dal.model.item.Item;
import com.mbasic.dal.model.order.Order;
import com.mbasic.dal.service.item.ItemService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Inject
    private ItemService itemService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        switch (request.getParameter("operation")) {
            case "add":
                int itemIdAdd = Integer.parseInt(request.getParameter("itemId"));
                Item item = itemService.findById(itemIdAdd);

                int qtyAdd = Integer.parseInt(request.getParameter("qty"));
                Order order = new Order(item, qtyAdd);
                addToCart(session, order);
                break;
            case "update":
                int itemIdUpdate = Integer.parseInt(request.getParameter("itemId"));
                int qtyUpdate = Integer.parseInt(request.getParameter("qty"));
                updateCart(session, itemIdUpdate, qtyUpdate);
                break;
            case "remove":
                int itemIdRemove = Integer.parseInt(request.getParameter("itemId"));
                removeFromCart(session, itemIdRemove);
                break;
        }

        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    private void removeFromCart(HttpSession session, int itemIdRemove) {
        List<Order> cart = (List<Order>) session.getAttribute("cart");
        Order orderToRemove = null;
        for (Order o : cart) {
            if (o.getItem().getId() == itemIdRemove) {
                orderToRemove = o;
            }
        }
        cart.remove(orderToRemove);
        if (!cart.isEmpty()){
            double total = calculateTotal(cart);
            session.setAttribute("cart", cart);
            session.setAttribute("total", total);
        } else{
            session.removeAttribute("cart");
        }

    }

    private void updateCart(HttpSession session, int itemIdUpdate, int qtyUpdate) {
        List<Order> cart = (List<Order>) session.getAttribute("cart");
        for (Order o : cart) {
            if (o.getItem().getId() == itemIdUpdate) {
                o.setQty(qtyUpdate);
            }
        }
        double total = calculateTotal(cart);
        session.setAttribute("cart", cart);
        session.setAttribute("total", total);
    }

    private void addToCart(HttpSession session, Order order) {
        if (session.getAttribute("cart") == null) {
            List<Order> cart = new ArrayList<>();
            cart.add(order);
            double total = calculateTotal(cart);
            session.setAttribute("cart", cart);
            session.setAttribute("total", total);
        } else {
            boolean isFound = false;
            List<Order> cart = (List<Order>) session.getAttribute("cart");
            for (Order o : cart) {
                if (o.getItem().getId() == order.getItem().getId()) {
                    o.addQty(order.getQty());
                    isFound = true;
                }
            }
            if (!isFound) {
                cart.add(order);
            }
            double total = calculateTotal(cart);
            session.setAttribute("cart", cart);
            session.setAttribute("total", total);
        }
    }

    private double calculateTotal(List<Order> cart) {
        double total = 0;
        for (Order o : cart) {
            total += o.getQty() * Double.parseDouble(o.getItem().getPrice());
        }
        return total;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/cart.jsp");
        dispatcher.forward(request, response);
    }
}
