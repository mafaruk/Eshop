<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">Eshop</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a></li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> 
						<a class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">About US</a>
				</li>
			</ul>
			
			<ul class="navbar-nav mr-auto">
			<li class="nav-item active pl-2 ml-auto" >
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn  my-2 my-sm-0" type="submit">Search</button>
				</form>
			</li>
			<%
			HttpSession loginSession = request.getSession(false);
			String name = null;
			name = (String) loginSession.getAttribute("log_user_name");
			if (loginSession != null && name !=null ) {
			%>
				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <%= name%> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Log Out</a> 
						<a class="dropdown-item" href="#">Profile</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">My Orders</a>
					</div>
				</li>
				<li class="nav-item pl-2"><a class="nav-link " href="">Cart</a></li>
			<%
			} else {
				%>

				<li class="nav-item pl-2"><a class="nav-link " href="login.jsp">Login</a></li>

				<li class="nav-item  pl-2"><a class="nav-link" href="register.jsp">Sign Up</a></li>
				<%
			}
			%>
			
			
			</ul>
			
			<!--  -->
		</div>
	</div>
</nav>