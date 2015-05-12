package com.ikonsoft.services;
 
import org.hibernate.Session;

import com.ikonsoft.model.Question;
import com.ikonsoft.utils.HibernateUtil;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
 
@ManagedBean(name = "SurveyService")
@ApplicationScoped
public class SurveyService {
     
private  static  List <Question> questions;

 /*static{
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
          questions = session.createQuery("from Question").list();
        session.getTransaction().commit();
           
  }*/

    public SurveyService(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        questions = session.createQuery("from Question").list();
        session.getTransaction().commit();
         
    }
     /* public static  List<Question> getQuestions() {
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List questions = session.createQuery("from Question").list();
        session.getTransaction().commit();
        
        return questions;
        
     
    }*/
 
    public   List <Question> getQuestions() {
        return questions;
    }
 public  static List <Question> Questions() {
        return questions;
    }
    /**
     * @param questions the questions to set
     */
    public void setQuestions(List <Question> questions) {
        this.questions = questions;
    }
      
  
    
 
 
    
}
