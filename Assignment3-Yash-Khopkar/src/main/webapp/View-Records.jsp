<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Records</title>
</head>
<body>

	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/A3" user="root" password="26101993" />
	<c:if test="${not empty param.productNo and not empty param.productName and not empty param.productType and not empty param.manufacturer and not empty param.price and not empty param.weight}">
  <c:set var="price" value="${param.price}" />
  <c:set var="priceDouble" value="${Double.parseDouble(price)}" />
  <c:choose>
	<c:when test="${priceDouble >= 100.00 and priceDouble <= 900.00}">
		<sql:update dataSource="${myDS}">
      INSERT INTO PRODUCT (productNo, productName, productType, manufacturer, price, weight)
      VALUES (?, ?, ?, ?, ?, ?)
      <sql:param value="${param.productNo}" />
      <sql:param value="${param.productName}" />
      <sql:param value="${param.productType}" />
      <sql:param value="${param.manufacturer}" />
      <sql:param value="${price}" />
      <sql:param value="${param.weight}" />
    </sql:update>
	</c:when>
	<c:otherwise>
		<h1>Price range must be between $100 and $900</h1>
	</c:otherwise>
	</c:choose>
  <%-- <c:if test="${priceDouble >= 100.00 and priceDouble <= 900.00}">
    <sql:update dataSource="${myDS}">
      INSERT INTO PRODUCT (productNo, productName, productType, manufacturer, price, weight)
      VALUES (?, ?, ?, ?, ?, ?)
      <sql:param value="${param.productNo}" />
      <sql:param value="${param.productName}" />
      <sql:param value="${param.productType}" />
      <sql:param value="${param.manufacturer}" />
      <sql:param value="${price}" />
      <sql:param value="${param.weight}" />
    </sql:update>
  </c:if> --%>
</c:if>

	<h1>Existing Records</h1>
	<table border="1">
		<tr>
			<th>Product No</th>
			<th>Product Name</th>
			<th>Product Type</th>
			<th>Manufacturer</th>
			<th>Price</th>
			<th>Weight</th>
		</tr>
		<sql:query dataSource="${myDS}" var="result">
			SELECT * FROM PRODUCT
		</sql:query>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.productNo}" /></td>
				<td><c:out value="${row.productName}" /></td>
				<td><c:out value="${row.productType}" /></td>
				<td><c:out value="${row.manufacturer}" /></td>
				<td><c:out value="${row.price}" /></td>
				<td><c:out value="${row.weight}" /></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>