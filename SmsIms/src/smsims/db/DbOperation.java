/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.db;

import java.util.List;
import java.util.Properties;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import smsims.om.Member;
import smsims.om.MessageResult;
import smsims.om.TypeUtil;

/**
 *
 * @author Lasith
 */
public class DbOperation {
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  

    public DbOperation() {
        // Configure the session factory
        if (sessionFactory == null) {
            configureSessionFactory();            
        }
    }
        
    private static SessionFactory configureSessionFactory() throws HibernateException {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
         
        Properties properties = configuration.getProperties();         
        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
         
        return sessionFactory;  
    }
        
    public void insertMember(Member member) throws Exception{
        Session session = null;
        Transaction tx = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();            
            
            // Saving to the database
            session.saveOrUpdate(member);
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
    }
    
    public List getMembers(String name) {
        Session session = null;
        Transaction tx = null;
        List<Member> list = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();            
            
            // Saving to the database
            Query query = session.createQuery("FROM Member WHERE name LIKE :givenName ");
            query.setParameter("givenName",  name + "%" );
            list = query.list();
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
//            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
       return list;
    }
    
    public List<Member> getMembersByEmployeeCode(String empCode) throws Exception {
        Session session = null;
        Transaction tx = null;
        List<Member> list = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();            
            
            // Saving to the database
            Query query = session.createQuery("FROM Member WHERE empCode LIKE :givenEmpCode ");
            query.setParameter("givenEmpCode", "%" + empCode + "%" );
            list = query.list();
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
       return list;
    }
    
    public void insertMessageResult(MessageResult messageResult) throws Exception{
        Session session = null;
        Transaction tx = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();            
            
            // Saving to the database
            session.saveOrUpdate(messageResult);
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
    }
    
    public List getMessageResults(String phoneNumber, String sessionId) {
        Session session = null;
        Transaction tx = null;
        List<MessageResult> list = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();            
            
            // Saving to the database
            Query query = session.createQuery("FROM MessageResult WHERE phoneNumber = :givenPhNumber AND sessionId = :givenSession");
            query.setParameter("givenPhNumber",  phoneNumber);
            query.setParameter("givenSession",  sessionId);
            list = query.list();
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
//            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
       return list;
    }
    
    public List getSessionMessageResults(String sessionId) {
        Session session = null;
        Transaction tx = null;
        List<MessageResult> list = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();            
            
            // Saving to the database
            Query query = session.createQuery("FROM MessageResult WHERE sessionId = :givenSession ");
            query.setParameter("givenSession",  sessionId);
            list = query.list();
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
//            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
       return list;
    }    
  
    public List<Member> getSelectedMembers(String department, String mgtLevel, String site) {
        Session session = null;
        Transaction tx = null;
        List<Member> list = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();   
            Criteria criteria = session.createCriteria(Member.class);            
        
            if (!TypeUtil.Departmens.All_Departments.toString().equals(department)) {
                criteria.add(Restrictions.eq("department", department));
            }
            if (!TypeUtil.MgtLevels.All_Levels.toString().equals(mgtLevel)) {
                criteria.add(Restrictions.eq("mgtLevel", mgtLevel));
            }
            if (!TypeUtil.Sites.All_Sites.toString().equals(site)) {
                criteria.add(Restrictions.eq("site", site));
            }
            criteria.add(Restrictions.eq("status", "ENABLED"));

            list = criteria.list();
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
//            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
       return list;
    }
    
    /**
     * Returns the latest session ID. If there are no records returns null.
     * 
     * @return 
     */
    public String getLatestSessionId() {
        Session session = null;
        Transaction tx = null;
        String latestSessionId = null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();   
            DetachedCriteria maxId = DetachedCriteria.forClass(MessageResult.class)
                .setProjection( Projections.max("sessionId") );
            Criteria criteria = session.createCriteria(MessageResult.class);          
            
            criteria.setProjection(Projections.max("sessionId"));
            criteria.add(Property.forName("sessionId").eq(maxId));
            List list = criteria.add( Property.forName("sessionId").eq(maxId) ).list();
            if (list.size() > 0 && list.get(0) != null) {
                latestSessionId = list.get(0).toString();                
            }
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
//            throw ex;
        } finally{
            if(session != null) {
                session.close();
            }
        }
       return latestSessionId;
    }    
}
