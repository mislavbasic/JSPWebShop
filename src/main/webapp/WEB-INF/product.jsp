<%--@elvariable id="item" type="com.mbasic.dal.model.item.Item"--%>
<%--
  Created by IntelliJ IDEA.
  user: Mislav
  Date: 4/15/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${item.name}</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick-theme.css"/>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>

<div class="section">
    <div class="container">
        <div class="row">

            <div class="col-md-5 col-md-push-2">
                <div id="product-main-img">
                    <c:forEach items="${item.imgNames}" var="img">
                        <div class="product-preview">
                            <img src="${pageContext.request.contextPath}/img/${img}" alt="">
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-2 col-md-pull-5">
                <div id="product-imgs">
                    <c:forEach items="${item.imgNames}" var="img">
                        <div class="product-preview">
                            <img src="${pageContext.request.contextPath}/img/${img}" alt="">
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-5">
                <div class="product-details">
                    <h2 class="product-name">${item.name}</h2>
                    <div>
                        <h3 class="product-price">$${item.price}</h3>
                    </div>
                    <p>${item.description}</p>

                    <form class="add-to-cart" action="cart" method="POST">
                        <div class="qty-label">
                            Qty
                            <div class="input-number">
                                <input type="number" value="1" name="qty">
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                        </div>
                        <input type="hidden" value="${item.id}" name="itemId">
                        <input type="hidden" value="add" name="operation">
                        <br>
                        <div style="margin-top: 2%">
                            <button class="add-to-cart-btn" type="submit"><i class="fa fa-shopping-cart"></i> add to cart
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-12">
                <div id="product-tab">
                    <ul class="tab-nav">
                        <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                        <li><a data-toggle="tab" href="#tab2">Details</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="tab1" class="tab-pane fade in active">
                            <div class="row">
                                <div class="col-md-12">
                                    <p>${item.description}</p>
                                </div>
                            </div>
                        </div>

                        <div id="tab2" class="tab-pane fade in">
                            <div class="row">
                                <div class="col-md-12">
                                    <p>${item.details}</p>
                                </div>
                            </div>
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
<script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/numberInput.js"></script>
</body>
</html>
