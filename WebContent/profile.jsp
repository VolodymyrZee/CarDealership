<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>



	<h1>${msg}</h1>
	<a href="sellVehicle.jsp"
		class="btn btn-primary btn-lg btn-block active" type="button"
		role="button" aria-pressed="true">Sell a Car</a>
	<br>
	<form action="ShowTransactionsServlet" method="get">
		<button class="btn btn-primary btn-lg btn-block active" type="submit"
			role="button" aria-pressed="true">Show Transactions</button>
	</form>
	<br>
	<a href="addNew.jsp" class="btn btn-primary btn-lg btn-block active"
		type="button" role="button" aria-pressed="true">Add a Car to
		Inventory</a>
	<br>
	<a href="update.jsp" class="btn btn-primary btn-lg btn-block active"
		type="button" role="button" aria-pressed="true">Update Car in
		Inventory</a>
	<br>
	<a href="index.jsp" class="btn btn-primary btn-lg btn-block active"
		type="button" role="button" aria-pressed="true">Logout</a>



	<jsp:include page="/Includes/footer.jspf" />