package com.ikonsoft.utils.facebook;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;



public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
    	PrintWriter printWriter = response.getWriter();
    	
    		
    	    String access_Token=request.getParameter("accesstoken");
    		String first_Name=request.getParameter("firstname");
    		String last_Name=request.getParameter("lastname");
         	String phone_Number=request.getParameter("phonenumber");
    	
    	//---------
        	
        	AccessToken accessToken = new DefaultFacebookClient(Version.VERSION_2_2).obtainExtendedAccessToken("575654462536938",
				    "ed855a201a0d5d0a1133e50c4923799e", access_Token);

		String extendedAccessToken= accessToken.getAccessToken();
        	
        	//---------
    	
		// if()
		
    	 if(DAO.RegisterNewUser(first_Name,last_Name, phone_Number,extendedAccessToken))
    	 {

    		 printWriter.print("<p style=\"color:blue\">New user registered successfully</p>");
    		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserRegistrationPage.jsp"); 
    		 requestDispatcher.include(request,response);
    	 
    	 } else  {
    		 printWriter.print("<p style=\"color:red\">There is an error occurred while user registration , you entered invalid input(s)</p>");
    		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserRegistrationPage.jsp"); 
    		 requestDispatcher.include(request,response);
    	 }
	
    	
    	printWriter.close();
    	 
	}  // doPost() end

}

