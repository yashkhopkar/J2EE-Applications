<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Records</title>
</head>
<body>
    <h1>Delete Records</h1>
    <form action="Delete-Records.jsp" method="post">
        <label for="productNo">Enter Product No:</label>
        <input type="text" id="productNo" name="productNo" required>
        <input type="submit" value="Delete the Product">
    </form>
    
    <hr>
    
    <h2>Remaining Records</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Product No</th>
                <th>Product Name</th>
                <th>Product Type</th>
                <th>Manufacturer</th>
                <th>Price</th>
                <th>Weight</th>
            </tr>
        </thead>
        <tbody>
        <sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/A3" user="root" password="26101993" />
            <c:set var="deleted" value="false" />
            <c:if test="${not empty param.productNo}">
                <sql:update dataSource="${myDS}">
                    DELETE FROM PRODUCT WHERE productNo=?
                    <sql:param value="${param.productNo}" />
                </sql:update>
                <c:set var="deleted" value="true" />
            </c:if>
            <sql:query var="productList" dataSource="${myDS}">
                SELECT * FROM PRODUCT
            </sql:query>
            <c:forEach var="product" items="${productList.rows}">
                <c:if test="${not deleted or product.productNo ne param.productNo}">
                    <tr>
                        <td><c:out value="${product.productNo}" /></td>
                        <td><c:out value="${product.productName}" /></td>
                        <td><c:out value="${product.productType}" /></td>
                        <td><c:out value="${product.manufacturer}" /></td>
                        <td><c:out value="${product.price}" /></td>
                        <td><c:out value="${product.weight}" /></td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
