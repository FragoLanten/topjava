<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table border="1" rules="all" cellpadding="5">
    <tr >
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>


    <c:forEach var="meal" items="${meals}">
        <c:if test="${meal.excess eq true}" >
        <tr style="color:red">
        </c:if>
        <c:if test="${meal.excess eq false}" >
            <tr style="color:green">
        </c:if>
            <td>${meal.dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"))}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>

            <td><a href="delete?id=<c:out value="${meal.mealId}"/>">Delete</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>