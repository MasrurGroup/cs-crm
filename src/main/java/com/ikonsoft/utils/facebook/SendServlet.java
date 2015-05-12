package com.ikonsoft.utils.facebook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;


public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		
		String[] checkedUsers = request.getParameterValues("checkedusers");
		String msg=request.getParameter("admin_message");
		
		if(checkedUsers != null)
		{
		
		if(! msg.equals(""))
		{
		for(int i=0; i<checkedUsers.length;i++ )
		{
			FacebookClient facebookClient = new DefaultFacebookClient(checkedUsers[i], "ed855a201a0d5d0a1133e50c4923799e",Version.VERSION_2_2);
			FacebookType publishMessageResponse =facebookClient.publish("me/feed", FacebookType.class,Parameter.with("message", msg));
		}
		
		
		 printWriter.print("<p style=\"color:blue\">Message posted successfully !</p>");
		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminControlPage.jsp"); 
		 requestDispatcher.include(request,response);
		 
		 
		} else {
			
			 printWriter.print("<p style=\"color:red\">ERROR : There is no message to be posted !</p>");
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminControlPage.jsp"); 
			 requestDispatcher.include(request,response);
			
		}
	} else {
		
		printWriter.print("<p style=\"color:red\">ERROR : No users selected !</p>");
		 RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminControlPage.jsp"); 
		 requestDispatcher.include(request,response);
	}
		
		printWriter.close();
	} // doGet end


}
