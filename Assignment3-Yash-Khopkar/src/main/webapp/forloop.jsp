<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>For-Loop</title>
</head>
<body>
	<p> step 1: </p>
<%!int p=500; %>
<%=p %>
<p> step 2: </p>
	<c:set var="q" value="600" />
	<c:out value="${q}" />
	<c:out value="${p}" />
	<p>step 3:</p>
	<p>${p}${q}</p>
</body>
</html>