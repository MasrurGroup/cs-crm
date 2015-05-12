package com.ikonsoft.user.customer.services.impl;

import java.util.HashMap;
import java.util.List;

 

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;

import com.ikonsoft.model.User;
import com.ikonsoft.user.customer.services.ICustomerService;
import com.ikonsoft.utils.Constants;
import com.ikonsoft.utils.HibernateUtil;

public class CustomerServicesImpl implements ICustomerService {

	 
	@SuppressWarnings("null")
	public Map<String , Long> getNoOfCustomersWith(List<String> channels){
		
		if (channels==null) return null;
		 Map<String , Long> channelValues = new HashMap<String , Long>(); 
		 
		Query query;
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
	  		Iterator<String> i = channels.iterator();
	  	   String channel="" ;
	  		while (i.hasNext()){ 
	  		channel = i.next();		  		 
	  		if (Constants.CHANNELS.EMAGAZINE.toString().equals(channel)){
	  			query = session.createQuery("select count(*) from User user where user.authority=:customer");
	  			query.setString("customer", "CUSTOMER");
	  			channelValues.put(channel, (long) query.uniqueResult());
	  			System.out.println(channel+"="+ (long) query.uniqueResult());
	  			 	  			
	          	}
	  		if (Constants.CHANNELS.EMAIL.toString().equals(channel)){
	  		 query = session.createQuery(
	  				  "select count(*) from User user where user.authority=:customer and user.emailId is not null");
	  		query.setString("customer", "CUSTOMER");
	  		channelValues.put(channel, (long) query.uniqueResult());
	  		System.out.println(channel+"="+ (long) query.uniqueResult());
	  		}
	  	 
	  		if (Constants.CHANNELS.FACEBOOK.toString().equals(channel)){
	  			query = session.createQuery(
			  "select count(*) from User user where user.authority=:customer and user.facebook is not null");
	  			query.setString("customer", "CUSTOMER");
	  			channelValues.put(channel, (long) query.uniqueResult());
	  			System.out.println(channel+"="+ (long) query.uniqueResult());
			}
	  		
	  		if (Constants.CHANNELS.SMS.toString().equals(channel)){
	  			query = session.createQuery(
				"select count(*) from User user where user.authority=:customer and user.emailId is not null");
	  			query.setString("customer", "CUSTOMER");
	  			channelValues.put(channel, (long) query.uniqueResult());
	  			System.out.println(channel+"="+ (long) query.uniqueResult());
			}
	
	  		if (Constants.CHANNELS.WHATSAPP.toString().equals(channel)){
	  			query = session.createQuery(
               "select count(*) from User user where user.authority=:customer and user.whatsapp is not null");
	  			query.setString("customer", "CUSTOMER");
	  			channelValues.put(channel, (long) query.uniqueResult());
	  			System.out.println(channel+"="+ (long) query.uniqueResult());
			}// if 
	  		 		
	  		
	  		}// while
	  	  session.getTransaction().commit();
			return channelValues;	
	 
			}// method
	 
	@Override
	public long getNoOfCustomersWithFacebook() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
		  "select count(*) from User user where user.authority=:customer and user.facebook is not null");
			query.setString("customer", "CUSTOMER");
			Long count = (Long)query.uniqueResult();
			session.getTransaction().commit();
				return count;
	}

	@Override
	public long getNoOfCustomersWithWhatsApp() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
"select count(*) from User user where user.authority=:customer and user.whatsapp is not null");
			query.setString("customer", "CUSTOMER");
			Long count = (Long)query.uniqueResult();  session.getTransaction().commit();
				return count;
	}
	 
	 
	@Override
	public long getNoOfCustomersWithSMS() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
  "select count(*) from User user where user.authority=:customer and user.phone is not null");
			query.setString("customer", "CUSTOMER");
			Long count = (Long)query.uniqueResult();
			  session.getTransaction().commit();
				return count;
	}

	@Override
	public  long getNoOfCustomersWithEmail() {
		// select count user where user.email !=null and user.authority= CUSTOMER
	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
  	   session.beginTransaction();
		Query query = session.createQuery(
  "select count(*) from User user where user.authority=:customer and user.emailId is not null");
		query.setString("customer", "CUSTOMER");
		Long count = (Long)query.uniqueResult();
		  session.getTransaction().commit();
			return count;
	}

	@Override
	public List<User> getAllCustomersWithEmail() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
  "from User user where user.authority=:customer and user.emailId is not null");
			query.setString("customer", "CUSTOMER");
			 List <User>   results = query.list();
			  session.getTransaction().commit();
				return results;
	}


	@Override
	public List<User> getAllCustomersWithFacebook() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
		  "from User user where user.authority=:customer and user.facebook is not null");
			query.setString("customer", "CUSTOMER");
			 List <User>   results = query.list();
						return results;
	 
	}


	@Override
	public List<User> getAllCustomersWithSMS() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
		  "from User user where user.authority=:customer and user.phone is not null");
			query.setString("customer", "CUSTOMER");
			 List <User>   results = query.list();  session.getTransaction().commit();
						return results;
	}

	

	@Override
	public List<User> getAllCustomersWithWhatsApp() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery(
		  "from User user where user.authority=:customer and user.whatsapp is not null");
			query.setString("customer", "CUSTOMER");
			 List <User>   results = query.list();
			  session.getTransaction().commit();
						return results;
	}

}
