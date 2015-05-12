package com.ikonsoft.services.email;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class SendHtmlwithAttachment {

	
	// File Name SendFileEmail.java

	
	   public static void main(String [] args)
	   {
	      
		   // Recipient's email ID needs to be mentioned.
		      String to = "mr.fable2009@gmail.com";

		      // Sender's email ID needs to be mentioned
		      String from = "ikonsoft.loyalty@gmail.com";

		      // Assuming you are sending email from localhost
		      String host = "smtp.gmail.com";
	      String port="465";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	     properties.setProperty ("mail.smtp.port", port);
	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setText("This is message body");
	         
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	        /* // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "file.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
*/
	         // Send the complete message parts
	         message.setContent(multipart );

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	}