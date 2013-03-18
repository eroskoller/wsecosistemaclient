/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import br.com.dasa.hibernate.utils.OracleHelper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class EcosistemasSqlDao {

    public static List<RetornoStatus> grabRegistosStatus(String uniStCodigo,String sql, String strDbName) {

        List<RetornoStatus> listRetornoStatus = new ArrayList<RetornoStatus>();
        
        Session session =  null;
        Transaction tx =  null;
        
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            
            Query query = session.createSQLQuery(sql);
            query.setString("uniStCodigo", uniStCodigo);
            
            List l = query.list();
            tx.commit();
            
            if (l != null && !l.isEmpty()){
                
                for (int i = 0; i < l.size(); i++) {
                    Object[] tupla = (Object[]) l.get(i);
                    
                    RetornoStatus retornoStatus = new RetornoStatus();
                    
                    retornoStatus.setReqStCodigo((String) tupla[0]);
                    retornoStatus.setExaStCodigo((String) tupla[1]);
                    retornoStatus.setReqStCodigoAlt((String) tupla[2]);
                    retornoStatus.setUpdStCodigo((String) tupla[3]);
                    retornoStatus.setEdpStCodigo((String) tupla[4]);
                    retornoStatus.setUniStCodigo((String) tupla[5]);
                    retornoStatus.setDerInFlag((BigDecimal) tupla[6]);
                    
                    listRetornoStatus.add(retornoStatus);
                }
            } else {
                System.out.println("Lista vazia");
            }
                    
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return listRetornoStatus;
    }
    
    
}
