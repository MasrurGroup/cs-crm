package com.ikonsoft.mbeans.user.customer;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TreeMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FlowEvent;

import com.ikonsoft.mbeans.user.test.ViewUtil;
import com.ikonsoft.model.Partner;
import com.ikonsoft.model.User;
import com.ikonsoft.services.PartnerService;
import com.ikonsoft.services.UserService;
import com.ikonsoft.services.email.SendAttachmentInEmail;
import com.ikonsoft.services.email.SendHtmlEmailService;
import com.ikonsoft.user.customer.services.impl.CustomerServicesImpl;
import com.ikonsoft.utils.Groups;
import com.ikonsoft.utils.PropertiesCache;
import com.ikonsoft.utils.facebook.FBConnection;
import com.ikonsoft.utils.facebook.FBGraph;
import com.jaspersoft.jasperserver.api.engine.common.domain.Request;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.exception.FacebookException;

@ManagedBean
@SessionScoped
public class CustomerWizard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();

	private boolean skip;

	public CustomerWizard() {
	}

	public  static Session session=null;
	public static final  String fromAddr="ikonsof.loyalty@gmail.com";
	public static final   String host = "smtp.gmail.com";
	public static final String password="ikonsoftp@ssw0rd";
	public static  MimeMessage message= null;
	String access_Token;
	private Map<String, Integer> countriesMap = ViewUtil.getCountriesMap();
	private Map<String, Integer> citiesMap = new TreeMap<String, Integer>();
	private Map<String, Integer> regionsMap = new TreeMap<String, Integer>();
	private Map<String, Integer>professionsMap = ViewUtil.getProfessionsMap();
	private Map<String, Integer>subProfessionsMap = new TreeMap<String, Integer>();
	private UserService userService = new UserService();
	
	public void fillCitiesMap() {
		citiesMap = ViewUtil.getCitiesMap(user.getCountryId());
	}
	public void fillSubProfessionsMap() {
		subProfessionsMap = ViewUtil.getSubProfessionMap(user.getProfessionId());
	}

	public void fillRegionsMap() {
		regionsMap = ViewUtil.getRegionsMap(user.getCityId());
	}

	public Map<String, Integer> getCountriesMap() {
		return countriesMap;
	}

	public void setCountriesMap(Map<String, Integer> countriesMap) {
		this.countriesMap = countriesMap;
	}

	public Map<String, Integer> getCitiesMap() {
		return citiesMap;
	}

	public void setCitiesMap(Map<String, Integer> citiesMap) {
		this.citiesMap = citiesMap;
	}

	public Map<String, Integer> getRegionsMap() {
		return regionsMap;
	}

	public void setRegionsMap(Map<String, Integer> regionsMap) {
		this.regionsMap = regionsMap;
	}

	public Map<String, Integer> getProfessionsMap() {
		return professionsMap;
	}

	public void setProfessionsMap(Map<String, Integer> professionsMap) {
		this.professionsMap = professionsMap;
	}

	public Map<String, Integer> getSubProfessionsMap() {
		return subProfessionsMap;
	}

	public void setSubProfessionsMap(Map<String, Integer> subProfessionsMap) {
		this.subProfessionsMap = subProfessionsMap;
	}

	
		public void EmailAlerts(String to, String cc,String bcc ,String subject, String body) {
			

		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class",
		            "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");

		     session = Session.getDefaultInstance(props,
		        new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(fromAddr,password);
		            }
		        });
		     
		     try {
			      MimeMessage message = new MimeMessage(session);
			    
			      message.setFrom(new InternetAddress());
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

		}
	public void openURL()
	{
		
		try {
		 FacesContext context = FacesContext.getCurrentInstance();
			 //context.getExternalContext().redirect("https://www.facebook.com/dialog/oauth?client_id=999958190016636&redirect_uri=http://localhost:8080/cs-crm/faces/Register.xhtml&scope=publish_actions&response_type=token");
		 context.getExternalContext().redirect("https://www.facebook.com/dialog/oauth?client_id=999958190016636&redirect_uri=http://localhost:8080/cs-crm/faces/CustomerRegisteration.xhtml&scope=publish_actions&response_type=token");
			  Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
			  access_Token= paramMap.get("access_token");
				
	
				//System.out.println("Access Token; "+access_Token);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}  
	}
	public String save() {
		/*FacesContext context = FacesContext.getCurrentInstance();
		  Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		  access_Token= paramMap.get("access_token");*/
		  
		  HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		  request.getParameter("access_token");
			

			System.out.println("Access Token; "+access_Token);
		
		FacesMessage msg = new FacesMessage("Please Wait checking our records and send mail", "Welcome ");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		UserService userService = new UserService();
		user.setAuthority(Groups.CUSTOMER);
		
		
		
	//	AccessToken accessToken = new DefaultFacebookClient(Version.VERSION_2_2).obtainExtendedAccessToken("575654462536938","ed855a201a0d5d0a1133e50c4923799e", access_Token);
		System.out.println("Access Token; "+access_Token);
//	String extendedAccessToken= accessToken.getAccessToken();

		
	
        FBConnection fbConnection = new FBConnection();
      fbConnection.getFBAuthUrl();
        
    	/* String code="";
   	
    	code = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("code");
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		
		String accessToken = fbConnection.getAccessToken(code);

		FBGraph fbGraph = new FBGraph(accessToken);
		String graph = fbGraph.getFBGraph();
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		
               
                try{
                    accessToken=accessToken.split("=")[1];
                         accessToken=accessToken.replace("&expires","");
                         user.setUserToken(accessToken);
                         System.out.println("Access Token; "+access_Token);
                    String postId= fbClient.publish("stream.publish", String.class,
                     Parameter.with("message", "RestFB test"));
               LegacyFacebookClient facebookClient = new DefaultLegacyFacebookClient(accessToken);
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
        
           }
        */
      int var=getVoucherNumber();
	    
	    user.setVoucherNumber(var);

        userService.createUser(user);
       
		FacesMessage msgss = new FacesMessage("Successful", "Welcome :"
				+ getUser().getFirstName());
		System.out.println("New Customer Registered :"+user.getEmailId());
		try {
			//SendAttachmentInEmail.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "Registration Successful", "<h2>Thank you for registration as a partner for CityStars </h2>");
			SendHtmlEmailService.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "Regitration Confirmation Successful", "<h2>Thank you for you REGISTRATION, thank you MR : "+user.getFirstName()+" "+user.getLastName()+" , <br/>email address is "
					+ " : "+user.getEmailId()+"  Password Is: "+ user.getPassword());
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} 
		
		return "RegDone";
	}
	public int getVoucherNumber()
	{
		
		int var;
		int min = 10000;
		int max = 100000000;
		int rndNumber;
		
		rndNumber = (int) (Math.random() * (max - min)) + min;
		var=rndNumber;
		
		System.out.println("Number: " + rndNumber);
		if(userService.getUserVoucherNumber(rndNumber)==null)
		{
		return var;
		}else{
		return getVoucherNumber();
		}
		
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public void setSurvey(String location, String profession)
	{
		user.setProfession(profession);
		user.setCity(location);
		user.setAuthority(Groups.CUSTOMER);
	}
	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}