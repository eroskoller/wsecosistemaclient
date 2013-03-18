/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.hibernate.utils;

//import br.com.facesbeans.AccessDetails;
//import br.com.facesbeans.ExameBean;
//import br.com.facesbeans.LabPacienteBean;
//import br.com.facesbeans.MaterialBean;
import br.com.dasa.hibernate.entities.*;
//import br.com.oracleconnector.OracleConnector;
//import br.com.oracleconnector.StaticQuerys;
//import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

/**
 *
 * @author eros
 */
public class OracleHelper {

    static protected Logger log = Logger.getLogger("logs4.tmlab");
    public static SimpleDateFormat formatOnlyYear = new SimpleDateFormat("yyyy");
//  static public    List<MaterialBean>  listMaterialBeans = new ArrayList<MaterialBean>();
//    static Session session = null;
//    static  Transaction tx = null;

    /**
     *
     *
     * @return a new Session if session is null or a session if session is not null
     */
    public static Session getSessionDude(String strDbName) {
        Session session = null;
        Transaction tx = null;

        if (session == null || !session.isOpen()) {
//            return session = SessionFactoryOracle.getCurrentSession4Faces();
                        return SessionFactoriByDBName.getCurrentSession4FacesByDbName(strDbName);
        } else {
            return session;
        }
    }

    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
    public static Object getObject(Class clazz, long id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;

    }

    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
    public static Object getObject(Class clazz, String id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return obj;
    }

    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
    public static Object getObject(Class clazz, Object idPk,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, (Serializable) idPk);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * @param clazz
     * @param id
     * @return List<Object>
     */
    public static List getListObject(Class clazz,String strDbName) {

        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        List result;


        try {
            Criteria criteria = session.createCriteria(clazz);
            result = criteria.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    /**
     *
     * @param classBean
     * @param strKey
     * @param value
     * @return a first Object from a List of obejcts
     */
    static public Object getObjectByKey(Class classBean, String strKey, Object value,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List result = null;
        Object obj = null;
        try {


            Criteria criteria = session.createCriteria(classBean);

            if (strKey != null) {
                criteria.add(Restrictions.eq(strKey, value));
            }
            result = criteria.list();
            tx.commit();


            if (result != null && result.size() > 0) {
                obj = result.get(0);
            }



        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }
    
    
    /**
     *
     * @param classBean
     * @param strKey
     * @param value
     * @return a first Object from a List of obejcts
     */
    static public Object getObjectByKey(Class classBean, String strKey,String strKey2, Object value,Object value2,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List result = null;
        Object obj = null;
        try {


            Criteria criteria = session.createCriteria(classBean);

            if (strKey != null  && strKey2 != null) {
                criteria.add(Restrictions.eq(strKey, value));
                criteria.add(Restrictions.eq(strKey2, value2));
            }
            result = criteria.list();
            tx.commit();


            if (result != null && result.size() > 0) {
                obj = result.get(0);
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * @param classBean
     * @param strKey
     * @param value
     * @return a List of obejcts
     */
    static public java.util.List getListOfObjectByKey(Class classBean, String strKey, Object value,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(classBean);

            if (strKey != null) {
                criteria.add(Restrictions.eq(strKey, value));
            }
            result = criteria.list();

            tx.commit();
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    static public java.util.List getListOfObjectByKeyEq(Class classBean, String strKey, Object value, String orderByField, boolean orderBy,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List result = null;
        try {

            if (strKey != null) {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                Criteria criteria = session.createCriteria(classBean);

                criteria.add(Restrictions.eq(strKey, value));
//                criteria.add(Restrictions.isNotNull(strKey));
                if (orderBy) {
                    criteria.addOrder(Order.asc(orderByField));
                } else {
                    criteria.addOrder(Order.desc(orderByField));
                }
                tx.commit();

                result = criteria.list();
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

    /**
     *
     * @param obj save a obj
     *
     */
    public static void saveObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public static Object saveObjectReturn(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return obj;

    }

    /**
     *
     * @param save a list of objects
     */
    public static void saveObjectList(List list,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.save(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     *
     * @param obj save or update a obj
     *
     */
    public static void saveOrUpdateObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *
     * @param save or update a list of objects
     */
    public static void saveOrUpdateObjectList(List list,String strDbName) {

        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.saveOrUpdate(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     *
     * @param update a obj 
     *
     */
    public static void updateObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *
     * @param update a obj and return the same
     *
     */
    public static Object updateObjectReturnObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            session.update(obj);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * @param save a list of objects
     */
    public static void updateObjectList(List list,String strDbName) {

        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.update(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }


    /**
     *
     * @param obj delete object
     */
    public static void deleteObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *
     * @param delete a list of objects
     */
    public static void deleteObjectList(List list,String strDbName) {

        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.delete(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    
    public static Long getLabRequisicaoNextId(String strDbName) {
        String codigo = formatOnlyYear.format(new Date()).substring(2, 4);
        codigo += getIdByNextValueStringSQL("select SEQ_REQ_ST_CODIGO.nextval from dual",strDbName);
        return new Long(codigo);
    }
    
    public static BigDecimal getWcieLoteSolicitacaoExamesNextId(String strDbName) {
        return new BigDecimal(getIdByNextValueStringSQL("select SEQ_WSCIE_LOTE_EXAME.nextval from dual",strDbName));
    }


    /**
     *
     * @param clazz
     * @param id
     * @return String
     */
    public static String getPacienteNextValue(String strDbName) {
        
        String codigo = "";
        String sqlSeq = "select SEQ_PAC_IN_CODIGO.nextval from dual";
        
        codigo = getIdByNextValueStringSQL(sqlSeq,strDbName);
        return codigo;

    }

    static public List<Object> getListObjectsByOrs(Class myClass, String strFieldName, List listArgs,String strDbName) {

        Session session = null;
        Transaction tx = null;

        List result = null;
        if (listArgs != null && listArgs.size() > 0) {


            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(myClass);

                Disjunction disj;
                Property property = Property.forName(strFieldName);


                if (listArgs != null && listArgs.size() > 0) {
                    disj = Restrictions.disjunction();
                    for (Object strArgs : listArgs) {
                        disj.add(property.eq(strArgs));
                    }
                    tx.commit();
                    result = criteria.add(disj).list();

                }

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }


        }
        return result;
    }

    
    
    static public List getListObjectsByAnds(Class myClass, Map<String, Object> mapArgs, int intMaxresult ,String strKeyOrderBy, boolean blOrderBy,String strDbName) {
        List result = null;
        Session session = null;
        Transaction tx = null;

        if (mapArgs != null && mapArgs.size() > 0) {

            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(myClass);
                Iterator iter = mapArgs.entrySet().iterator();

                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
                
                if(blOrderBy){
                    criteria.addOrder(Order.asc(strKeyOrderBy));
                }else{
                    criteria.addOrder(Order.desc(strKeyOrderBy));
                }
                
                criteria.setMaxResults(intMaxresult);
                
                tx.commit();
                result = criteria.list();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

        }
        return result;

    }
    
    
    
    static public List getListObjectsByAnds(Class myClass, Map<String, Object> mapArgs,String strDbName) {
        List result = null;
        Session session = null;
        Transaction tx = null;

        if (mapArgs != null && mapArgs.size() > 0) {

            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(myClass);
                Iterator iter = mapArgs.entrySet().iterator();

                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }

                tx.commit();
                result = criteria.list();

            }catch(Exception xcp){
                xcp.printStackTrace();
            }finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

        }
        return result;

    }

    static public List getListObjectsByAnds_Ors(Class myClass, Map<String, Object> mapArgsAnds, String strFieldName, List listArgsOrs,String strDbName) {

        List resutl = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);

            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {

                Iterator iter = mapArgsAnds.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
            }

            if (listArgsOrs != null && listArgsOrs.size() > 0) {
                Disjunction disj;
                Property property = Property.forName(strFieldName);


                if (listArgsOrs != null && listArgsOrs.size() > 0) {
                    disj = Restrictions.disjunction();
                    for (Object strArgs : listArgsOrs) {
                        disj.add(property.eq(strArgs));
                    }
                    resutl = criteria.add(disj).list();
                }
                tx.commit();
                if (resutl == null) {
                    resutl = criteria.list();
                }

            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return resutl;
    }

    static public List getListObjectsByAnds_Ors_Dates(Class myClass,
            Map<String, Object> mapArgsAnds,
            Map<String, List> mapArgsOrs,
            String strDateFieldName, Date dtStart, Date dtEnd,int intMaxResults,String strDbName) {
        Session session = null;
        Transaction tx = null;

        List result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);


            if (dtStart != null && dtEnd != null && strDateFieldName != null ) {
                        criteria.add(Expression.between(strDateFieldName, dtStart, dtEnd));
            }

            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {

                Iterator iter = mapArgsAnds.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
            }


            if (mapArgsOrs != null && mapArgsOrs.size() > 0) {

                Iterator iter = mapArgsOrs.entrySet().iterator();
                Disjunction disj;
                Property property;

                while (iter.hasNext()) {
                    disj = Restrictions.disjunction();
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    property = Property.forName(pair.getKey());
                    List<Object> l = (List<Object>) pair.getValue();
                    for (Object obj : l) {
                        disj.add(property.eq(obj));
                    }

                    criteria.add(disj);
                }
                criteria.setMaxResults(intMaxResults);
                tx.commit();
                result = criteria.list();
            }



            if (result == null) {
                criteria.setMaxResults(intMaxResults);
                tx.commit();
                result = criteria.list();
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

    static public java.util.List getListOfObjectByDate(Class classBean, String strKey, Object value, String strKeyDt, Date dt, boolean blBiggerOrLess,String strDbName) {


        List result = null;
        Session session = null;
        Transaction tx = null;

        try {

            if (strKey != null) {

                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                Criteria criteria = session.createCriteria(classBean);
                criteria.add(Restrictions.eq(strKey, value));
                criteria.add(Expression.ge(strKeyDt, dt));
                criteria.addOrder(Order.desc(strKey));
                tx.commit();

                result = criteria.list();
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;

    }

    public static String getIdByNextValueStringSQL(String strSql,String strDbName) {

        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        String strResult = null;
        List result;

        try {
            org.hibernate.Query query = session.createSQLQuery(strSql);
            result = query.list();
            tx.commit();
            if (result != null) {
                strResult = result.get(0).toString();
            }


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return strResult;

    }
    
    
    
    public static void procedureExecuterPSTATUSREQUISICAO(String reqStCodigo, String strDbName) {
        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Connection con = session.connection(); 
        List result;

        try {
           CallableStatement cs = con.prepareCall("{ call PSTATUSREQUISICAO(?,?,?) }");
            cs.setString(1,reqStCodigo);  // first parameter index start with 1
            cs.setString(2,""); // second parameter
            cs.setString(3,""); // second parameter
            cs.execute();  // call stored procedure
            tx.commit();

        }catch(Exception xcp){
            xcp.printStackTrace();;
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    
    public static Long getLabRelatorioNextId(String strDbName) {
        return new Long(getIdByNextValueStringSQL("select SEQ_REL_IN_CODIGO.nextval from dual",strDbName));
    }
    
    
    public static Date getDateFromDB(String strDbName){
        
        Session session = null;
        Transaction tx = null;
        Date rightNow = null;
        try{
            
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            
            Query query = session.createSQLQuery("SELECT SYSDATE FROM Dual");
            List listQuery = query.list();
            
           if(listQuery != null && !listQuery.isEmpty()){
               for (int i = 0; i < listQuery.size(); i++) {
                   java.sql.Timestamp rightNowTimeStamp =  (java.sql.Timestamp) listQuery.get(i);
                   rightNow = new Date(rightNowTimeStamp.getTime());
                   if(rightNow != null){
                       break;
                   }
               }
           }
            
            
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return rightNow;
    }

    public static List<LabSistema> grabSistema(String sistema, String strDbName) {
        
        List<LabSistema> listSistema = null;
        Session session = null;
        Transaction tx  = null;
        
        try{
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            
            Query query = session.createQuery(" from LabSistema where sisStEmpresa = :sisStEmpresa and sisChAtivo = 'S'");
            query.setString("sisStEmpresa", sistema);
            listSistema = query.list();
            tx.commit();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return listSistema;
    }

    
}//end of the class
