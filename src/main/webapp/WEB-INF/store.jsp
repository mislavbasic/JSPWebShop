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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
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

                            <c:choose>
                                <c:when test="${laptops == true}">
                                    <input type="checkbox" id="category-1" name="chbLaptops" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" id="category-1" name="chbLaptops">
                                </c:otherwise>
                            </c:choose>

                            <label for="category-1">
                                <span></span>
                                Laptops
                            </label>
                        </div>

                        <div class="input-checkbox">

                            <c:choose>
                                <c:when test="${smartphones == true}">
                                    <input type="checkbox" id="category-2" name="chbSmartphones" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" id="category-2" name="chbSmartphones">
                                </c:otherwise>
                            </c:choose>


                            <label for="category-2">
                                <span></span>
                                Smartphones
                            </label>
                        </div>

                        <div class="input-checkbox">

                            <c:choose>
                                <c:when test="${cameras == true}">
                                    <input type="checkbox" id="category-3" name="chbCameras" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" id="category-3" name="chbCameras">
                                </c:otherwise>
                            </c:choose>

                            <label for="category-3">
                                <span></span>
                                Cameras
                            </label>
                        </div>

                        <div class="input-checkbox">

                            <c:choose>
                                <c:when test="${accessories == true}">
                                    <input type="checkbox" id="category-4" name="chbAccessories" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" id="category-4" name="chbAccessories">
                                </c:otherwise>
                            </c:choose>

                            <label for="category-4">
                                <span></span>
                                Accessories
                            </label>
                        </div>

                    </div>
                </div>

                <div class="col-md-8"></div>
                <div class="btn-group-lg col-md-4">
                    <input class="btn" type="submit" value="Search" style="background-color: #D10024; color: #FFFFFF"/>
                </div>
            </form>

            <div id="store" class="col-md-9">

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
                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</body>
</html>
