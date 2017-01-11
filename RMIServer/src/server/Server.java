/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import RemoteLib.ServiceImp;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Rin's
 */
public class Server {
    public static void main(String[] args) {
        try {
            //create remote object and bind to server with url
            ServiceImp si = new ServiceImp();
            LocateRegistry.createRegistry(1099);
            String url = "rmi://localhost/MyService";
            //bind url to server
            Naming.rebind(url, si);
            System.out.println("Service is ready...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
