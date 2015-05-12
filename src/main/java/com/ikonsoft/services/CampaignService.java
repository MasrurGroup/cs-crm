package com.ikonsoft.services;

import java.io.Serializable;
import java.util.List;

import com.ikonsoft.model.Campaign;
import com.ikonsoft.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CampaignService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session;

	public int createCampaign(Campaign campaign) {
		int id = 0;
		/*
		 * Campaign existingCampaign=null; existingCampaign =
		 * getCampaignByEmailId(campaign.getSenderEmail()); if
		 * (existingCampaign!=null){
		 * System.out.println("Cant create campaign , email already exists");
		 * return 0; }
		 */
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(campaign);
			id = campaign.getId();
			session.getTransaction().commit();

			System.out.println("\n\nNew Campaign Id :" + id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return id;
	}

	public List<Campaign> getNotApproved() {
		Campaign campaign = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT c FROM Campaign c where c.approved =NULL or c.approved = 'fasle'";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

	public int approveCampaign(Campaign campaign )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Campaign set approved = 1 "  + 
	             "WHERE id = :campaign_id";
	Query query = session.createQuery(hql);
	//query.setParameter("value", 1);
	query.setParameter("campaign_id", campaign.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int deleteCampaign(Campaign campaign )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "delete from Campaign "  + 
	             "WHERE id = :campaign_id";
	Query query = session.createQuery(hql);
	//query.setParameter("value", 1);
	query.setParameter("campaign_id", campaign.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public List<Campaign> getApproved() {
		Campaign campaign = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "SELECT c FROM Campaign c where c.approved =1";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}


	public List<Campaign> getAll() {
		Campaign campaign = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT c FROM Campaign c";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

	public Campaign getCampaignByEmailId(String email) {
		Campaign campaign = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT c FROM Campaign c WHERE c.senderEmail = :senderEmail";
		Query query = session.createQuery(hql);
		query.setParameter("senderEmail", email);

		List results = query.list();
		if (results.size() > 0) {
			campaign = (Campaign) results.get(0);

			System.out.println("campaign id = " + campaign.getId());
		} else {
			System.out.println("campaign Not found");
		}
		session.getTransaction().commit();

		return (campaign);
	}

}
