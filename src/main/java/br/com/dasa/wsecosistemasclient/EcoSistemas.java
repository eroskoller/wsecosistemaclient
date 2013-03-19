/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import br.com.dasa.hibernate.entities.LabSistema;
import br.com.dasa.hibernate.utils.OracleHelper;
import java.util.ArrayList;
import java.util.List;
import org.tempuri.RepassarResultado;
import org.tempuri.RepassarResultadoResponse;
import org.tempuri.RepassarResultadoService;
import org.tempuri.RepassarResultadoServiceSoap;

/**
 *
 * @author Marcos Naves
 */
public class EcoSistemas {
    
    public void sendToEcosistemas() {

        List<LabSistema> sistema = OracleHelper.grabSistema("ECOSISTEMAS", "DEFAULT");

        if (sistema != null) {
            for (LabSistema labSistema : sistema) {
                System.out.println("Lista de Sistemas/Unidade  - Triagem: " + labSistema.getSisStCodigo() + "/" + labSistema.getUniStCodigo().getUniStCodigo());
                List<RetornoStatus> listRetornoStatus = EcosistemasSqlDao.grabRegistosStatus(labSistema.getUniStCodigo().getUniStCodigo(), SqlStatic.TRIAGEM, "DEFAULT");

                if (listRetornoStatus != null) {

                    RepassarResultadoService service = new RepassarResultadoService();
                    RepassarResultadoServiceSoap port = service.getRepassarResultadoServiceSoap();

                    for (RetornoStatus retornoStatus : listRetornoStatus) {
                        try {
                            port.repassarResultado(retornoStatus.getUpdStCodigo(), retornoStatus.getReqStCodigoAlt(), "EA", retornoStatus.getEdpStCodigo(), "", retornoStatus.getReqStCodigo(), "");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }

                System.out.println("Lista de Sistemas/Unidade  - Nova Coleta: " + labSistema.getSisStCodigo() + "/" + labSistema.getUniStCodigo().getUniStCodigo());
                listRetornoStatus = EcosistemasSqlDao.grabRegistosStatus(labSistema.getUniStCodigo().getUniStCodigo(), SqlStatic.NOVACOLETA, "DEFAULT");

                if (listRetornoStatus != null) {

                    RepassarResultadoService service = new RepassarResultadoService();
                    RepassarResultadoServiceSoap port = service.getRepassarResultadoServiceSoap();

                    for (RetornoStatus retornoStatus : listRetornoStatus) {
                        try {
                            port.repassarResultado(retornoStatus.getUpdStCodigo(), retornoStatus.getReqStCodigoAlt(), "NC", retornoStatus.getEdpStCodigo(), "", retornoStatus.getReqStCodigo(), "");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }

                System.out.println("Lista de Sistemas/Unidade  - Cancelamento: " + labSistema.getSisStCodigo() + "/" + labSistema.getUniStCodigo().getUniStCodigo());
                listRetornoStatus = EcosistemasSqlDao.grabRegistosStatus(labSistema.getUniStCodigo().getUniStCodigo(), SqlStatic.CANCELAMENTO, "DEFAULT");

                if (listRetornoStatus != null) {

                    RepassarResultadoService service = new RepassarResultadoService();
                    RepassarResultadoServiceSoap port = service.getRepassarResultadoServiceSoap();

                    for (RetornoStatus retornoStatus : listRetornoStatus) {
                        try {
                            port.repassarResultado(retornoStatus.getUpdStCodigo(), retornoStatus.getReqStCodigoAlt(), "CA", retornoStatus.getEdpStCodigo(), "", retornoStatus.getReqStCodigo(), "");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }

                System.out.println("Lista de Sistemas/Unidade  - Cancelamento: " + labSistema.getSisStCodigo() + "/" + labSistema.getUniStCodigo().getUniStCodigo());
                listRetornoStatus = EcosistemasSqlDao.grabRegistosStatus(labSistema.getUniStCodigo().getUniStCodigo(), SqlStatic.RESULTADO, "DEFAULT");

                if (listRetornoStatus != null) {

                    RepassarResultadoService service = new RepassarResultadoService();
                    RepassarResultadoServiceSoap port = service.getRepassarResultadoServiceSoap();

                    for (RetornoStatus retornoStatus : listRetornoStatus) {
                        try {
                            
                            if(retornoStatus.getDerInFlag().intValue() > 1){
                                port.repassarResultado(retornoStatus.getUpdStCodigo(), retornoStatus.getReqStCodigoAlt(), "LA", retornoStatus.getEdpStCodigo(), "", retornoStatus.getReqStCodigo(), 
                                        "http://tmlab11.dasa.com.br/cgi/tmlabcgi.exe?req="+retornoStatus.getReqStCodigo()+"&senha="+criaSenha(retornoStatus.getReqStCodigo()));
                            } else{
                                port.repassarResultado(retornoStatus.getUpdStCodigo(), retornoStatus.getReqStCodigoAlt(), "AL", retornoStatus.getEdpStCodigo(), "", retornoStatus.getReqStCodigo(),
                                        "http://tmlab11.dasa.com.br/cgi/tmlabcgi.exe?req="+retornoStatus.getReqStCodigo()+"&senha="+criaSenha(retornoStatus.getReqStCodigo()));
                            }
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }
            }
        }

        List<RetornoStatus> listRetornoStatus = new ArrayList<RetornoStatus>();
    }

    public String criaSenha(String reqStCodigo) {
        
        String inverte = reqStCodigo.substring(4, 5);
        inverte = inverte + reqStCodigo.substring(3, 4);
        inverte = inverte + reqStCodigo.substring(2, 3);
        inverte = inverte + reqStCodigo.substring(1, 2);
        inverte = inverte + reqStCodigo.substring(0, 1);
        
        Integer i = new Integer(inverte);
        Integer s = new Integer(reqStCodigo.substring(5,10));
        
        Integer total = i + s;
        return total.toString();
    }
    
}

