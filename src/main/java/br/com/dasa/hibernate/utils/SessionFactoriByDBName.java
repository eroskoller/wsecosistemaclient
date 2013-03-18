/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.hibernate.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author eros
 */
public class SessionFactoriByDBName implements Serializable{
//    static protected Logger log = Logger.getLogger(SessionFactoriByDBName.class.getName());

    public static Map<String, SessionFactory> map4SessionFactory = new HashMap<String, SessionFactory>();

    
    public static Session getCurrentSession4FacesByDbName(String strDbName){
            SessionFactory factory = getSessionFactoryByDbName(strDbName);
            return  factory.openSession();
    }
    
    
    
    private static SessionFactory getSessionFactoryByDbName(String strDBName) {
        strDBName = strDBName.toUpperCase();
        if (map4SessionFactory.containsKey(strDBName)) {
            return map4SessionFactory.get(strDBName);
        }else{
            SessionFactory sessionFactory = buildSessionFactoryByDBName(strDBName);
            map4SessionFactory.put(strDBName, sessionFactory);
            return sessionFactory;
        }
    }

    
  
    private static SessionFactory buildSessionFactoryByDBName(String strDBName) {



        SessionFactory sessionFactory = null;
        try {
            System.out.println("Getting Session from client:       "+strDBName);
           if (strDBName.equalsIgnoreCase("DEFAULT")) {
//               System.out.println("Inside DEFAULT.................hibernateOracle.cfg.xml");
                sessionFactory = new AnnotationConfiguration().configure("hibernateOracle.cfg.xml").buildSessionFactory();
            } else {
                sessionFactory = new AnnotationConfiguration().configure("hibernateOracle" + strDBName.toUpperCase() + ".cfg.xml").buildSessionFactory();
            }
        } catch (Exception xcp) {
            xcp.printStackTrace();
//            log.error(xcp);
        } finally {
            return sessionFactory;
        }

    }
}
