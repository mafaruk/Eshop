package com.mak.shop.serverusers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mak.shop.serverusers.entity.AdminUsers;
import com.mak.shop.serverusers.service.AdminRegisterService;


public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminRegisterService adminRegisterService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.append("Served at: ").append(request.getContextPath());
		adminRegisterService = new AdminRegisterService();
		HttpSession regiSession = request.getSession();
		try {
			String userName = request.getParameter("user_name");
			String passWord = request.getParameter("pass_word");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			//String userPic = request.getParameter("userpic");
			String privilages = request.getParameter("Privileges");
			String userPic = "default.pic";
			boolean isAlreadyExist = adminRegisterService.checkUserNameEmail(email);
			if(!isAlreadyExist) {
				
				AdminUsers adminUsers = new AdminUsers(userName, email, passWord, contact, userPic, privilages);
				int userID  = adminRegisterService.addUser(adminUsers);
				if(userID!=0) {
					regiSession.setAttribute("reg_user_name", userName);
					regiSession.setAttribute("reg_email", email);
					regiSession.setAttribute("reg_pass_word", passWord);
					response.sendRedirect("adminLogin.jsp");
				}
			}
			else {
				regiSession.setAttribute("temp_err", "Email Id  "+email+" is Already Exist in the system, please try loging in" );
				response.sendRedirect("adminRegister.jsp");
			}
			
		}
		catch (Exception e) {
			regiSession.setAttribute("temp_err", "Something went wrong, please try again" );	
			e.printStackTrace();
			response.sendRedirect("register.jsp");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
