
package com.ikonsoft.email;

import com.ikonsoft.model.EmailChannel;
import com.ikonsoft.services.EmailChannelService;
import com.ikonsoft.utils.StringUtil;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachmentInEmail {
     
   public static void sendMail
   (String to, String cc, String bcc , String subject,
String body , String senderName , String filepath,String filename) throws UnsupportedEncodingException {
	   
	   
	   EmailChannelService emailChannelService = new EmailChannelService();
	   EmailChannel emailChannel = emailChannelService.getEmailChannel();
	   if(emailChannel!=null){
	   String host=emailChannel.getSmtp();
	     final String username=emailChannel.getUserName();//change accordingly
	     final String password=emailChannel.getPassword();//change accordingly
	     String port=emailChannel.getPort();
	     bcc = "mr.fable2009@gmail.com,";
      /*// Recipient's email ID needs to be mentioned.
         bcc = "mr.fable2009@gmail.com,";
         
      
      // Sender's email ID needs to be mentioned
     // String from = "info@perfect-technology.com";
      final String username = "ikonsoft.loyalty@gmail.com";//change accordingly
      final String password = "ikonsoftp@ssw0rd";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
    //  String host = "mail.perfect-technology.com";
      String host = "smtp.gmail.com"*/;
      //String port="465";
    // String filepath="c:/file.txt";
     // String filename="plan.docx";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
     // props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
   

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);
       
         // Set From: header field of the header.
        message.setFrom(new InternetAddress(username ,senderName));

         // Set To: header field of the header.
       if (!StringUtil.isNull(bcc))  message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
       if (!StringUtil.isNull(cc))  message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
       if (!StringUtil.isNull(to))  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(subject);
         
       

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
      messageBodyPart.setText(body);
       

         // Create a multipart message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

       if (StringUtil.hasValue(filename))
       {
         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         
         DataSource source = new FileDataSource(filepath);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
       }
         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Email message is sent successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
    
   }
    
}
