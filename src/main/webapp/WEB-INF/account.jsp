<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/11/2019
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop - Account</title>
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

<div class="row" style="margin-right: 15px;">
    <div class="col-md-3"></div>

    <div class="col-md-6">
        <div id="product-tab">
            <ul class="tab-nav">
                <li class="active"><a data-toggle="tab" href="#tab1">Details</a></li>
                <li><a data-toggle="tab" href="#tab2">Order history</a></li>
            </ul>

            <div class="tab-content">
                <div id="tab1" class="tab-pane fade in active">
                    <div class="row">
                        <div class="col-md-12" style="margin-bottom: 10%;">
                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <label for="firstName">First name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName"
                                           value="${sessionScope.user.firstName}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="lastName">Last name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName"
                                           value="${sessionScope.user.lastName}" readonly>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="form-group col-md-6">
                                    <label for="eMail">Email</label>
                                    <input type="email" class="form-control" id="eMail" name="eMail"
                                           value="${sessionScope.user.email}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password" name="password"
                                           value="${sessionScope.user.password}" readonly>
                                </div>
                            </div>

                            <div class="form-group col-md-12">
                                <label for="address1">Address</label>
                                <input type="text" class="form-control" id="address1" name="address1"
                                       value="${sessionScope.user.addresses[0].address1}" readonly>
                            </div>

                            <div class="form-group col-md-12">
                                <label for="address2">Address 2</label>
                                <input type="text" class="form-control" id="address2" name="address2"
                                       value="${sessionScope.user.addresses[0].address2}" readonly>
                            </div>

                            <div class="form-group">
                                <div class="form-group col-md-5">
                                    <label for="state">State</label>
                                    <input type="text" class="form-control" id="state" name="state"
                                           value="${sessionScope.user.addresses[0].state}" readonly>
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="city">City</label>
                                    <input type="text" class="form-control" id="city" name="city"
                                           value="${sessionScope.user.addresses[0].city}" readonly>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="zip">Zip</label>
                                    <input type="text" class="form-control" id="zip" name="zip"
                                           value="${sessionScope.user.addresses[0].zip}" readonly>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div id="tab2" class="tab-pane fade in">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table" style="margin-bottom: 300px;">
                                <thead>
                                <tr>
                                    <th scope="col">Item names</th>
                                    <th scope="col">Order date</th>
                                    <th scope="col">Payment method</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--@elvariable id="orderList" type="java.util.List"--%>
                                <c:forEach items="${orderList}" var="order">
                                    <tr>
                                        <td>${order.itemNames}</td>
                                        <td>${order.orderDate}</td>
                                        <td>${order.paymentMethod}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
