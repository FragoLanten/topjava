<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>

<h2>Edit Meals</h2>

<br>
<form method="post" action="${pageContext.request.contextPath}/MealServlet" name="formAddOrEditMeal">
DateTime: <input type="datetime-local"/>
<br><br>
Description:<input type="text"/>
<br><br>
Calories:<input type="number"/>
<br><br>
<input type="submit" value="Save">
</form>

</body>
</html>