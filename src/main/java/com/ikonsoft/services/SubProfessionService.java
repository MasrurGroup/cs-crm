package com.ikonsoft.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ikonsoft.model.Profession;
import com.ikonsoft.model.SubProfession;
import com.ikonsoft.utils.HibernateUtil;

public class SubProfessionService implements Serializable {

	public List<SubProfession> getAllSubProfessions(int professionId) {
		List<SubProfession> subProfessionsList = new ArrayList<SubProfession>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(SubProfession.class);
		criteria.add(Restrictions.eq("professionId", professionId));
		subProfessionsList = criteria.list();
		session.getTransaction().commit();
		return subProfessionsList;
	}

}
