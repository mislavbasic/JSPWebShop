<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 6/9/2019
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop - Admin</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/slick-theme.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>
<div class="row">
    <div class="col-md-3"></div>

    <div class="col-md-6">
        <div id="product-tab">
            <ul class="tab-nav">
                <li class="active"><a data-toggle="tab" href="#tab1">Login log</a></li>
                <li><a data-toggle="tab" href="#tab2">Add Item</a></li>
            </ul>

            <div class="tab-content">
                <!-- tab1  -->
                <div id="tab1" class="tab-pane fade in active">
                    <div class="row">
                        <div class="col-md-12">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">User Email</th>
                                        <th scope="col">Date Time</th>
                                        <th scope="col">IP Address</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${logList}" var="log">
                                        <tr>
                                            <td>${log.getUserEmail()}</td>
                                            <td>${log.getDateTime()}</td>
                                            <td>${log.getAddress()}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                        </div>
                    </div>
                </div>
                <!-- /tab1  -->

                <!-- tab2  -->
                <div id="tab2" class="tab-pane fade in">
                    <div class="row">
                        <div class="col-md-12">
                            <form action="${pageContext.request.contextPath}/admin/addItem" method="POST" enctype="multipart/form-data">
                                <div class="form-group col-md-6">
                                    <label for="productName">Product name</label>
                                    <input type="text" class="form-control" id="productName" placeholder="Product name" name="productName">
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="productPrice">Price</label>
                                    <input type="text" class="form-control" id="productPrice" placeholder="Price" name="productPrice">
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="productDescription">Description</label>
                                    <textarea class="form-control" id="productDescription" name="productDescription"></textarea>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="productDetails">Details</label>
                                    <textarea class="form-control" id="productDetails" name="productDetails"></textarea>
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="imgProduct">Product image</label>
                                    <input type="file" id="imgProduct" name="imgProduct" value="Upload images..." multiple/>
                                </div>

                                <div class="form-group col-md-6">
                                    <input class="btn pull-right" type="submit" value="Submit" style="background-color: #D10024; color: #FFFFFF; margin-top: 2%;"/>
                                </div>
                            </form>
                            <div>
                                <p style="color: red;">${info}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /tab2  -->
            </div>
        </div>
    </div>
</div>



<%@include file="footer.jsp"%>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>

