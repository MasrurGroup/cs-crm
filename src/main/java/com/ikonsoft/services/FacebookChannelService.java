package com.ikonsoft.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;




import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.utils.HibernateUtil;

public class FacebookChannelService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int updateAppSecrit(FacebookChannel FacebookChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE FacebookChannel set AppSecrit = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", FacebookChannel.getAppSecrit());
	query.setParameter("id", FacebookChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateAppID(FacebookChannel FacebookChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE FacebookChannel set AppID = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", FacebookChannel.getAppID());
	query.setParameter("id", FacebookChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public List<FacebookChannel> getAll() {
		FacebookChannel facebook = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT o FROM FacebookChannel o";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

	
	
}
