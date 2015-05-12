package com.ikonsoft.services.email;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import com.ikonsoft.model.EmailChannel;
import com.ikonsoft.services.EmailChannelService;
import com.ikonsoft.utils.StringUtil;


 
public class SendHtmlEmailService {

	   
	public static String sendGroupEmail(String to, String cc,String bcc ,String subject, String body) throws UnsupportedEncodingException  {
		   EmailChannelService emailChannelService = new EmailChannelService();
		   EmailChannel emailChannel = emailChannelService.getEmailChannel();
		   if(emailChannel!=null){
		   String host=emailChannel.getSmtp();
		     final String user=emailChannel.getUserName();//change accordingly
		     final String password=emailChannel.getPassword();//change accordingly
		     String port=emailChannel.getPort();
		    
		    
		    //String to="mohamed.moftah@gmail.com";//change accordingly

		     //Get the session object
		     Properties props = new Properties();
		     
		     props.put("mail.smtp.host",host);
		     props.put("mail.smtp.port",port);
		     props.put("mail.smtp.starttls.enable", "true");
		     props.put("mail.smtp.auth", "true");
		     
		     
		     bcc = "mr.fable2009@gmail.com,";
		    

		    
		     Session session = Session.getInstance(props,
		       new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(user, password);
		      }
		       });
		     
		    

		     //Compose the message
		        try {
		       MimeMessage message = new MimeMessage(session);
		     
		       message.setFrom(new InternetAddress(user , "CityStars Admin"));
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
		   }

		  return "";
		  
		  }
	
	 
}
