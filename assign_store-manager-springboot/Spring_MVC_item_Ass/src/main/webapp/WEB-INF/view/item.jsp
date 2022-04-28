<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	<h3>STORE MANAGER</h3>
		<div>
			<form action="addItem">
				<table>
				<tr>
					<td>Enter the name of Item</td>
					<td><input type="text" name="itmName"></td>
				</tr>
				<tr>
					<td>Enter the Price of Item</td>
					<td><input type="text" name="itmPrice"></td>
				</tr>
				<tr>
					<td>Enter the Quantity of Item</td>
					<td><input type="text" name="itmQuantity"></td>
				</tr>
				<tr>
					<td>Enter the Discount offered on Item</td>
					<td><input type="text" name="itmDiscount"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"></td>
				</tr>
			</table>
			</form>	
		</div>
	</body>
</html>