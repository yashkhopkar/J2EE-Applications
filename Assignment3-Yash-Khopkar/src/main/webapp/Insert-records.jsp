<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Product Form</title>
</head>
<body>
	<h1>Insert Records Form</h1>
	<form method="post" action="View-Records.jsp">
		<label for="productNo">Product No:</label>
		<input type="text" id="productNo" name="productNo"><br><br>
		
		<label for="productName">Product Name:</label>
		<input type="text" id="productName" name="productName"><br><br>
		
		<label for="productType">Product Type:</label><br>
		<input type="radio" id="homeAppliance" name="productType" value="Home Appliance">
		<label for="homeAppliance">Home Appliance</label><br>
		<input type="radio" id="computerHardware" name="productType" value="Computer Hardware">
		<label for="computerHardware">Computer Hardware</label><br>
		<input type="radio" id="gameConsole" name="productType" value="Game Console">
		<label for="gameConsole">Game Console</label><br>
		<input type="radio" id="clothing" name="productType" value="Clothing">
		<label for="clothing">Clothing</label><br><br>
		
		<label for="manufacturer">Manufacturer:</label>
		<select id="manufacturer" name="manufacturer">
			<option value="LG">LG</option>
			<option value="Samsung">Samsung</option>
			<option value="Sony">Sony</option>
			<option value="Microsoft">Microsoft</option>
			<option value="Nintendo">Nintendo</option>
			<option value="Old Navy">Old Navy</option>
			<option value="H&M">H&amp;M</option>
			<option value="Zara">Zara</option>
		</select><br><br>
		
		<label for="price">Price:</label>
		<input type="text" id="price" name="price"><br><br>
		
		<label for="weight">Weight:</label>
		<input type="text" id="weight" name="weight"><br><br>
		
		<input type="submit" value="Add Product">
	</form>
</body>
</html>