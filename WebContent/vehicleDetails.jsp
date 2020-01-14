<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="Objects.Vehicle" %>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Vehicle Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<form action="ShowAllVehiclesServlet" method="get">
			<button type="submit" class="btn btn-primary btn-lg">Skyline Car Dealership</button>
		</form>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarSupportedContent">
    		<ul class="navbar-nav mr-auto">
      			<li class="nav-item active">
        			<a class="nav-link" href="index.jsp">Home</a>
      			</li>
      			<li class="nav-item">
        			<form action="AuctionServlet" method="get">
        				<button type="submit" class="btn btn-link">Bid on Cars</button>
        			</form>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link text-white" href="login.jsp">Employee login</a>
      			</li>
    		</ul>
    		<form class="form-inline my-2 my-lg-0">
      			<input class="form-control mr-sm-2" type="search" placeholder="Search Cars" aria-label="Search">
      			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    		</form>
  		</div>
	</nav>
	<div style="margin-bottom: 25px;">
	
	<% Vehicle vehicle = (Vehicle) session.getAttribute("vehicle"); %>
	<img src="${vehicle.vehiclePicture}" alt="picture" style="width: 750px; height:640px; padding-top: 3px; ">
	<div style="float: right; font-size: 2em; padding-right:75px">
		<h1>Information</h1>
		<table class="table table-bordered">
			<tr class="bg-primary">
				<td><strong>Make</strong></td>
				<td>${vehicle.make}</td>
			</tr>
			<tr class="bg-success">
				<td><strong>Model</strong></td>
				<td>${vehicle.model}</td>
			</tr>
			
			<tr class="bg-primary">
				<td><strong>Color</strong></td>
				<td>${vehicle.color}</td>
			</tr>
			<tr class="bg-success">
				<td><strong>Year</strong></td>
				<td>${vehicle.year}</td>
			</tr>
			
			<tr class="bg-primary">
				<td><strong>Price</strong></td>
				<td><strong>$</strong>${vehicle.price}</td>
			</tr>
			<tr class="bg-success">
				<td><strong>Transmission</strong></td>
				<td>${vehicle.transmission}</td>
			</tr>
			<tr class="bg-success">
				<td><strong>Fuel Type</strong></td>
				<td>${vehicle.fuelType}</td>
			</tr>
			<tr class="bg-primary">
				<td><strong>Mileage</strong></td>
				<td>${vehicle.mileage}</td>
			</tr>
		</table>
		<c:if test="${vehicle.isPreOwned = true}"><h1>Used</h1></c:if>
    	
    	<c:if test="${vehicle.isPreOwned = false}"><h1>New</h1></c:if>
    	<c:if test="${vehicle.isInAuction = true}"><h3>In Auction!</h3></c:if>
	</div>

	</div>
	
	


<jsp:include page="/Includes/footer.jspf"/>