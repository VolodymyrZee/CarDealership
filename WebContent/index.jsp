<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en-us">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
    
    <title>Skyline Car Dealership</title>
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
        			<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
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
    		<form class="form-inline my-2 my-lg-0" action="SearchServlet" method="get">
      			<input class="form-control mr-sm-2" type="text" placeholder="Search Cars by Model" aria-label="Search" name="search by Model">
      			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    		</form>
  		</div>
	</nav>

<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/picture2.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Welcome to Skyline Car Dealership</h5>
        <p>Wide variety of cars for every taste!</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="images/picture1.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>New and Used Cars</h5>
        <p>Domestic and Import</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="images/picture3.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Bid on Cars!</h5>
        <p>Any car that's been here for 120 or more days, up to 10% off! First come, first serve!</p>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>






<jsp:include page="/Includes/footer.jspf"/>