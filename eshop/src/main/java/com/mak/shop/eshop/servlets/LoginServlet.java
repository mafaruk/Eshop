package com.mak.shop.eshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mak.shop.eshop.entity.UserDetails;
import com.mak.shop.eshop.service.LoginService;
import com.mak.shop.serverusers.entity.AdminUsers;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService loginService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession loginSession = request.getSession();
		loginService = new LoginService();
//		writer.append("Served at: ").append(request.getContextPath());
		try {
			String email = request.getParameter("email");
			String passWord = request.getParameter("pass_word");
			boolean result = loginService.authenticateUser(email, passWord);
			if (result) {
				
				UserDetails tempUser = loginService.getUserDetails();
				loginSession.setAttribute("log_email", email);
				loginSession.setAttribute("log_pass_word", passWord);
				loginSession.setAttribute("log_user_name", tempUser.getUserName());
				loginSession.setAttribute("log_user_phone", tempUser.getUserPhone());
				loginSession.setAttribute("log_user_pic", tempUser.getUserPic());
				loginSession.setAttribute("log_user_address", tempUser.getUserAddressID());
				loginSession.setAttribute("temp_log_user_name", tempUser.getUserName());
				
				response.sendRedirect("index.jsp");

			} else {
				
				loginSession.setAttribute("login", "Failed");
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			
			loginSession.setAttribute("login", "Failed");
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
