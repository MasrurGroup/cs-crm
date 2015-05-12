package com.ikonsoft.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;




import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.model.WhatsAppChannel;
import com.ikonsoft.utils.HibernateUtil;

public class WhatsAppChannelService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int updatePhoneNumber(WhatsAppChannel WhatsAppChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE WhatsAppChannel set PhoneNumber = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", WhatsAppChannel.getPhoneNumber());
	query.setParameter("id", WhatsAppChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updatePassword(WhatsAppChannel WhatsAppChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE WhatsAppChannel set Password = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", WhatsAppChannel.getPassword());
	query.setParameter("id", WhatsAppChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public List<WhatsAppChannel> getAll() {
		WhatsAppChannel whatsApp = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT o FROM WhatsAppChannel o";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

	
	
}
