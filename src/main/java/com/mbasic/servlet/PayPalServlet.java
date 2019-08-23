package com.mbasic.servlet;

import com.braintreepayments.http.HttpResponse;
import com.braintreepayments.http.serializer.Json;
import com.mbasic.dal.model.log.OrderLog;
import com.mbasic.dal.model.log.PaymentMethod;
import com.mbasic.dal.model.user.User;
import com.mbasic.dal.service.model.ModelService;
import com.mbasic.paypal.PayPalClient;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersGetRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PayPalServlet", urlPatterns = {"/paypal-transaction-complete"})
public class PayPalServlet extends HttpServlet {

    @Inject
    private PayPalClient payPalClient;

    @Inject
    private ModelService modelService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderID = getOrderID(request);
        OrdersGetRequest payPalRequest = new OrdersGetRequest(orderID);
        HttpResponse<Order> payPalResponse = payPalClient.getClient().execute(payPalRequest);
        JSONObject payPalResponseJSON = new JSONObject(new Json().serialize(payPalResponse.result()));
        JSONArray jsonPurchaseUnitsArray = payPalResponseJSON.getJSONArray("purchase_units");
        JSONObject jsonObject = jsonPurchaseUnitsArray.getJSONObject(0);
        JSONArray jsonArrayItems = jsonObject.getJSONArray("items");

        StringBuilder sb = new StringBuilder();

        for (Object i : jsonArrayItems) {
            JSONObject jsonItem = (JSONObject) i;
            String itemName = jsonItem.get("name").toString();
            sb.append(itemName);
            sb.append("|");
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        OrderLog orderLog = new OrderLog(user, sb.toString(), "datum", PaymentMethod.PAYPAL);

        modelService.add(orderLog);
    }

    private String getOrderID(HttpServletRequest request) throws IOException{
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null){
            sb.append(line);
        }
        JSONObject jsonObject =  new JSONObject(sb.toString());
        return jsonObject.getString("orderID");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
