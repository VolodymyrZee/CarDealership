<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell A Car</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script>
$(function() {
	$("#datepicker").datepicker();
});
</script>
<style type="text/css">
	.ui-datepicker {
    background: #333;
    border: 1px solid #555;
    color: #EEE;
}
</style>
</head>
<body>
<a href="profile.jsp">Go Back</a>
<h2>${msg}</h2>
<h3>Enter Vehicle and Transaction Info</h3>
<form action="SellVehicleServlet" method="post">
	<p>Date of Transaction: <input type="text" id="datepicker" placeholder="MM/dd/yyyy" name="transactionDate"></p>
	<div class="form-row">
      <div class="form-group col-md-6">
        <label for="vin">Vin number</label>
        <input type="text" class="form-control" id="vin" placeholder="vin of sold vehicle" name="vin">
      </div>
      <div class="form-group col-md-6">
        <label for="salePrice">Sale Price</label>
        <input type="text" class="form-control" id="salePrice" placeholder="Sale Price" name="salePrice">
      </div>
    </div>
    <br>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="makeSold">Make</label>
        <input type="text" class="form-control" id="makeSold" placeholder="Make of sold vehicle" name="makeSold">
      </div>
      <div class="form-group col-md-6">
        <label for="modelSold">Model</label>
        <input type="text" class="form-control" id="modelSold" placeholder="Model of sold vehicle" name="modelSold">
      </div>
      <div class="form-group col-md-6">
        <label for="yearSold">Year</label>
        <input type="text" class="form-control" id="yearSold" placeholder="Year of sold vehicle" name="yearSold">
      </div>
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>




<jsp:include page="/Includes/footer.jspf"/>