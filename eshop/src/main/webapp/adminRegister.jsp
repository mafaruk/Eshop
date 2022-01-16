<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Eshop Admin Register</title>

<%@include file="resources/component/common_css_js.jsp"%>
<script type="text/javascript" src="resources\js\register.js"></script>
</head>

<body>
	<%@include file="resources/component/navbar.jsp"%>
	<%@include file="resources/component/alertMesseges.jsp"%>
	<div class="container-fluid">
		<div class="row my-3">
			<div class="col-md-6 offset-md-3">
				<div class="card px-2">
					<div class="card-body">
						<h5 class="card-title text-center">Admin Sign Up!</h5>
						<form name="regform" action="AdminRegisterServlet"
							onsubmit="return validateForm()" method="post">
							<div class="form-group">
								<label for="name">User Name</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<label for="name" class="input-group-text"
											id="inputGroupPrepend">@</label>
									</div>
									<input type="text" class="form-control" id="name"
										placeholder="Enter Username" onchange="validateUserName()"
										name="user_name" required>

								</div>
							</div>
							<div class="form-group">
								<label for="email">Email</label> <input type="email"
									class="form-control" id="email" name="email"
									placeholder="Enter Email"
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title=""
									required>
							</div>
							<div class="form-group">
								<label for="pass">Password</label> <input type="password"
									class="form-control" id="pass" name="pass_word"
									placeholder="Enter Password"
									pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
									title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
									required>
							</div>
							<div class="form-group">
								<label for="cpass">Confirm Password</label> <input
									type="password" class="form-control" id="cpass"
									placeholder="Re-Enter Password"
									pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
									title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
									onchange="confirmPassword()" required>
							</div>
							<div class="form-group">
								<label for="contact">Contact Number</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<label for="name" class="input-group-text"
											id="inputGroupPrepend">+91</label>
									</div>
									<input type="tel" class="form-control" id="contact"
										name="contact" pattern="([0-9]).{9}"
										title="please enter number only" size="10"
										placeholder="Enter Contact Number" required>
								</div>
							</div>

							<div class="card">
								<div class="card-body">
									<h5 class="card-subtitle mb-2 text-muted">Privileges</h5>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="exampleRadios" id="exampleRadios1" value="All"
											> <label class="form-check-label"
											for="exampleRadios1">All</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="exampleRadios" id="exampleRadios2" value="Read" checked>
										<label class="form-check-label" for="exampleRadios2">Read-Only</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="exampleRadios" id="exampleRadios3" value="Write"> <label class="form-check-label"
											for="exampleRadios3">Write-Only</label>
									</div>
								</div>

							</div>
							<div class="container text-center my-2">
								<button type="submit" class="btn">Submit</button>
								<button type="reset" class="btn">Reset</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>