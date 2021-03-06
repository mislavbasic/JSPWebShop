<%--@elvariable id="badLogin" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  user: Mislav
  Date: 4/11/2019
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop - Login</title>
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
        <div class="col-md-3"></div>
        <div class="col-md-6" style="margin-top: 10%; margin-bottom: 15%;">
            <form action="login" method="POST">
                <div class="form-group">
                    <label for="InputEmail">Email address</label>
                    <input type="email" class="form-control" id="InputEmail" placeholder="Enter email" name="eMail"
                           required>
                </div>
                <div class="form-group">
                    <label for="InputPassword">Password</label>
                    <input type="password" class="form-control" id="InputPassword" placeholder="Password"
                           name="password" required>
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="chbRemember">
                    <label class="form-check-label" for="chbRemember">Remember me</label>
                </div>
                <button type="submit" class="btn" style="background-color: #D10024; color: #FFFFFF;">Sign In</button>
            </form>
            <div>
                <p style="color: red;">${badLogin}</p>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>
