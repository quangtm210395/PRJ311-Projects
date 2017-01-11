/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteLib;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Rin's
 */
public class ServiceImp extends UnicastRemoteObject
        implements IService {

    public ServiceImp() throws RemoteException {
        
    }
    
    @Override
    public Weather getWeather(String city) throws RemoteException {
        //collect and process data
        return new Weather("27", "80", "20");
    }

    private final double RATE = 22.8; // usd = vnd
    
    @Override
    public double toVND(double usd) throws RemoteException {
        return usd * RATE;
    }

    @Override
    public double convert(double vnd, String currency) throws RemoteException {
        double rate = 0;
        if (currency.equalsIgnoreCase("USD")) {
            rate = 21000;
        }
        if (currency.equalsIgnoreCase("EUR")) {
            rate = 23000;
        }
        if (currency.equalsIgnoreCase("INR")) {
            rate = 15000;
        }
        return vnd / rate;
    }
    
    
    
}
