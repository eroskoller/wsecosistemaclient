/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import br.com.dasa.wsecosistemasclient.Launcher;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Naves
 */
public class ThreadsEcosistema implements  Runnable{

    public ThreadsEcosistema() {
        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        
        while (true) {            
            try {
                try {
//                    if (ApprovalConnection.getConnectionApproval("http://aplicgestao4.saude.rj.gov.br/UPAServicesRetornoLabHML/WebService/RepassarResultadoService.asmx")) {
                    if (ApprovalConnection.getConnectionApproval("http://www.dasa.com.br")) {
                        EcoSistemas ecoSistemas = new EcoSistemas();
                        ecoSistemas.sendToEcosistemas();
                        Thread.sleep(2000L);
                        
                    } else {
                        Launcher.logOneMoreLine(1, "Computador fora da internet ou servidor inacessÃ­vel");
                        Thread.sleep(200000L);
                    }
                } catch (NoRouteToHostException xcp) {
                    Launcher.logOneMoreLine(0, xcp.getMessage());
                    xcp.printStackTrace();
                } catch (ConnectException xcp) {
                    Launcher.logOneMoreLine(0, xcp.getMessage());
                    xcp.printStackTrace();
                } catch (UnknownHostException xcp) {
                    Launcher.logOneMoreLine(0, xcp.getMessage());
                    xcp.printStackTrace();
                } catch (IOException xcp) {
                    Launcher.logOneMoreLine(0, xcp.getMessage());
                    xcp.printStackTrace();
                }
            } catch (InterruptedException xcp) {
                    Launcher.logOneMoreLine(0, xcp.getMessage());
                    xcp.printStackTrace();
            }
        }
        
    }        
    
    public static void main (String[] args){
        
        ThreadsEcosistema ecosistema = new ThreadsEcosistema();
        
        
    }
    
}
