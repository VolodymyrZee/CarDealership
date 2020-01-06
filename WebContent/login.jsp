<jsp:include page="/Includes/header.jspf"/>



<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                    <a class="navbar-brand" href="#"><h5>Skyline Car Dealership</h5></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Bid on Cars</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Employee login<span class="sr-only">(current)</span></a>
                            </li>
                            </ul>
                        <form class="form-inline mt-2 mt-md-0" method="GET" action="SearchServlet">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search by Make" aria-label="Search" />
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </nav>
                <br>
                <br>
                <br>
                <h1>${msg}</h1>
                <form action="LoginServlet" method="post">
                
                <div class="form-group">
    		<label for="username">Username</label>
    		<input type="text" class="form-control" id="username" name="username">
    		
  		</div>
  		<div class="form-group">
    		<label for="password">Password</label>
    		<input type="password" class="form-control" id="password" name="password">
  		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
                
                </form>
                
                
                
                
<jsp:include page="/Includes/footer.jspf"/>