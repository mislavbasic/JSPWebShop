package com.mbasic.servlet;

import com.mbasic.dal.service.item.ItemService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Inject
    private ItemService itemService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("item", itemService.findById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product.jsp");
        dispatcher.forward(request, response);
    }
}
