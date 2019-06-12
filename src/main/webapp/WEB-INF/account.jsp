<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/11/2019
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
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
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="margin-top: 5%; margin-bottom: 10%;">
            <div class="form-group">
                <div class="form-group col-md-6">
                    <label for="firstName">First name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName"
                           value="${sessionScope.user.getFirstName()}" readonly>
                </div>
                <div class="form-group col-md-6">
                    <label for="lastName">Last name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName"
                           value="${sessionScope.user.getLastName()}" readonly>
                </div>
            </div>

            <div class="form-group">
                <div class="form-group col-md-6">
                    <label for="eMail">Email</label>
                    <input type="email" class="form-control" id="eMail" name="eMail"
                           value="${sessionScope.user.getEmail()}" readonly>
                </div>
                <div class="form-group col-md-6">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password"
                           value="${sessionScope.user.getPassword()}" readonly>
                </div>
            </div>

            <div class="form-group col-md-12">
                <label for="address1">Address</label>
                <input type="text" class="form-control" id="address1" name="address1"
                       value="${sessionScope.user.getAddress().getAddress1()}" readonly>
            </div>

            <div class="form-group col-md-12">
                <label for="address2">Address 2</label>
                <input type="text" class="form-control" id="address2" name="address2"
                       value="${sessionScope.user.getAddress().getAddress2()}" readonly>
            </div>

            <div class="form-group">
                <div class="form-group col-md-5">
                    <label for="state">State</label>
                    <input type="text" class="form-control" id="state" name="state"
                           value="${sessionScope.user.getAddress().getState()}" readonly>
                </div>
                <div class="form-group col-md-5">
                    <label for="city">City</label>
                    <input type="text" class="form-control" id="city" name="city"
                           value="${sessionScope.user.getAddress().getCity()}" readonly>
                </div>
                <div class="form-group col-md-2">
                    <label for="zip">Zip</label>
                    <input type="text" class="form-control" id="zip" name="zip"
                           value="${sessionScope.user.getAddress().getZip()}" readonly>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
