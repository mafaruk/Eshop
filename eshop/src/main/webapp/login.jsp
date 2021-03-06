<%@page import="com.mak.shop.eshop.service.LoginService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%
		
	
	%>
	
	
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">

		<title>EShop Login</title>
		<%@include file="resources/component/common_css_js.jsp" %>
	</head>

	<body>
	
		<%@include file="resources/component/navbar.jsp" %>
	<%
	String loginFailed = (String)session.getAttribute("login");
	if ((loginFailed!=null) &&  (loginFailed.equals("Failed"))) {
	%>
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		Sorry, Incorrect Username or Password. try Again!
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<%
	session.removeAttribute("login");
	}
	%>
	<div class="container-fluid">
				<div class="row my-3">
					<div class="col-md-6 offset-md-3">
						<div class="card px-2">
							<div class="card-body">
								<h5 class="card-title text-center">Login here!</h5>
								<form action="LoginServlet" method="post">
									<div class="form-group">
										<label for="email">Email</label>
										<input type="email" class="form-control" id="email" name="email" placeholder="Enter Email"
											pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title=""  required>
									</div>
									<div class="form-group">
										<label for="pass">Password</label>
										<input type="password" class="form-control" id="pass"
											placeholder="Enter Password" name="pass_word" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
									</div>

									<div class="form-group">
										<a href="#">Forget Password/Username</a>
									</div>

									<div class="container text-center my-2">
										<button type="submit" class="btn">Submit</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			
	</body>

	</html>