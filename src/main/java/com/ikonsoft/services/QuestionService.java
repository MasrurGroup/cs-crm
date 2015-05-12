package com.ikonsoft.services;
 
import com.ikonsoft.model.Question;
import com.ikonsoft.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class QuestionService {
 QuestionService() {}
     
 public static Question getQuestionById(int id) {
  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
   session.beginTransaction();
     String hql = "SELECT q FROM Question q WHERE q.questionId = :questionId";
     Query query = session.createQuery(hql);
     query.setParameter("questionId",1); 
     
     List results = query.list();
     Question q = (Question) results.get(0);
   System.out.println(q.getQuestion());
  session.getTransaction().commit();
   
    return (q);
 }
}


