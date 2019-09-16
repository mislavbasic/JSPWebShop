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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="order-details" style="margin-bottom: 20%;">

            <c:choose>
                <c:when test="${sessionScope.cart == null || empty sessionScope.cart}">
                    <div style="text-align: center; margin-bottom: 25%;"><strong>Cart is empty, please add products. &#128577;</strong></div>
                </c:when>
                <c:otherwise>
                    <div class="order-summary">
                        <div class="order-col">
                            <div></div>
                            <div><strong>PRODUCT</strong></div>
                            <div><strong>QTY</strong></div>
                            <div></div>
                            <div><strong>PRICE</strong></div>
                        </div>

                        <c:forEach items="${sessionScope.cart}" var="order">
                            <div class="order-col">
                                <div><img src="${pageContext.request.contextPath}/img/${order.item.imgNames[0]}" style="width:50px;height:50px;" alt=""></div>
                                <div>${order.item.name}</div>
                                <div style="padding-right: 33%">
                                    <div class="input-number">
                                        <input type="number" value="${order.qty}" id="${order.item.id}" readonly>
                                        <span class="qty-up">+</span>
                                        <span class="qty-down">-</span>
                                    </div>
                                </div>
                                <div>
                                    <button class="btn" style="background-color: #D10024; color: #FFFFFF" value="${order.item.id}">Remove</button>
                                </div>
                                <div>$${order.item.price * order.qty}</div>
                            </div>
                        </c:forEach>

                        <div class="order-col">
                            <div><strong>TOTAL</strong></div>
                            <div></div>
                            <div></div>
                            <div></div>
                            <div><strong class="order-total">$${sessionScope.total}</strong></div>
                        </div>
                    </div>

                    <c:if test="${sessionScope.user != null}">
                        <div class="payment-method">
                            <div class="input-radio">
                                <input type="radio" name="payment" id="payment-3">
                                <label for="payment-3">
                                    <span></span>
                                    Paypal
                                </label>
                                <div id="paypal-button-container" style="width: 20%" class="caption"></div>
                            </div>

                            <div class="input-radio">
                                <input type="radio" name="payment" id="payment-1">
                                <label for="payment-1">
                                    <span></span>
                                    Cash On Delivery
                                </label>
                                <div class="caption">
                                    <a href="${pageContext.request.contextPath}/order" class="primary-btn order-submit">Place order</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/numberInputCart.js"></script>
<script src="https://www.paypal.com/sdk/js?client-id=Ad1nzMjMbq3iaKuO2FZJzZlLBxLTjfPA1V6DrqCC1hPHUEtH_4QnjiYo6AvFmAkyarqnaWlVHIjVjHYl"></script>
<script>  paypal.Buttons({
    style: {
        size: 'responsive',
        layout: 'horizontal',
        color:  'blue',
        shape:  'pill',
        label:  'checkout',
        tagline: 'false'
    },

    createOrder: function(data, actions) {
        return actions.order.create({
            purchase_units: [{
                amount: {
                    currency_code: 'USD',
                    value: '${sessionScope.total}',
                    breakdown: {
                        item_total: {
                            currency_code: 'USD',
                            value: '${sessionScope.total}'
                        }
                    }
                },
                items: [
                    <c:forEach items="${sessionScope.cart}" var="order">
                    {
                        name: '${order.item.name}',
                        unit_amount: {
                            currency_code: 'USD',
                            value: '${order.item.price}'
                        },
                        quantity: '${order.qty}',
                        description: '${order.item.description}'
                    },
                    </c:forEach>
                ]
            }]
        });
    },
    onApprove: function(data, actions) {
        return actions.order.capture().then(function(details) {
            window.location.href = 'success';
            //alert('Transaction completed by ' + details.payer.name.given_name);
            // Call your server to save the transaction
            return fetch('/WebShop/paypal-transaction-complete', {
                method: 'post',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify({
                    orderID: data.orderID
                })
            });
        });
    }
}).render('#paypal-button-container');
</script>
</body>
</html>
