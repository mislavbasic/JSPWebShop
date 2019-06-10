package com.mbasic.servlet;

import com.mbasic.dal.model.Item;
import com.mbasic.dal.service.model.ModelService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*This servlet adds items to database,
* only Administrator can access, otherwise redirect to 404 page*/
@WebServlet(name = "AddItemServlet", urlPatterns = {"/admin/addItem"})
public class AddItemServlet extends HttpServlet {

    @Inject
    private ModelService modelService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Item l1 = new Item();
        l1.setName("Lapatop");
        l1.setDescription("Ovo je super lapatop");
        l1.setPrice(999.99);
        l1.setCategory("laptop");

        Item l2 = new Item();
        l2.setName("Lapatop2");
        l2.setDescription("Ovo je super lapatop2");
        l2.setPrice(1999.99);
        l2.setCategory("laptop");

        modelService.add(l1);
        modelService.add(l2);
    }
}
