<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
    <title>NoteBuddy - Create Group</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>Create a group</h1>
<sf:form method="POST" commandName="group" action="/creategroup ">
    <sf:input path="name" type="text" placeholder="Pick a name for your group!"/>
    <input type="submit" value="Submit" />
</sf:form>

</body>
<footer>Class HBV501G, University of Iceland, Fall 2016 - NoteBuddy</footer>
</html>