package com.ikonsoft.email;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import com.ikonsoft.utils.PropertiesCache;
import com.ikonsoft.utils.StringUtil;

 
public class SendHtmlEmailService {

	 public static void sendOfferEmail(String to, String cc,String bcc ,String subject, String body,String RequsterName) throws UnsupportedEncodingException  {
		 
		 String host="smtp.gmail.com";
		   final String user="ikonsoft.loyalty@gmail.com";//change accordingly
		   final String password="ikonsoftp@ssw0rd";//change accordingly
		   int port=465;
		   
		   //String to="mohamed.moftah@gmail.com";//change accordingly

		    //Get the session object
		    Properties props = new Properties();
		    props.put("mail.smtp.host",host);
		    props.put("mail.smtp.port",port);
		    props.put("mail.smtp.auth", "true");
		    
		    Session session = Session.getDefaultInstance(props,
		     new javax.mail.Authenticator() {
		       protected PasswordAuthentication getPasswordAuthentication() {
		 	return new PasswordAuthentication(user,password);
		       }
		     });

		    //Compose the message
		       try {
		      MimeMessage message = new MimeMessage(session);
		    if (StringUtil.isNull(RequsterName)) RequsterName="CityStars Admin";
		    
		      message.setFrom(new InternetAddress(user,RequsterName));
		      if (!to.equals("")) { 
		          Address[] toList = InternetAddress.parse(to); 
		          message.addRecipients(Message.RecipientType.TO,toList);
		                          }
		      if (!cc.equals("")) {
		          Address[] ccList = InternetAddress.parse(cc);
		          message.addRecipients(Message.RecipientType.CC, ccList);
		                           }
		       // Send multiple cc
		      if (!bcc.equals("")){
		          Address[] bccList = InternetAddress.parse(bcc);
		          message.addRecipients(Message.RecipientType.BCC, bccList);
		                          } 
		          
		          message.setSubject(subject);
		      //message.setText(body);
		      message.setContent(body,"text/html;charset=utf-8");
		     //send the message
		      Transport.send(message);
		       
		      System.out.println("Message sent successfully...");
		  
		      } catch (MessagingException e) {e.printStackTrace();}
   
	 }
	 
	 public static String sendGroupEmail(String to, String cc,String bcc ,String subject, String body) throws UnsupportedEncodingException  {
	 String host=PropertiesCache.getValue("email.host");//"smtp.ipage.com";
	   final String user=PropertiesCache.getValue("email");            //"info@perfect-technology.com";//change accordingly
	   final String password=PropertiesCache.getValue("password");// "Mariam2009!@#$%^";//change accordingly
	   int port=Integer.parseInt(PropertiesCache.getValue("port"));//587;
	   
	   //String to="mohamed.moftah@gmail.com";//change accordingly

	    //Get the session object
	    Properties props = new Properties();
	    props.put("mail.smtp.host",host);
	    props.put("mail.smtp.port",port);
	    props.put("mail.smtp.auth",PropertiesCache.getValue("mail.smtp.auth"));
	    
	    Session session = Session.getDefaultInstance(props,
	     new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {
	 	return new PasswordAuthentication(user,password);
	       }
	     });

	    //Compose the message
	       try {
	      MimeMessage message = new MimeMessage(session);
	    
	      message.setFrom(new InternetAddress(user , PropertiesCache.getValue("mail.sender.name")));
	      if (!to.equals("")) { 
	          Address[] toList = InternetAddress.parse(to); 
	          message.addRecipients(Message.RecipientType.TO,toList);
	                          }
	      if (!cc.equals("")) {
	          Address[] ccList = InternetAddress.parse(cc);
	          message.addRecipients(Message.RecipientType.CC, ccList);
	                           }
	      //}// Send multiple cc
	      if (!bcc.equals("")){
	          Address[] bccList = InternetAddress.parse(bcc);
	          message.addRecipients(Message.RecipientType.BCC, bccList);
	                          } 
	          
	          message.setSubject(subject);
	      //message.setText(body);
	      message.setContent(body,"text/html;charset=utf-8");
	     //send the message
	      Transport.send(message);
	       
	      System.out.println("Message sent successfully...");
	  
	      } catch (MessagingException e) {e.printStackTrace();}

	 return "new_mailing";
	 
	 }// method
	
	
	 
}
