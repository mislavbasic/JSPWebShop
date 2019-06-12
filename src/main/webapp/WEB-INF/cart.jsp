<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/16/2019
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop - Cart</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="order-details">
            <div class="order-summary">
                <div class="order-col">
                    <div><strong>PRODUCT</strong></div>
                    <div><strong>QTY</strong></div>
                    <div><strong>REMOVE</strong></div>
                    <div><strong>TOTAL</strong></div>
                </div>

                <c:forEach items="${sessionScope.cart}" var="item">
                    <div class="order-col">
                        <div>${item.name}</div>
                        <div style="padding-right: 33%">
                            <div class="input-number">
                                <input type="number" value="1">
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn-danger">X</button>
                        </div>
                        <div>${item.price}</div>
                    </div>
                </c:forEach>

                <div class="order-col">
                    <div><strong>TOTAL</strong></div>
                    <div></div>
                    <div></div>
                    <div><strong class="order-total">$2940.00</strong></div>
                </div>
            </div>
            <div class="payment-method">
                <div class="input-radio">
                    <input type="radio" name="payment" id="payment-3">
                    <label for="payment-3">
                        <span></span>
                        Paypal
                    </label>
                    <div class="caption">
                        <p>PEJPAL IMPLEMENTIRAT OVDJE!</p>
                    </div>
                </div>

                <div class="input-radio">
                    <input type="radio" name="payment" id="payment-1">
                    <label for="payment-1">
                        <span></span>
                        Cash On Delivery
                    </label>
                    <div class="caption">
                        <p>You will pay to the mailman on delivery.</p>
                    </div>
                </div>
            </div>
            <a href="#" class="primary-btn order-submit">Place order</a>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
