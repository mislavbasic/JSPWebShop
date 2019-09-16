package com.mbasic.servlet;

import com.mbasic.dal.model.item.Category;
import com.mbasic.dal.model.item.Item;
import com.mbasic.dal.service.item.ItemService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*This servlet returns items from database, GET shows all items in database
* sorted by price/name. POST handles sort requests*/
@WebServlet(name = "StoreServlet", urlPatterns = {"/store"})
public class StoreServlet extends HttpServlet {

    @Inject
    private ItemService itemService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String laptops = request.getParameter("chbLaptops");
        String smartphones = request.getParameter("chbSmartphones");
        String cameras = request.getParameter("chbCameras");
        String accessories = request.getParameter("chbAccessories");

        List<Item> itemList = new ArrayList<>();

        if (laptops != null){
            itemList.addAll(getItemsByCategory(Category.LAPTOP));
            request.setAttribute("laptops", true);
        }
        if (smartphones != null){
            itemList.addAll(getItemsByCategory(Category.PHONE));
            request.setAttribute("smartphones", true);
        }
        if (cameras != null){
            itemList.addAll(getItemsByCategory(Category.CAMERA));
            request.setAttribute("cameras", true);
        }
        if (accessories != null){
            itemList.addAll(getItemsByCategory(Category.ACCESSORY));
            request.setAttribute("accessories", true);
        }
        if (laptops == null && smartphones == null && cameras == null && accessories == null) {
            itemList.addAll(getAllItems());
            request.setAttribute("laptops", true);
            request.setAttribute("smartphones", true);
            request.setAttribute("cameras", true);
            request.setAttribute("accessories", true);
        }

        request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/store.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> itemList = getAllItems();
        request.setAttribute("itemList", itemList);
        request.setAttribute("laptops", true);
        request.setAttribute("smartphones", true);
        request.setAttribute("cameras", true);
        request.setAttribute("accessories", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/store.jsp");
        dispatcher.forward(request, response);
    }

    private List<Item> getAllItems() {
        return itemService.findAll();
    }

    private List<Item> getItemsByCategory(Category category) {
        return itemService.findByCategory(category.toString());
    }
}
