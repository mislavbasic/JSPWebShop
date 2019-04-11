package com.mbasic.servlet;

import com.mbasic.dal.model.Item;
import com.mbasic.dal.service.item.ItemService;
import com.mbasic.dal.service.model.ModelService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StoreServlet", urlPatterns = {"/store"})
public class StoreServlet extends HttpServlet {

    @Inject
    private ItemService itemService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> itemList = itemService.findByCategory("'laptop'");
        request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/store.jsp");
        dispatcher.forward(request, response);
    }
}
