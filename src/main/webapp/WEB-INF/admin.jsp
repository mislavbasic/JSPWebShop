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
        <table class="table" title="Login info">
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



<%@include file="footer.jsp"%>
</body>
</html>

