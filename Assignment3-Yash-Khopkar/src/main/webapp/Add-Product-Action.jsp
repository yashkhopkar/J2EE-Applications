<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Product Action</title>
</head>
<body>
	<%
		String productNo = request.getParameter("productNo");
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");
		String manufacturer = request.getParameter("manufacturer");
		String price = request.getParameter("price");
		String weight = request.getParameter("weight");
	%>
	
	<h1>Product Added</h1>
	<p>The following information is received:</p>
	<ul>
		<li>Product No is <%= productNo %></li>
		<li>Product name is <%= productName %></li>
		<li>Product type is <%= productType %></li>
		<li>Manufacturer is <%= manufacturer %></li>
		<li>Price is <%= price %></li>
		<li>Weight is <%= weight %></li>
	</ul>
</body>
</html>