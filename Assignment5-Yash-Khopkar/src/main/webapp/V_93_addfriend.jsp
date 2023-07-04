<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Friend</title>
</head>
<body>
    <h1>Add a New Friend</h1>
    <form method="post" action="C_93_AddFriend">
        <label>Name:</label>
        <input type="text" name="name"><br><br>
        <label>Email:</label>
        <input type="email" name="email"><br><br>
        <label>Age:</label>
        <input type="text" name="age"><br><br>
        <label>Favorite Color:</label>
        <input type="text" name="color"><br><br>
        <input type="submit" value="Add Friend">
    </form>
</body>
</html>
