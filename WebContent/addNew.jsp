<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Skyline Car Dealership</title>
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
<br>
<a href="profile.jsp">Go Back</a>
<h3>Please enter new car's info</h3>
<form action="AddNewVehicleServlet" method="post">
  <p><strong>New or Used:</strong></p>
  <div class="btn-group btn-group-toggle" data-toggle="buttons">
    <label class="btn btn-secondary">
      <input type="radio" name="isPreOwned" id="used" value="used">Pre-Owned
    </label>
    <label class="btn btn-secondary">
      <input type="radio" name="isPreOwned" id="new" value="new">New Car
    </label>
  </div>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="make">Make</label>
      <input type="text" class="form-control" id="make" placeholder="Make" name="make">
    </div>
    <div class="form-group col-md-6">
      <label for="model">Model</label>
      <input type="text" class="form-control" id="model" placeholder="Model" name="model">
    </div>
    <div class="form-group col-md-6">
      <label for="color">Color</label>
      <input type="text" class="form-control" id="color" placeholder="Color" name="color">
    </div>
    <div class="form-group col-md-6">
      <label for="year">Year</label>
      <input type="text" class="form-control" id="year" placeholder="Year" name="year">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
    <label for="vin">VIN</label>
    <input type="text" class="form-control" id="vin" placeholder="Vin Number" name="vin">
  <div class="form-group col-md-6">
      <label for="price">Price</label>
      <input type="text" class="form-control" id="price" placeholder="Price" name="price">
    </div>
  </div>
  <div class="form-group col-md-6">
    <label for="transmission">Transmission</label>
    <input type="text" class="form-control" id="transmission" placeholder="Transmission" name="transmission">
  </div>
     </div>
    <div class="form-row">
    <div class="form-group col-md-6">
    <label for="fuelType">Fuel Type</label>
    <input type="text" class="form-control" id="fuelType" placeholder="Fuel Type" name="fuelType">
  </div>
  <div class="form-group col-md-6">
      <label for="mileage">Mileage (if car is pre-owned). If new, put 0.</label>
      <input type="text" class="form-control" id="mileage" placeholder="Mileage" name="mileage">
    </div>
    <div class="form-group col-md-6">
      <label for="vehiclePicture">"Upload" the car picture</label>
      <input type="text" class="form-control" id="vehiclePicture" placeholder="pictureExample.jpg" name="vehiclePicture">
    </div>
  </div>
  <p>Date Purchased: <input type="text" id="datepicker" placeholder="MM/dd/yyyy" name="dateOfPurchase"></p>
  <button class="btn btn-primary" type="submit">Submit</button>
</form>

<jsp:include page="/Includes/footer.jspf"/>