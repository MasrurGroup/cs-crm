
package com.ikonsoft.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;







import com.ikonsoft.model.Partner;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

 
public class PartnerService implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int createPartner(Partner partner)
    {  int id = 0;
    Partner existingpartner = getPartnerByEmailId(partner.getCompanyEmail());
    if (existingpartner!=null){ 
    System.out.println("Cant create partner , email already exists");
    return 0;
    }
   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    try {
        session.beginTransaction();
        session.save(partner);
        session.getTransaction().commit();
          id = partner.getId();
        System.out.println("\n\nNew Person Id :"+id);
        } catch (RuntimeException e) {  e.printStackTrace(); } 
    
          return id;           	          
    }
    
    public Partner getPartnerByEmailId(String email)
    {    Partner partner = null;
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	   session.beginTransaction();
    	     String hql = "SELECT p FROM Partner p WHERE p.companyEmail = :companyEmail";
    	     Query query = session.createQuery(hql);
    	     query.setParameter("companyEmail",email); 
    	     
    	     List results = query.list();
    	if (results.size()>0) { partner = (Partner) results.get(0);
    	
    	   System.out.println("partner id = "+partner.getId());
    	}else {
    		  System.out.println("partner Not found");
    	}
    	  session.getTransaction().commit();
    	   
    	    return (partner);        	          
    }
  
    public List<Partner>getAllPartners(){
    	List<Partner>partners = new ArrayList<Partner>();
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 	    session.beginTransaction();
 	    Criteria criteria = session.createCriteria(Partner.class);
 	    partners = criteria.list();
 	    session.getTransaction().commit();
    	return partners;
    }
    
    public int updateName(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set companyName = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value",partner.getCompanyName() );
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
    
	public int updateAddress(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set address = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getAddress());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	public int updateBusinessType(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set businesstype = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getBusinesstype());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateRegNum(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set companyRegistrationNumber = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getCompanyRegistrationNumber());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateTelephone(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set telephone = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getTelephone());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateFormation(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set yearofCompanyFormation = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getYearofCompanyFormation());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateOfficerName(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set officername = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getOfficername());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	public int updateEmail(Partner partner )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE Partner set companyEmail = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", partner.getCompanyEmail());
	query.setParameter("id", partner.getId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
    
}
