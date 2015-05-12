package com.ikonsoft.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ikonsoft.model.Region;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

public class RegionService implements Serializable{
	
	public List<Region> getAllRegions(int cityId){
		List<Region>regionsList = new ArrayList<Region>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 	   session.beginTransaction();
	 	   Criteria criteria = session.createCriteria(Region.class);
	 	   criteria.add(Restrictions.eq("cityId", cityId));
	 	  regionsList = criteria.list();
	 	  session.getTransaction().commit();
		return regionsList;
	}

}
