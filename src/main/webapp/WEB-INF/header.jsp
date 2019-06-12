<%--
  Created by IntelliJ IDEA.
  User: Mislav
  Date: 4/11/2019
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<header>
    <div id="header">
        <div class="container">
            <div class="row">

                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="${pageContext.request.contextPath}/store" class="logo">
                            <img src="${pageContext.request.contextPath}/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH -->
                <div class="col-md-5">
                    <div class="header-search">
                        <form>
                            <input class="input" placeholder="Search here">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH -->

                <div class="col-md-4">
                    <div class="header-ctn">

                        <c:if test="${sessionScope.user != null && sessionScope.user.getRole() == 'ADMIN'}">
                            <!-- Admin -->
                            <div>
                                <a href="${pageContext.request.contextPath}/admin">
                                    <i class="fa fa-trash-o"></i>
                                    <span>Admin</span>
                                </a>
                            </div>
                            <!-- /Admin -->
                        </c:if>

                        <!-- LoggedIn -->
                        <c:if test="${sessionScope.user != null}"><%--@elvariable id="cart" type="java.util.List"--%>
                            <!-- My Account -->
                            <div>
                                <a href="${pageContext.request.contextPath}/account">
                                    <i class="fa fa-user-o"></i>
                                    <span>My Account</span>
                                </a>
                            </div>
                            <!-- /My Account -->

                            <!-- Cart -->
                            <div>
                                <a href="${pageContext.request.contextPath}/cart">
                                    <i class="fa fa-shopping-cart"></i>
                                    <span>My Cart</span>
                                    <div class="qty">${fn:length(cart)}</div>
                                </a>
                            </div>
                            <!-- /Cart -->

                            <!-- Logout -->
                            <div>
                                <a href="${pageContext.request.contextPath}/logout">
                                    <i class="fa fa-sign-out"></i>
                                    <span>Sign Out</span>
                                </a>
                            </div>
                            <!-- /Logout -->
                        </c:if>
                        <!-- /LoggedIn -->

                        <!-- Anonymous -->
                        <c:if test="${sessionScope.user == null}"><%--@elvariable id="cart" type="java.util.List"--%>
                            <!-- Register -->
                            <div>
                                <a href="${pageContext.request.contextPath}/register">
                                    <i class="fa fa-user-plus"></i>
                                    <span>Register</span>
                                </a>
                            </div>
                            <!-- /Register -->

                            <!-- Cart -->
                            <div>
                                <a href="${pageContext.request.contextPath}/cart">
                                    <i class="fa fa-shopping-cart"></i>
                                    <span>My Cart</span>
                                    <div class="qty">${fn:length(cart)}</div>
                                </a>
                            </div>
                            <!-- /Cart -->

                            <!-- Login -->
                            <div>
                                <a href="${pageContext.request.contextPath}/login">
                                    <i class="fa fa-sign-in"></i>
                                    <span>Sign In</span>
                                </a>
                            </div>
                            <!-- /Login -->
                        </c:if>
                        <!-- /Anonymous -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
