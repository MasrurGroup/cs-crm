package com.ikonsoft.utils.facebook;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikonsoft.mbeans.user.test.UserSearch;
import com.ikonsoft.model.User;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.types.FacebookType;

public class MainMenu {

	private static final long serialVersionUID = 1L;
	private String code="";
	 private User  user;

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {		
		code = req.getParameter("code");
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		FBConnection fbConnection = new FBConnection();
		String accessToken = fbConnection.getAccessToken(code);

		FBGraph fbGraph = new FBGraph(accessToken);
		String graph = fbGraph.getFBGraph();
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>EmailChannel Login using Java</h1>");
		out.println("<h2>Application Main Menu</h2>");
		out.println("<div>Welcome "+fbProfileData.get("first_name"));
		out.println("<div>Your Email: "+fbProfileData.get("email"));
		out.println("<div>You are "+fbProfileData.get("gender"));	
                out.println(" <div>You are "+accessToken);
                user.setUserToken(accessToken);
                try{
                    accessToken=accessToken.split("=")[1];
                         accessToken=accessToken.replace("&expires","");
                         
                    /*String postId= fbClient.publish("stream.publish", String.class,
                     Parameter.with("message", "RestFB test"));
               LegacyFacebookClient facebookClient = new DefaultLegacyFacebookClient(accessToken);*/
             System.setProperty("https.proxyHost", "PROXY");
            System.setProperty("https.proxyPort", "PORT");
            FacebookClient fbClient = new DefaultFacebookClient(accessToken);
            User user1 = fbClient.fetchObject("me/feed", User.class);
           
            
            //Making a post in EmailChannel
            //FacebookType publishMessageResponse =
            //fbClient.publish("me/feed", FacebookType.class,
            //Parameter.with("message", "Good Evening"));
           //client.
           //String loginDialogUrlString = client.getLoginDialogUrl(appId, redirectUrl, scopeBuilder);
                      
                   }
           catch(FacebookException e){
           out.println("exception:"+e);
           }
              
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
