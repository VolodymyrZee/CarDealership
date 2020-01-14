<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Objects.Vehicle" %>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Skyline Car Dealership</title>
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
        			<a class="nav-link text-white" href="login.jsp">Employee Login</a>
      			</li>
    		</ul>
    		<form class="form-inline my-2 my-lg-0">
      			<input class="form-control mr-sm-2" type="search" placeholder="Search Cars" aria-label="Search">
      			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    		</form>
  		</div>
	</nav>
	<div class="text-center">
	<c:forEach var="vehicle" items="${vehicles}"> 
	<% Vehicle vehicle = (Vehicle) session.getAttribute("vehicle"); %>
	  <figure class="figure" style="padding-left:5px; padding-right:5px;">
        	<img src="${vehicle.vehiclePicture}" class="figure-img img-fluid rounded img-responsive" style="padding-top: 5px; width: 500px; height: 350px;" alt="vehicle">
        <figcaption class="figure-caption">
         
          
         <c:if test="${vehicle.isInAuction = true}"><h3 style="color: #B22222;">In Auction!</h3></c:if>
          <c:if test="${vehicle.isInAuction = false}"><h3>Check this Car!</h3></c:if>
         
          <c:if test="${vehicle.isPreOwned = true}"><h5>Used</h5></c:if>
          <c:if test="${vehicle.isPreOwned = false}"><h5>New</h5></c:if>
          
           
          
         
          <h6>${vehicle.make}</h6>
          <h6>${vehicle.model}</h6>
          <form action="GetVehicleInformation" method="get">
          	<button type="submit" class="btn btn-outline-dark" name="vin" value="${vehicle.vin}">Get More Info</button>
          </form>
        </figcaption>
       </figure>
	 </c:forEach>
	 </div>





<jsp:include page="/Includes/footer.jspf"/>