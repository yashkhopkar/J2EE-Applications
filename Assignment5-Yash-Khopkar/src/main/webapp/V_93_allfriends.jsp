<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Friends</title>
</head>
<body>
    <h1>Friends List</h1>
    <c:choose>
        <c:when test="${empty friends}">
            <p>No friends available.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Age</th>
                        <th>Color</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="friend" items="${friends}">
                        <tr>
                            <td>${friend.id}</td>
                            <td>${friend.name}</td>
                            <td>${friend.email}</td>
                            <td>${friend.age}</td>
                            <td>${friend.color}</td>
                            <td><a href="C_93_DeleteFriend?id=${friend.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <hr>
    <p><a href="V_93_addfriend.jsp">Add a Friend</a></p>
</body>
</html> 