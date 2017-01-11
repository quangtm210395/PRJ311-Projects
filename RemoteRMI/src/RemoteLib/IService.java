/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteLib;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rin's
 */
public interface IService extends Remote{
    // every services  must throw RemoteException
    public Weather getWeather(String city) throws RemoteException;
    
    public double toVND(double usd) throws RemoteException;
    
    public double convert(double vnd, String currency) throws RemoteException;
    
}
