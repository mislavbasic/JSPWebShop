package com.mbasic.servlet;

import com.mbasic.dal.model.Item;
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
import java.util.List;

/*This servlet returns items from database, GET shows all items in database
* sorted by price/name. POST handles sort requests*/
@WebServlet(name = "StoreServlet", urlPatterns = {"/store"})
public class StoreServlet extends HttpServlet {

    @Inject
    private ItemService itemService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: logika za sort
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prepareHeaderIcons(request);
        getAllItems(request);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/store.jsp");
        dispatcher.forward(request, response);
    }

    private void getAllItems(HttpServletRequest request) {
        List<Item> itemList = itemService.findAll();
        request.setAttribute("itemList", itemList);
    }

    private void prepareHeaderIcons(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            request.setAttribute("loggedIn", 1);
        }
    }
}
