package com.ikonsoft.user.customer.services;
import java.util.List;
import java.util.Map;

import com.ikonsoft.model.User;

public interface ICustomerService {
	
	public Map<String , Long> getNoOfCustomersWith(List<String> channels);
	
	//get total no of customers with email 
	public long getNoOfCustomersWithEmail ();
		
	 
	//get List  of customers with email
	public List<User> getAllCustomersWithEmail ();
	
	//get total no of customers with facebook
	public long getNoOfCustomersWithFacebook ();

	//get List of customers with facebook
	
	public List<User> getAllCustomersWithFacebook ();
	
	//get total no of customers with SMS
	public long getNoOfCustomersWithSMS ();
	
	
	//get List of customers with SMS
	public List<User> getAllCustomersWithSMS();
	
	//get total no of customers with WhatsApp 
	public long getNoOfCustomersWithWhatsApp();
	
	//get List of customers with WhatsApp 
	public List<User> getAllCustomersWithWhatsApp(); 
	
 
}
