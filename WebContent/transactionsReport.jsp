<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="Objects.Transaction" %>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Skyline Car Dealership</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<a href="profile.jsp">Go Back</a>
<h1>Skyline Car Dealership Transactions Report</h1>
<div class="table-responsive">
  <table class="table">
    <thead>
      <tr>
        <td>Date of Transaction</td>
        <td>Vin Sold</td>
        <td>New/Used</td>
        <td>Selling Price</td>
        <td>Make</td>
        <td>Model</td>
        <td>Year</td>
        
        
      </tr>
    </thead>
    <c:forEach var="transaction" items="${transactions}">
    <% Transaction transaction = (Transaction) session.getAttribute("transaction"); %>
      <tr>
        <td>${transaction.transactionDate}</td>
        <td>${transaction.vinSold}</td>
       <!--  <td>
          <c:if test="${transaction.isPreOwned = true}">Used</c:if>
          <c:if test="${transaction.isPreOwned = false}">New</c:if>
        </td> --> 
        
        <td><strong>$</strong>${transaction.salePrice}</td>
        <td>${transaction.makeSold}</td>
        <td>${transaction.modelSold}</td>
        <td>${transaction.yearSold}</td>
        
      </tr>
    </c:forEach>
  </table>
</div>
<jsp:include page="/Includes/footer.jspf"/>