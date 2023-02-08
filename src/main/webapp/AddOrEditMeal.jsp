<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>

<h2>Edit Meals</h2>

<br>
<form method="post" action="${pageContext.request.contextPath}/MealServlet" name="formAddOrEditMeal">
DateTime: <input type="datetime-local" name="mealDatetime" value="<c:out value="${meal.dateTime}"/>"/>
<br><br>
Description:<input type="text" name="mealDescription" value="<c:out value="${meal.description}"/>"/>
<br><br>
Calories:<input type="number" name="mealCalories" value="<c:out value="${meal.calories}"/>" />
<br><br>
<input type="submit" value="Save">
</form>

</body>
</html>