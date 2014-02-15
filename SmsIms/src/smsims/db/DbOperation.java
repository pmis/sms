/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsims.db;

import java.util.List;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import smsims.om.Member;

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
            Query query = session.createQuery("FROM Member WHERE name = :givenName ");
            query.setParameter("givenName", name);
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
        
}
