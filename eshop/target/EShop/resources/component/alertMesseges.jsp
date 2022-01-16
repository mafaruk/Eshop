<% 

	String logUserName = (String)session.getAttribute("temp_log_user_name");
	if(logUserName !=null){
		%>
		<div class="alert alert-success alert-dismissible fade show" role="alert">
			<strong> Welcome <%=logUserName%></strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
			</button>
	</div>
	<%
	session.removeAttribute("temp_log_user_name");
	}
	
	String errorMessege = (String)session.getAttribute("temp_err");
	if(errorMessege != null){
		
		%>
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  				<strong><%=errorMessege%></strong>
	  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    				<span aria-hidden="true">&times;</span>
	  				</button>
				</div>
				
		<%	
		session.removeAttribute("temp_err");
		}

%>