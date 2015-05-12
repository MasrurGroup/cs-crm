package com.ikonsoft.utils;

import java.io.UnsupportedEncodingException;

import javax.faces.bean.ManagedBean;

import com.ikonsoft.model.Partner;
import com.ikonsoft.model.User;
import com.ikonsoft.services.PartnerService;
import com.ikonsoft.services.UserService;
import com.ikonsoft.services.email.SendHtmlEmailService;


@ManagedBean
public class ForgetPassword {
	
	private String Email;
	private String authority;
	
	public String getPassword()
	{
		System.out.println(Email);
		sendPassword();
		return "";
	}


	
	public void sendPassword()
	{
		
		if(authority.equals("PARTNER"))
		{
		try{
		getPartner();
		}catch(Exception Ed)
		{
			JSFUtil.addErrorMsg("Invalid Account !");
		}
		}
		else
		{
			try{
			getUser();
			}catch(Exception Ed)
			{
				JSFUtil.addErrorMsg("Invalid Account !");
			}
		}
	}
	
	public void getUser()
	{
		User user=new User();
		UserService userservice=new UserService();
		user=userservice.getUserByEmailId(Email);
		try {
			//SendAttachmentInEmail.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "Registration Successful", "<h2>Thank you for registration as a partner for CityStars </h2>");
			SendHtmlEmailService.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "recive password Successful", "<h2>Thank you for you request, Password for : "+user.getFirstName()+" "+user.getLastName()+" , email address is "
					+ " : "+user.getEmailId()+"  Password Is: "+ user.getPassword());
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} 
		
		System.out.println(user.toString());
		JSFUtil.addErrorMsg("Data Sent please Check your Email !");
	}
	
	public void getPartner()
	{
		Partner partner=new Partner();
		PartnerService partnerservice=new PartnerService();
		partner=partnerservice.getPartnerByEmailId(Email);
		try {
			//SendAttachmentInEmail.sendGroupEmail(user.getEmailId(), "", PropertiesCache.getValue("adminEmail"), "Registration Successful", "<h2>Thank you for registration as a partner for CityStars </h2>");
			SendHtmlEmailService.sendGroupEmail(partner.getCompanyEmail(), "", PropertiesCache.getValue("adminEmail"), "recive password Successful", "<h2>Thank you for you request, Password for : "+partner.getCompanyName()+"  , email address is "
					+ " : "+partner.getCompanyEmail()+"  Password Is: "+ partner.getPassword());
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} 
		
		System.out.println(partner.toString());
		JSFUtil.addErrorMsg("Data Sent please Check your Email !");
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
