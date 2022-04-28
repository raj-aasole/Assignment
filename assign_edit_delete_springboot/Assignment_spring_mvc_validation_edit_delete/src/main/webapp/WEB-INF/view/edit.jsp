<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.error { color:red;
background-color: cyan;
}
</style>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<form:form action="updateuser" modelAttribute="objuser">
<table border="1" align="center">
<c:forEach var="gty" items="${uli}">
<tr>
  <td>Id</td>
  <td><input type="text" value="${gty.uid}"/>
      <form:errors path="uid" cssClass="error"/>
  </td>
 </tr>
 <tr>
  <td>Name</td>
  <td><input type="text" value="${gty.name}"/>
      <form:errors path="name" cssClass="error"/>
  </td>
 </tr>
<tr>
  <td>Email</td>
  <td><input type="text" value="${gty.email}"/>
    <form:errors path="email" cssClass="error"/>
  </td>
 </tr>
 <tr>
  <td>Address</td>
  <td><input type="text" value="${gty.address}"/>
     <form:errors path="address" cssClass="error"/>
  </td>
 </tr>
 <tr>
  <td>mobileno</td>
  <td><input type="text" value="${gty.mobileno}"/>
     <form:errors path="mobileno" cssClass="error"/>
  </td>
 </tr>
  <tr>
  <td colspan="2"><input type="submit" value="update"/></td>
  </tr>
	</c:forEach>
</table>
</form:form>
</body>
</html>