package com.mbasic.servlet;

import com.mbasic.dal.model.Item;
import com.mbasic.dal.service.model.ModelService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*This servlet adds items to database,
* only Administrator can access, otherwise redirect to 404 page*/
@WebServlet(name = "AddItemServlet", urlPatterns = {"/admin/addItem"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)
public class AddItemServlet extends HttpServlet {

    @Inject
    private ModelService modelService;
    private static final String SAVE_DIR = "C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/WebShop/img/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<String> imgNames = saveImg(request);
        Item item = createItemObject(request, imgNames);

        //TODO: smislit nesto kvalitetnije
        if (modelService.add(item)) {
            response.sendRedirect("/WebShop/admin");
        } else {
            response.sendRedirect("/WebShop/admin");
        }
    }

    private List<String> saveImg(HttpServletRequest request) throws ServletException, IOException {
        List<String> imgNames = new ArrayList<>();

        List<Part> partList = request.getParts().stream().filter(part -> "imgProduct".equals(part.getName())).collect(Collectors.toList());
        for (Part part : partList) {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            part.write(SAVE_DIR + fileName);
            imgNames.add(fileName);
        }

        return imgNames;
    }

    private Item createItemObject(HttpServletRequest request, List<String> imgNames) {
        return new Item(
                request.getParameter("productName"),
                request.getParameter("productPrice"),
                request.getParameter("productDescription"),
                request.getParameter("productDetails"),
                request.getParameter("productCategory"),
                imgNames
        );
    }
}
