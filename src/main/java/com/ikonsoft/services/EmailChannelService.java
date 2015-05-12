package com.ikonsoft.services;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;





import org.hibernate.criterion.Restrictions;

import com.ikonsoft.model.EmailChannel;
import com.ikonsoft.model.FacebookChannel;
import com.ikonsoft.utils.HibernateUtil;

public class EmailChannelService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int updateSMTP(EmailChannel emailChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE EmailChannel set MSTP = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", emailChannel.getSmtp());
	query.setParameter("id", emailChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateUserName(EmailChannel emailChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE EmailChannel set userName = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", emailChannel.getUserName());
	query.setParameter("id", emailChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updatePassword(EmailChannel emailChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE EmailChannel set password = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", emailChannel.getPassword());
	query.setParameter("id", emailChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public EmailChannel getEmailChannel(){
		  EmailChannel emailChannel = null;
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		  session = HibernateUtil.getSessionFactory().getCurrentSession();
		  session.beginTransaction();
		  Criteria criteria = session.createCriteria(EmailChannel.class);
		  criteria.add(Restrictions.eq("id", 1));
		  emailChannel = (EmailChannel) criteria.uniqueResult();
		  session.getTransaction().commit();
		  return emailChannel;
		 }
	public int updatePort(EmailChannel emailChannel )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE EmailChannel set port = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", emailChannel.getPort());
	query.setParameter("id", emailChannel.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public List<EmailChannel> getAll() {
		FacebookChannel facebook = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT o FROM EmailChannel o";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}
	
}
