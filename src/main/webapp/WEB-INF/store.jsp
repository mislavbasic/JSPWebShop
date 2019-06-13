<%-- Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/11/2019
  Time: 3:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>

<div class="section">
    <div class="container">
        <div class="row">
            <form id="aside" class="col-md-3" action="store" method="POST">
                <div class="aside">
                    <h3 class="aside-title">Categories</h3>
                    <div class="checkbox-filter form-group">

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-1" name="chbLaptops">
                            <label for="category-1">
                                <span></span>
                                Laptops
                                <small>(120)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-2" name="chbSmartphones">
                            <label for="category-2">
                                <span></span>
                                Smartphones
                                <small>(740)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-3" name="chbCameras">
                            <label for="category-3">
                                <span></span>
                                Cameras
                                <small>(1450)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input type="checkbox" id="category-4" name="chbAccessories">
                            <label for="category-4">
                                <span></span>
                                Accessories
                                <small>(578)</small>
                            </label>
                        </div>

                    </div>
                </div>

                <div class="aside">
                    <h3 class="aside-title">Price</h3>
                    <div class="price-filter form-group">
                        <div class="input-number price-min">
                            <input id="price-min" name="priceMin" value="1" type="number">
                            <span class="qty-up">+</span>
                            <span class="qty-down">-</span>
                        </div>
                        <span>-</span>
                        <div class="input-number price-max">
                            <input id="price-max" name="priceMax" value="999" type="number">
                            <span class="qty-up">+</span>
                            <span class="qty-down">-</span>
                        </div>
                    </div>
                </div>

                <div class="col-md-8"></div>
                <div class="btn-group-lg col-md-4">
                    <input class="btn" type="submit" value="Sort" style="background-color: #D10024; color: #FFFFFF"/>
                </div>
            </form>

            <div id="store" class="col-md-9">
                <div class="store-filter">
                    <div class="store-sort">
                        <label>
                            Sort By:
                            <select class="input-select">
                                <option value="0">Popular</option>
                                <option value="1">Position</option>
                            </select>
                        </label>

                        <label>
                            Show:
                            <select class="input-select">
                                <option value="0">20</option>
                                <option value="1">50</option>
                            </select>
                        </label>
                    </div>
                </div>

                <div class="row">
                    <%--@elvariable id="itemList" type="java.util.Collection"--%>
                    <c:forEach items="${itemList}" var="item">
                        <div class="col-md-4 col-xs-6">
                            <div class="product">
                                <a class="product-img" href="product?id=${item.id}">
                                    <img src="${pageContext.request.contextPath}/img/${item.imgNames[0]}" alt="">
                                </a>
                                <div class="product-body">
                                    <h3 class="product-name">${item.name}</h3>
                                    <h4 class="product-price">$${item.price}</h4>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="store-filter">
                    <span class="store-qty">Showing ${fn:length(itemList)} products</span>
                    <ul class="store-pagination">
                        <li class="active">1</li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/numberInput.js"></script>
</body>
</html>
