package com.ikonsoft.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.ikonsoft.model.Profession;
import com.ikonsoft.utils.HibernateUtil;

public class ProfessionService implements Serializable {
	
	public List<Profession>getAllProfessions(){
		List<Profession>professionsList = new ArrayList<Profession>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 	   session.beginTransaction();
	 	   Criteria criteria = session.createCriteria(Profession.class);
	 	  professionsList = criteria.list();
	 	  session.getTransaction().commit();
		return professionsList;
	}

}
