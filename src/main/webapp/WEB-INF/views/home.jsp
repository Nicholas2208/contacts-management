<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager Home</title>
</head>
<body>
   <div align="center">
      <h1>Contact List</h1>
      
      <h3><a href="${pageContext.request.contextPath}/newContact">New Contact</a></h3>
      
      <table border="1">
         <thead>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Address</th>
              <th>Telephone</th>
              <th>Action</th>
          </thead>
          
          <c:forEach var="contact" items="${listContacts}">
             <tr>
                 <td>${contact.id}</td>
                 <td>${contact.name}</td>
                 <td>${contact.email}</td>
                 <td>${contact.address}</td>
                 <td>${contact.telephone}</td>
                 <td>
                     <a href="${pageContext.request.contextPath}/editContact?id=${contact.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="${pageContext.request.contextPath}/deleteContact?id=${contact.id}">Delete</a>
                 </td>
             </tr>
          </c:forEach>
      </table>
      
   </div>

</body>
</html>