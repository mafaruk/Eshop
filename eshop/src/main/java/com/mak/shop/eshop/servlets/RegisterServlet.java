package com.mak.shop.eshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mak.shop.eshop.entity.Address;
import com.mak.shop.eshop.entity.UserDetails;
import com.mak.shop.eshop.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterService registerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
    	
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
		writer.append("Served at: ").append(request.getContextPath());
		registerService = new RegisterService();
		HttpSession regiSession = request.getSession();
		try {
			String userName = request.getParameter("user_name");
			String passWord = request.getParameter("pass_word");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			//String userPic = request.getParameter("userpic");
			String addLine1 = request.getParameter("line1");
			String area = request.getParameter("area");
			String city = request.getParameter("city");
			String district = request.getParameter("district");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			String userPic = "default.pic";
			
			boolean isAlreadyExist = registerService.checkUserNameEmail(email);
			if(!isAlreadyExist) {
				Address address = new Address(addLine1, zip, area, city, district, state);
				UserDetails userDetails = new UserDetails(userName, email, passWord, contact, userPic, address);
				int userID  = registerService.addUser(userDetails);
				if(userID!=0) {
					regiSession.setAttribute("reg_user_name", userName);
					regiSession.setAttribute("reg_email", email);
					regiSession.setAttribute("reg_pass_word", passWord);
					response.sendRedirect("login.jsp");
				}
			}
			else {
				regiSession.setAttribute("temp_err", "Email Id  "+email+" is Already Exist in the system, please try loging in" );
				response.sendRedirect("register.jsp");
			}
			
		}
		catch (Exception e) {
			regiSession.setAttribute("temp_err", "Something went wrong, please try again" );	
			e.printStackTrace();
			response.sendRedirect("register.jsp");
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
