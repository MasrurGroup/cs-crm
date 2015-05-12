package com.ikonsoft.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ikonsoft.model.City;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

public class CityService implements Serializable {
	
	public List<City> getAllCities(int countryId){
		List<City>citiesList = new ArrayList<City>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 	   session.beginTransaction();
	 	   Criteria criteria = session.createCriteria(City.class);
	 	   criteria.add(Restrictions.eq("countryId", countryId));
	 	  citiesList = criteria.list();
	 	  session.getTransaction().commit();
		return citiesList;
	}
}
