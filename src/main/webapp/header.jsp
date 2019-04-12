<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/11/2019
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HEADER -->
<header>

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="store" class="logo">
                            <img src="./img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-5">
                    <div class="header-search">
                        <form>
                            <input class="input" placeholder="Search here">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-4">
                    <div class="header-ctn">
                        <!-- My Account -->
                        <c:if test="${loggedIn == 1}">
                            <div>
                                <a href="account">
                                    <i class="fa fa-user-o"></i>
                                    <span>My Account</span>
                                </a>
                            </div>
                        </c:if>
                        <!-- /My Account -->

                        <!-- Cart -->
                        <div>
                            <a href="#">
                                <i class="fa fa-shopping-cart"></i>
                                <span>My Cart</span>
                                <div class="qty">3</div>
                            </a>
                        </div>
                        <!-- /Cart -->

                        <!-- Logout -->
                        <c:if test="${loggedIn == 1}">
                            <div>
                                <a href="logout">
                                    <i class="fa fa-sign-out"></i>
                                    <span>Sign Out</span>
                                </a>
                            </div>
                        </c:if>
                        <!-- /Logout -->

                        <!-- Login -->
                        <c:if test="${loggedIn != 1}">
                            <div>
                                <a href="login">
                                    <i class="fa fa-sign-in"></i>
                                    <span>Sign In</span>
                                </a>
                            </div>
                        </c:if>
                        <!-- /Login -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->
