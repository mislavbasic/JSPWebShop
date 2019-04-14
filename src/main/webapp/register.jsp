<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/12/2019
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Moj WebShop - Login</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="loggedIn" value="${sessionScope.user}"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <form action="register" method="POST">
                <div class="form-group">
                    <div class="form-group col-md-6">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control" id="firstName" placeholder="First name" name="firstName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastName">Last name</label>
                        <input type="text" class="form-control" id="lastName" placeholder="Last name" name="lastName">
                    </div>
                </div>

                <div class="form-group">
                    <div class="form-group col-md-6">
                        <label for="eMail">Email</label>
                        <input type="email" class="form-control" id="eMail" placeholder="Email" name="eMail">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                    </div>
                </div>

                <div class="form-group col-md-12">
                    <label for="address1">Address</label>
                    <input type="text" class="form-control" id="address1" placeholder="1234 Main St" name="address1">
                </div>

                <div class="form-group col-md-12">
                    <label for="address2">Address 2</label>
                    <input type="text" class="form-control" id="address2" placeholder="Apartment, studio, or floor" name="address2">
                </div>
                <!-- TODO: validacija forme...-->
                <div class="form-group">
                    <div class="form-group col-md-5">
                        <label for="state">State</label>
                        <input type="text" class="form-control" id="state" name="state">
                    </div>
                    <div class="form-group col-md-5">
                        <label for="city">City</label>
                        <input type="text" class="form-control" id="city" name="city">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="zip">Zip</label>
                        <input type="text" class="form-control" id="zip" name="zip">
                    </div>
                </div>
                <div class="col-md-5"></div>
                <input type="submit" value="Register" class="btn btn-danger" style="margin-top: 3%">
            </form>
        </div>
    </div>
</div>

<div style="position: fixed; bottom: 0; width: 100%;">
    <%@include file="footer.jsp"%>
</div>
</body>
</html>

