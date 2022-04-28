 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit User</h1>  
       <form:form action="updateuser" modelAttribute="objuser">    
        <table >    
        <tr>  
        <td>Id</td>    
         <td><form:input path="uid" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td>Address :</td>    
          <td><form:input path="address" /></td>  
         </tr>   
           <tr>    
          <td>Mobile no :</td>    
          <td><form:input path="mobileno" /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    