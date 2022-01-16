package com.mak.shop.serverusers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mak.shop.serverusers.entity.AdminUsers;
import com.mak.shop.serverusers.service.AdminLoginService;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminLoginService adminLoginService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession loginSession = request.getSession();
		adminLoginService = new AdminLoginService();
//		writer.append("Served at: ").append(request.getContextPath());
		try {
			String email = request.getParameter("email");
			String passWord = request.getParameter("pass_word");
			boolean result = adminLoginService.authenticateUser(email, passWord);
			if (result) {
				AdminUsers tempUser = adminLoginService.getAdminUsers();
				loginSession.setAttribute("admin_log_email", email);
				loginSession.setAttribute("admin_log_pass_word", passWord);
				loginSession.setAttribute("admin_log_user_name", tempUser.getUserName());
				loginSession.setAttribute("admin_log_user_phone", tempUser.getUserPhone());
				loginSession.setAttribute("admin_log_user_pic", tempUser.getUserPic());
				loginSession.setAttribute("admin_log_user_priv", tempUser.getUserPrivilages());
				loginSession.setAttribute("temp_log_user_name", tempUser.getUserName());
				response.sendRedirect("adminIndex.jsp");

			} else {
				
				loginSession.setAttribute("login", "Failed");
				response.sendRedirect("adminLogin.jsp");
			}

		} catch (Exception e) {
			
			loginSession.setAttribute("login", "Failed");
			e.printStackTrace();
			response.sendRedirect("adminLogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
