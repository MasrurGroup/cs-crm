package com.ikonsoft.utils.facebook;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");  
    	PrintWriter printWriter = response.getWriter();
    	
    	String admin_uname=request.getParameter("adminusername");
    	String admin_pw=request.getParameter("adminpassword");
    	
    	 
    	 if(DAO.validateAdmin(admin_uname, admin_pw))
    	 {
    		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminControlPage.jsp");
    		 requestDispatcher.forward(request,response); 
    	 }
    	 else {
    		 printWriter.print("<p style=\"color:red\">Invalid username or password</p>");
    		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminLoginPage.jsp"); 
    		 requestDispatcher.include(request,response);
    	 }
    	 printWriter.close();
	}

}
