/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import RemoteLib.IService;
import RemoteLib.Weather;
import java.rmi.Naming;

/**
 *
 * @author Rin's
 */
public class Client {
    public static void main(String[] args) {
        try {
            IService is = null;
            //look up service named 
            String url = "rmi://localhost/MyService";
            is = (IService)Naming.lookup(url);
            //print out result
            Weather w = is.getWeather("HAN");
            System.out.println("Weather.Degree: " + w.getDegree());
            System.out.println("Weather.Humidity: " + w.getHumidity());
            System.out.println("120 usd in vnd = " + is.toVND(120));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
