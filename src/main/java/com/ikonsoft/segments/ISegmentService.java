package com.ikonsoft.segments;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

public class ISegmentService {
	
	public static StringBuilder Qry = new StringBuilder("");
	static Session session;
	
	public static void main(String [] args)
	{
		addFilter("lastname","Ali");
		executeQry();
		
	}
	
	public static void addFilter(String Key, String value)
	{
		
		Qry=Qry.append(Key+" = "+value);
		
			
	}
	
	public static List<User> executeQry()
	
	{
		User user = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT  u FROM User u Where "+Qry;
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		System.out.print(hql + " Size: "+results.size());
		if (results.size() > 0)

			return results;
		else
			return null;
	}

}
