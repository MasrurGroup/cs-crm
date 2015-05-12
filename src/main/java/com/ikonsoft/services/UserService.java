
package com.ikonsoft.services;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;











import com.ikonsoft.mbeans.user.test.UserSearch;
import com.ikonsoft.model.Channel;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

 
public class UserService implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int createUser(User user)
    {  int id = 0;
    User existingUser = getUserByEmailId(user.getEmailId());
    if (existingUser!=null){ 
    System.out.println("Cant create user , email already exists");
    return 0;
    }
   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    try {
        session.beginTransaction();
        user.setAcessToken("Not Redeem");
        session.save(user);
        id = user.getUserId();
        session.getTransaction().commit();
       
        System.out.println("\n\nNew Person Id :"+id);
        } catch (RuntimeException e) {  e.printStackTrace(); } 
    
          return id;           	          
    }
    
	public User getUserVoucherNumber(int Vnum) {
		User user = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "SELECT u FROM User u WHERE u.voucherNumber = :vnum";
		Query query = session.createQuery(hql);
		query.setParameter("vnum", Vnum);

		List results = query.list();
		if (results.size() > 0) {
			user = (User) results.get(0);

			
		} 
		session.getTransaction().commit();

		return (user);
	}
	
	public User getUserByNationalIdAndEmail(String nationalId, String email){
		User user = null;
   	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
   	   session.beginTransaction();
   	     String hql = "SELECT u FROM User u WHERE u.emailId = :email AND u.nationalId = :nationalId AND u.acessToken = :access";
   	     Query query = session.createQuery(hql);
   	     query.setParameter("email",email); 
   	     query.setParameter("nationalId", nationalId);
   	     query.setParameter("access", "Not Redeem");
   	     List results = query.list();
   	if (results.size()>0) { user = (User) results.get(0);
   	
   	   System.out.println("User id = "+user.getUserId());
   	}else {
   		  System.out.println("User Not found");
   	}
   	  session.getTransaction().commit();
   	   
   	    return (user); 
	}


    public User getUserByEmailId(String email)
    { User user = null;
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	   session.beginTransaction();
    	     String hql = "SELECT u FROM User u WHERE u.emailId = :email";
    	     Query query = session.createQuery(hql);
    	     query.setParameter("email",email); 
    	     
    	     List results = query.list();
    	if (results.size()>0) { user = (User) results.get(0);
    	
    	   System.out.println("User id = "+user.getUserId());
    	}else {
    		  System.out.println("User Not found");
    	}
    	  session.getTransaction().commit();
    	   
    	    return (user);        	          
    }
    
    public List<User> getUsersList(UserSearch userSearch){
    	List<User>usersList = new ArrayList<User>();
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 	   session.beginTransaction();
 	   Criteria criteria = session.createCriteria(User.class);
 	   addCriteria(criteria,userSearch);
 	  usersList = criteria.list();
 	   session.getTransaction().commit();
    	return usersList;
    }
    
	public int updateAddress(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set Address = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getAddress());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public void updateAccessTokenUser(User user){
		int result;	
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String hql = "UPDATE User set acessToken = :value "  + 
		             "WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("value", user.getAcessToken());
		query.setParameter("id", user.getUserId());
		result = query.executeUpdate();
		session.getTransaction().commit();
		}catch(RuntimeException ex)
		{
			session.getTransaction().rollback();
			throw ex;
	}}
    
	public int updateFirstName(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set firstName = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getFirstName());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateLastName(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set lastName = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getLastName());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateNID(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set nationalId = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getNationalId());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	
	public int updateProfession(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set profession = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getProfession());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updatePhone(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set phone = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getPhone());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	public int updateMstatus(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set martialStatus = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getMartialStatus());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}

	public int updateDOB(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set birthdate = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getBirthdate());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateFriendName(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set friendName = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getFriendName());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateFriendEmail(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set friendEmail = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getFriendEmail());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	public int updateEmail(User user )
	{
		int result;	
	Session session = null;
	try{
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "UPDATE User set email_id = :value "  + 
	             "WHERE id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("value", user.getEmailId());
	query.setParameter("id", user.getUserId());
	result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
	}catch(RuntimeException ex)
	{
		session.getTransaction().rollback();
		throw ex;
			
	}
	
	}
	
	
	
	public void addCriteria(Criteria criteria, UserSearch usersearch) {
	

		
		if (!usersearch.getGender().equals("All"))
			criteria.add(Restrictions.like("gender", usersearch.getGender(),
					MatchMode.ANYWHERE));

		if (!usersearch.getMartialStatus().equals("All"))
			criteria.add(Restrictions.like("martialStatus",
					usersearch.getMartialStatus(), MatchMode.ANYWHERE));

		if (usersearch.getPartnerId() != -1)
			criteria.add(Restrictions.eq("partnerId", usersearch.getPartnerId()));

		if (usersearch.getFromDate() != null)
			criteria.add(Restrictions.ge("birthdate", usersearch.getFromDate()));

		if (usersearch.getToDate() != null)
			criteria.add(Restrictions.le("birthdate", usersearch.getToDate()));

		if (usersearch.getCountryId() != -1)
			criteria.add(Restrictions.eq("countryId", usersearch.getCountryId()));

		if (usersearch.getCityId() != -1 && usersearch.getCityId() != 0)
			criteria.add(Restrictions.eq("cityId", usersearch.getCityId()));

		if (usersearch.getRegionId() != -1 && usersearch.getRegionId() != 0)
			criteria.add(Restrictions.eq("regionId", usersearch.getRegionId()));
		
		if(usersearch.getProfessionId()!=-1)
			criteria.add(Restrictions.eq("professionId", usersearch.getProfessionId()));
		
		if(usersearch.getSubprofessionId()!=-1&&usersearch.getSubprofessionId()!=0)
			criteria.add(Restrictions.eq("subprofessionId", usersearch.getSubprofessionId()));

	}
	public String getUsersQueryStatement(UserSearch usersearch) {
		  SimpleDateFormat formator = new SimpleDateFormat(
		    "yyyy-MM-dd hh:mm:ss");
		  String query = "select * from user where user_id is not null";
		  String where = "";
		  if (!usersearch.getGender().equals("All"))
		   where += " and gender like '%" + usersearch.getGender()+"%'";

		  if (!usersearch.getMartialStatus().equals("All"))
		   where += " and martialStatus like '%" + usersearch.getMartialStatus()+"%'";

		  if (usersearch.getPartnerId() != -1)
		   where += " and partnerId = " + usersearch.getPartnerId();

		  if (usersearch.getFromDate() != null)
		   where += " and birthdate >= '" + formator.format(usersearch.getFromDate())+"'";

		  if (usersearch.getToDate() != null)
		   where += " and birthdate <= '"+formator.format(usersearch.getToDate())+"'";

		  if (usersearch.getCountryId() != -1)
		   where += " and country_id = " + usersearch.getCountryId();

		  if (usersearch.getCityId() != -1 && usersearch.getCityId() != 0)
		   where += " and city_id = " + usersearch.getCityId();

		  if (usersearch.getRegionId() != -1 && usersearch.getRegionId() != 0)
		   where += " and region_id = " + usersearch.getRegionId();

		  if (usersearch.getProfessionId() != -1)
		   where += " and profession_id = " + usersearch.getProfessionId();

		  if (usersearch.getSubprofessionId() != -1
		    && usersearch.getSubprofessionId() != 0)
		   where += " and subprofession_id = "
		     + usersearch.getSubprofessionId();

		  return query + where;

		 }
    
	public List<User> getUsersBySQLquery(String query) {
		  List<User> usersList = new ArrayList<User>();
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		  session.beginTransaction();
		  SQLQuery sqlQuery = session.createSQLQuery(query); 
		  sqlQuery.addEntity(User.class);
		  usersList = sqlQuery.list();
		  session.getTransaction().commit();
		  return usersList;
		 }
    
}
