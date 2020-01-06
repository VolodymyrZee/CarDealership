<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vehicle in Inventory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<a href="profile.jsp">Go back</a>
<h3>Please enter the information you'd like to update:</h3>
<form action="UpdateServlet" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="vin">Make to Update</label>
      <input type="text" class="form-control" id="make" placeholder="make" name="make">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Model to Update</label>
      <input type="text" class="form-control" id="model" placeholder="model" name="model">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Color to Update</label>
      <input type="text" class="form-control" id="color" placeholder="color" name="color">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Year to Update</label>
      <input type="text" class="form-control" id="year" placeholder="year" name="year">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">VIN to Update</label>
      <input type="text" class="form-control" id="vin" placeholder="vin" name="vin">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Transmission type to Update</label>
      <input type="text" class="form-control" id="transmission" placeholder="transmission" name="transmission">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Fuel type to Update</label>
      <input type="text" class="form-control" id="fuelType" placeholder="fuelType" name="fuelType">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Price to Update</label>
      <input type="text" class="form-control" id="price" placeholder="price" name="price">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Date of purchase to Update</label>
      <input type="text" class="form-control" id="dateOfPurchase" placeholder="dateOfPurchase" name="dateOfPurchase">
    </div>
    <div class="form-group col-md-6">
      <label for="vin">Mileage to Update</label>
      <input type="text" class="form-control" id="mileage" placeholder="mileage" name="mileage">
    </div>
        <div class="form-group col-md-6">
      <label for="newVehiclePicture">New Picture</label>
      <input type="text" class="form-control" id="newVehiclePicture" placeholder="newVehiclePicture" name="newVehiclePicture">
    </div>
   </div>
   <button class="btn btn-primary" type="submit">Submit</button>
</form>

<jsp:include page="/Includes/footer.jspf"/>