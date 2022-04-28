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
<form:form action="SignUpSubmit" modelAttribute="objuser">
<table border="1" align="center">
 <tr>
  <td>Name</td>
  <td><form:input path="name"/>
      <form:errors path="name" cssClass="error"/>
  </td>
 </tr>
<tr>
  <td>Email</td>
  <td><form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
  </td>
 </tr>
 <tr>
  <td>(*) Password</td>
  <td><form:password path="pass"/>
   <form:errors path="pass" cssClass="error"/>
  </td>
 </tr>
 <tr>
  <td>Address</td>
  <td><form:textarea path="address"/>
     <form:errors path="address" cssClass="error"/>
  </td>
 </tr>
 <tr>
  <td>mobileno</td>
  <td><form:input path="mobileno"/>
     <form:errors path="mobileno" cssClass="error"/>
  </td>
 </tr>
  <tr>
  
  <td colspan="2"><input type="submit" value="signup"/></td>
 </tr>
</table>
</form:form>
</body>
</html>