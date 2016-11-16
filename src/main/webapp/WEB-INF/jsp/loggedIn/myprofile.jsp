<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>NoteBuddy - My Profile!</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<h1>Result</h1>

<div class="groups">
    <p>Is in groups:</p>
    <c:forEach items="${groups}" var="group">
        ${group.name}<br>
    </c:forEach>
</div>

</body>
<footer>Class HBV501G, University of Iceland, Fall 2016 - NoteBuddy</footer>
</html>
