package com.ikonsoft.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ikonsoft.model.Channel;
import com.ikonsoft.model.User;
import com.ikonsoft.user.customer.services.ICustomerService;
import com.ikonsoft.user.customer.services.impl.CustomerServicesImpl;
import com.ikonsoft.utils.Constants;
import com.ikonsoft.utils.HibernateUtil;

public class BudgetServiceImpl implements IBudgetService   {

	public static void main(String[] args) {
		//BudgetServiceImpl budgetService = new BudgetServiceImpl();
		List<String> channels =   new ArrayList<String>();
	//	System.out.println(Constants.CHANNELS.EMAIL.toString());System.out.println(Constants.CHANNELS.FACEBOOK.toString());
		channels.add(Constants.CHANNELS.EMAIL.toString());
		channels.add(Constants.CHANNELS.WHATSAPP.toString());
		channels.add(Constants.CHANNELS.FACEBOOK.toString());
		channels.add(Constants.CHANNELS.SMS.toString());
		CustomerServicesImpl cs=new CustomerServicesImpl();
		 BudgetServiceImpl budgetService = new BudgetServiceImpl();
		Map <String,Long> customerNos = cs.getNoOfCustomersWith(channels);
		Map <String,Long> valuePerChannel = budgetService.getChannelRates();
		System.out.println(budgetService.getBudget(channels , customerNos, valuePerChannel));
	}
	
	 	public   Map <String , Long > getChannelRates() {
		Channel channel=null;
		Map <String,Long> values = new HashMap<String, Long>();
	 
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  	   session.beginTransaction();
			Query query = session.createQuery("from Channel");
		
			 List <Channel>   results = query.list();
			  session.getTransaction().commit();
			  
			 Iterator<Channel> i = results.iterator();
			 while (i.hasNext()){
				 channel = i.next() ;
				 values.put(channel.getName(), channel.getValue());
				 System.out.println(channel.getName()+"\t"+ channel.getValue());
			 }// while
				 
		return values;
	
	}
	

 
	public   long getBudget(List<String> channels,Map <String,Long> customerNoPerChannel,Map <String,Long>valuePerChannel) {
		Iterator<String> i = channels.iterator();
		String channel ;
		long budget=0;
		while (i.hasNext()){
		 channel = i.next() ;
		System.out.println(channel);
		 
		budget +=customerNoPerChannel.get(channel)* valuePerChannel.get(channel);
			}// while
		 
		return  budget;
	}

	


}
