/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import br.com.dasa.hibernate.entities.LabDetalheRequisicao;
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
    
    public static List<RetornoStatus> grabRegistosStatus(String strDbName) {

        List<RetornoStatus> listRetornoStatus = new ArrayList<RetornoStatus>();
        
        Session session =  null;
        Transaction tx =  null;
        
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            
            Query query = session.createSQLQuery(SqlStatic.SQLECOSISTEMAS);
            
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
                    retornoStatus.setLegStCodigo((String) tupla[7]);
                    
                    if ((BigDecimal) tupla[8] != null) {
                        retornoStatus.setDerChStatusIntegracao((BigDecimal) tupla[8]);
                    } else {
                        retornoStatus.setDerChStatusIntegracao(BigDecimal.ZERO);
                    }
                    retornoStatus.setSeqStCodigo((String) tupla[9]);
                    
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

    public static void updateEnviados(RetornoStatus retornoStatus) {
        
        Session session = null;
        Transaction tx =  null;
        
        try {
            if (retornoStatus.getSucesso()) {
                session = OracleHelper.getSessionDude("DEFAULT");
                tx = session.beginTransaction();

                String hql =
                        "update LabDetalheRequisicao set derChStatusIntegracao = :derChStatusIntegracao "
                        + " where reqStCodigo = :reqStCodigo and exaStCodigo = :exaStCodigo and seqStCodigo = :seqStCodigo";

                Query query = session.createQuery(hql);
                
                if (retornoStatus.getTipoRetorno().equals("NC") || retornoStatus.getTipoRetorno().equals("CA") || 
                        retornoStatus.getTipoRetorno().equals("AL") || retornoStatus.getTipoRetorno().equals("LA") ){
                    query.setBigDecimal("derChStatusIntegracao", BigDecimal.valueOf(9));
                } else {
                    query.setBigDecimal("derChStatusIntegracao", BigDecimal.valueOf(1));
                    
                }
                query.setString("reqStCodigo", retornoStatus.getReqStCodigo());
                query.setString("exaStCodigo", retornoStatus.getExaStCodigo());
                query.setString("seqStCodigo", retornoStatus.getSeqStCodigo());
                query.executeUpdate();
                tx.commit();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

}
