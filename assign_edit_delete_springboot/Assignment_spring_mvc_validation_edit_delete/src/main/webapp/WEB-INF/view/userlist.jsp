<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="2px">
 <tr>
   <td>Uid</td>
   <td>Name</td>
   <td>Email</td>
   <td>Address</td>
   <td>Mobile</td>
   <td>Action</td>
 </tr>
<c:forEach var="ul" items="${userlist}">
  <tr>
    <td>${ul.uid}</td>
    <td>${ul.name}</td>
    <td>${ul.email}</td>
    <td>${ul.address}</td>
    <td>${ul.mobileno}</td>
    <td><a href="edituser?id=${ul.uid}">Edit user</a> || <a href="deluser?id=${ul.uid}">Delete user</a></td>
  </tr>
</c:forEach>


</table>
</body>
</html>