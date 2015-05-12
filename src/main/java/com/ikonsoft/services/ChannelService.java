package com.ikonsoft.services;

import java.io.Serializable;
import java.util.List;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.model.Channel;
import com.ikonsoft.utils.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

public class ChannelService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session;

	
	public int updateChannelTimeStamp(Channel channel )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Channel set timestamp = :value "  + 
	             "WHERE channel_id = :channel_id";
	Query query = session.createQuery(hql);
	query.setParameter("value", channel.getTimestamp());
	query.setParameter("channel_id", channel.getChannelId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateChannelValidFrom(Channel channel )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Channel set validfrom = :value "  + 
	             "WHERE channel_id = :channel_id";
	Query query = session.createQuery(hql);
	query.setParameter("value", channel.getValidfrom());
	query.setParameter("channel_id", channel.getChannelId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateChannelExpiryDate(Channel channel )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Channel set expirydate = :value "  + 
	             "WHERE channel_id = :channel_id";
	Query query = session.createQuery(hql);
	query.setParameter("value", channel.getExpirydate());
	query.setParameter("channel_id", channel.getChannelId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	

	public int updateChannelName(Channel channel )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Channel set name = :value "  + 
	             "WHERE channel_id = :channel_id";
	Query query = session.createQuery(hql);
	query.setParameter("value", channel.getName());
	query.setParameter("channel_id", channel.getChannelId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateChannel(Channel channel )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Channel set value = :value "  + 
	             "WHERE channel_id = :channel_id";
	Query query = session.createQuery(hql);
	query.setParameter("value", channel.getValue());
	query.setParameter("channel_id", channel.getChannelId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	

	public List<Channel> getAll() {
		Channel channel = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT c FROM Channel c";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

	public Channel getChannelById(int id) {
		Channel channel = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT c FROM Channel c WHERE c.channel_id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		List results = query.list();
		if (results.size() > 0) {
			channel = (Channel) results.get(0);

			System.out.println("channel_id = " + channel.getChannelId());
		} else {
			System.out.println("campaign Not found");
		}
		session.getTransaction().commit();

		return (channel);
	}

}
