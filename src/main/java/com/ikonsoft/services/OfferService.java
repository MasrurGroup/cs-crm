package com.ikonsoft.services;

import java.io.Serializable;
import java.util.List;



import com.ikonsoft.model.Offer;
import com.ikonsoft.utils.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

public class OfferService  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session;

	public int createOffer(Offer offer) {
		int id = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.save(offer);
			session.getTransaction().commit();
			id = offer.getId();
			System.out.println("\n\nNew offer Id :" + id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return id;
	}

	public Offer getOfferByEmailId(String email) {
		Offer offer = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT o FROM Offer o WHERE o.senderEmail = :senderEmail";
		Query query = session.createQuery(hql);
		query.setParameter("companyEmail", email);

		List results = query.list();
		if (results.size() > 0) {
			offer = (Offer) results.get(0);

			System.out.println("offer id = " + offer.getId());
		} else {
			System.out.println("offer Not found");
		}
		session.getTransaction().commit();

		return (offer);
	}

	public List<Offer> getNotApproved() {
		Offer offer = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT o FROM Offer o where o.approved =NULL or o.approved = 'fasle'";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

	public int approveOffer(Offer offer) {
		int result;	
		try{

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Offer set approved = 1 "
				+ "WHERE id = :offer_id";
		Query query = session.createQuery(hql);
		//query.setParameter("value", 1);
		query.setParameter("offer_id", offer.getId());
		result = query.executeUpdate();
		session.getTransaction().commit();
		return result;
		}catch(RuntimeException ex)
		{
			session.getTransaction().rollback();
			throw ex;
				
		}
	}

	public int deleteOffer(Offer offer )
	{
		int result;	
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "delete from Offer "  + 
	             "WHERE id = :offer_id";
	Query query = session.createQuery(hql);
	//query.setParameter("value", 1);
	query.setParameter("offer_id", offer.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	
	public List<Offer> getApproved() {
		Offer offer = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT o FROM Offer o where o.approved =1";
		Query query = session.createQuery(hql);
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)

			return results;
		else
			return null;
	}

}
