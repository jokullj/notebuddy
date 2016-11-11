<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
    <title>NoteBuddy - Login</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>Login Form</h1>
<sf:form method="POST" commandName="loginInfo" action="/login">
    <sf:input path="username" type="text" placeholder="Enter username"/>
    <sf:input path="password" type="text" placeholder="Enter password"/>
    <input type="submit" value="Submit" />
</sf:form>

</body>
<footer>Class HBV501G, University of Iceland, Fall 2016 - NoteBuddy</footer>
</html>