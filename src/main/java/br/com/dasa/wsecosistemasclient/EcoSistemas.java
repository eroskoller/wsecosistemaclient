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
                        }

                    }
                }

            }
        }

        List<RetornoStatus> listRetornoStatus = new ArrayList<RetornoStatus>();
    }
    
}

