<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>NoteBuddy - Login Successful</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <spring:url value="/resources/main.css" var="mainCSS" />
    <link href="${mainCSS}" rel="stylesheet" />
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
                    <h1 class="cover-heading">Login complete!</h1>
                    <p class="lead">Welcome ${loginInfo.username} !</p>
                    <p class="lead">Congratulations, your login was successful! You are now logged in as ${loginInfo.username}</p>
                    <p class="lead">
                        <a href="/" class="btn btn-lg btn-default">Back to homepage</a>
                    </p>
                </div>

            </div>

            <div class="main-container">

            </div>

        </div>

    </div>
</body>
</html>
