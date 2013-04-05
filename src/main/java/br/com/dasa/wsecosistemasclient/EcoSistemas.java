/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import br.com.dasa.hibernate.entities.LabSistema;
import br.com.dasa.hibernate.utils.OracleHelper;
import java.net.ConnectException;
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

        System.out.println("Buscando informações....");
        List<RetornoStatus> listRetornoStatus = EcosistemasSqlDao.grabRegistosStatus("DEFAULT");

        if (listRetornoStatus != null) {
            RepassarResultadoService service = new RepassarResultadoService();
            RepassarResultadoServiceSoap port = service.getRepassarResultadoServiceSoap();

            for (RetornoStatus retornoStatus : listRetornoStatus) {
                String laudo = "";
                System.out.println("requisicao: " + retornoStatus.getReqStCodigo());

                if (retornoStatus.getLegStCodigo().equals("002") && retornoStatus.getDerChStatusIntegracao().intValue() == 0) {
                    retornoStatus.setTipoRetorno("PL");
                    retornoStatus.setSucesso(true);
                }
                if ((retornoStatus.getLegStCodigo().equals("003") || retornoStatus.getLegStCodigo().equals("004"))
                        && retornoStatus.getDerChStatusIntegracao().intValue() == 0) {
                    retornoStatus.setTipoRetorno("EA");
                    retornoStatus.setSucesso(true);
                }
                if (retornoStatus.getLegStCodigo().equals("013") && (retornoStatus.getDerChStatusIntegracao().intValue() == 0 || retornoStatus.getDerChStatusIntegracao().intValue() == 1)) {
                    retornoStatus.setTipoRetorno("CA");
                    retornoStatus.setSucesso(true);
                }
                if (retornoStatus.getLegStCodigo().equals("020") && (retornoStatus.getDerChStatusIntegracao().intValue() == 0 || retornoStatus.getDerChStatusIntegracao().intValue() == 1)) {
                    retornoStatus.setTipoRetorno("NC");
                    retornoStatus.setSucesso(true);
                }
                if (retornoStatus.getLegStCodigo().equals("011") || retornoStatus.getLegStCodigo().equals("016")) {
                    laudo = "http://tmlab11.dasa.com.br/cgi/tmlabcgi.exe?req=" + retornoStatus.getReqStCodigo() + "&senha=" + criaSenha(retornoStatus.getReqStCodigo());

                    if (retornoStatus.getDerInFlag().intValue() > 1) {
                        retornoStatus.setTipoRetorno("LA");
                        retornoStatus.setSucesso(true);
                    } else {
                        retornoStatus.setTipoRetorno("AL");
                        retornoStatus.setSucesso(true);
                    }
                }
                System.out.println("laudo: " + laudo);
                System.out.println("Situacao: " + retornoStatus.getTipoRetorno());

                if (!retornoStatus.getTipoRetorno().equals("PL")) {
                    try {
                        port.repassarResultado(retornoStatus.getUpdStCodigo(), retornoStatus.getReqStCodigoAlt(), retornoStatus.getTipoRetorno(), retornoStatus.getEdpStCodigo(), "", retornoStatus.getReqStCodigo(), laudo);
                    } catch (Exception ex) {
                        retornoStatus.setSucesso(false);
                        ex.printStackTrace();
                    }
                }
                
                EcosistemasSqlDao.updateEnviados(retornoStatus);
            }
        }
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

