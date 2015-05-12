package com.ikonsoft.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.ikonsoft.model.Country;
import com.ikonsoft.model.User;
import com.ikonsoft.utils.HibernateUtil;

public class CountryService implements Serializable {
	
	public List<Country> getAllCountries(){
		List<Country>countriesList = new ArrayList<Country>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 	   session.beginTransaction();
	 	   Criteria criteria = session.createCriteria(Country.class);
	 	  countriesList = criteria.list();
	 	  session.getTransaction().commit();
		return countriesList;
	}
	

}
