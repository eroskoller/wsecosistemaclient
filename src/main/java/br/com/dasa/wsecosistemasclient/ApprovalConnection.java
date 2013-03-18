/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dasa.wsecosistemasclient;

/**
 *
 * @author eros
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.dasa.wsecosistemasclient.Launcher;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class ApprovalConnection {

    public static boolean getConnectionApproval(String url) throws NoRouteToHostException,ConnectException, UnknownHostException, IOException{

        boolean blRortno = false;
//        URL urlObj;

//        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//        while (interfaces.hasMoreElements()) {
//            NetworkInterface interf = interfaces.nextElement();
//            if (interf.isUp() && !interf.isLoopback()) {
//                System.out.println(interf.getDisplayName());
//                blRortno = true;
//                break;
//            }else{
//                Launcher.grabLoger().severe("Servidor não tem network interface..............");
//            }
//        }
        
        
//        if ("127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())) {
//            blRortno = true;
//            System.out.println("trying ping 127.0.0.1.....................");
//        }else{
//            blRortno = false;
//        }
//        InetAddress inetAddress = InetAddress.getByName(url);
//        if (inetAddress.isReachable(10000)) {
//            blRortno = true;
//            System.out.println("reaching "+url+" .....................");
//        }else{
//            blRortno = false;
//        }

        
        URL u = new URL(url);
        
        try {
            HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
            huc.setRequestMethod("GET"); 
            huc.connect();
            if (huc.getResponseCode() == 200) {
                blRortno = true;
            } else {
                blRortno = false;
//            System.out.println("WebService  ' "+url+" '  out of order..........");
//                Launcher.grabLoger().severe("WebService  ' " + url + " '  out of order..........");
                Launcher.logOneMoreLine(3,"WebService  ' " + url + " '  out of order..........");
            }
        } catch (UnknownHostException xcp) {
            blRortno = false;
//            System.out.println("WebService  ' "+url+" '  out of order..........");
//            Launcher.grabLoger().severe(xcp.getMessage());
            Launcher.logOneMoreLine(3,xcp.getMessage());
        }catch (IOException xcp) {
            blRortno = false;
//            System.out.println("WebService  ' "+url+" '  out of order..........");
//            Launcher.grabLoger().severe(xcp.getMessage());
            Launcher.logOneMoreLine(3,xcp.getMessage());
        }
        
        
        
//        try {
//
//
//            try {
////                address = InetAddress.getByName("74.125.234.208");
//
////             if(address.isReachable(5000)){
//                if ("127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())) {
////                 final URL url = new URL("http://www.google.com");
////                final URLConnection conn = url.openConnection();
////                 conn.getDoOutput()
//                    InetAddress address = InetAddress.getByName("74.125.234.208");
//                    if (address.isReachable(10000)) {
//                        //                        address = InetAddress.getByName(url);
////                         if(conn.getDoOutput()){
////                        urlObj = new URL(url);
////                        URLConnection conn = urlObj.openConnection();
////                        conn.setConnectTimeout(1000);
////                        conn.setReadTimeout(1000);
////                        InputStream in = conn.getInputStream();
////                        BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream()));
//
//                        return true;
//                    } else {
//                        System.out.println("Server is not online............");
//                        return false;
//                    }
//
//
//                } else {
//                    System.out.println("System Is NOT Online Or behinde firewall............");
//                    return false;
//                }
//
//
//            } catch (IOException xcp) {
//                System.out.println("O Host nao estah acessivel.................");
//                System.out.println(xcp);
//                return false;
//            }
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return blRortno;  //TODO APPROVAL
//        return true;
    }
}//end

