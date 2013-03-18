/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

import br.com.dasa.wsecosistemasclient.ThreadsEcosistema;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.logging.*;


/**
 *
 * @author eros
 */
public class Launcher {
    
     
    public static void main(String[] args) {
        
        try {
            logOneMoreLine(3, "Iniciado o processo de envio de Status para Ecosistemas - Klinicos");
            new ThreadsEcosistema();
        } catch (Exception xcp) {
            logOneMoreLine(1,xcp.getMessage());
            xcp.printStackTrace();
        }
        
    }
    
    /**
    * 
    * @param status
    * @param msg 
    * @return   0 = FATAL | 1 = SEVERE | 2 = WARNING | 3 = INFO
    */
    public static void logOneMoreLine(int status,String msg) {
      String strStatus = "INFO            ";
        switch (status) {
            case 0:
                strStatus = "FATAL          ";
                break;
            case 1:
                strStatus = "SEVERE         ";
                break;
            case 2:
                strStatus = "WARNING    ";
                break;
            case 3:
                strStatus = "INFO            ";
                break;
            default:
                strStatus = "je ne c'est pas    ";
        }
    }
}
