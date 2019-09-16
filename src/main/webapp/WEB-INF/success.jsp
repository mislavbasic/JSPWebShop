<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop - Thank you</title>
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
            <div style="text-align: center; margin-bottom: 25%;"><strong>Checkout successful, your items will be delivered to you shortly. &#128512;</strong></div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</body>
</html>
