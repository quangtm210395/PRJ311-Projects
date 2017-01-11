/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread13_7;

/**
 *
 * @author Rin's
 */
public class TransactionThread extends Thread{
    String tranName;
    Transaction t;

    public TransactionThread(String tranName, Transaction t) {
        this.tranName = tranName;
        this.t = t;
    }
    
    //thread schedule
    @Override
    public void run() {
        synchronized(t){
            t.doTran(tranName);
        }
        //code here will not be synchronized
    }
    
    
}
