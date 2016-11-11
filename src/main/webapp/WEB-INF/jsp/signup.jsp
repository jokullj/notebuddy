<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
    <title>NoteBuddy - Signup</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <spring:url value="/resources/main.css" var="mainCSS" />
    <link href="${mainCSS}" rel="stylesheet" />
    <spring:url value="/resources/loginsignup.css" var="loginsignupCSS" />
    <link href="${loginsignupCSS}" rel="stylesheet" />
</head>
<body>
    <div class="site-wrapper">

        <div class="site-wrapper-inner">

            <div class="cover-container">

                <div class="masthead clearfix">
                    <div class="inner">
                        <h2 class="masthead-brand">NoteBuddy</h2>
                        <nav>
                            <ul class="nav masthead-nav">
                                <li><a href="/">Home</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="/signup">Signup</a></li>
                                <li><a href="/login">Login</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>

                <div class="inner cover">
                    <div class="text-center" style="padding:50px 0">
                        <h1 class="cover-heading">Sign up</h1>
                        <p class="lead">Want to join us?</p>
                        <p class="lead">Use the form below. Choose your username and password carefully!</p>
                            <div class="login-form-1">
                                <sf:form id="register-form" class="text-left" method="POST" commandName="user" action="/signup">
                                    <div class="login-form-main-message"></div>
                                    <div class="main-login-form">
                                        <div class="login-group">
                                            <div class="form-group">
                                                <label for="reg_username" class="sr-only">Email address</label>
                                                <sf:input type="text" class="form-control" id="reg_username" name="reg_username" path="username" placeholder="Enter username"></sf:input>
                                            </div>
                                            <div class="form-group">
                                                <label for="reg_password" class="sr-only">Password</label>
                                                <sf:input type="password" class="form-control" id="reg_password" name="reg_password" path="password" placeholder="Enter password"></sf:input>
                                            </div>
                                        </div>
                                        <button type="submit" class="login-button"><i class="glyphicon glyphicon-chevron-right"></i></button>
                                    </div>
                                    <div class="etc-login-form">
                                        <p><a href="#">I already have an account</a></p>
                                    </div>
                                </sf:form>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="main-container">

                </div>

            </div>
        </div>
</body>
</html>