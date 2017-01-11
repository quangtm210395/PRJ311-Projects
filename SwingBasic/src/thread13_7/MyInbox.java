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
public class MyInbox {
    
    //hasNew = true -> has new message
    boolean hasNew;
    String msg;
    
    public synchronized String consume() {
        try {
            while(hasNew == false) {
                wait();
            }
            hasNew = false;
            notify();
        } catch (Exception e) {
            System.out.println(e);
        }
        return msg;
    }
    
    public synchronized void receive(String msg) {
        try {
            //wait until new msg arrives
            while(hasNew == true) {
                wait();
            }
            this.msg = msg;
            hasNew = true;
            notify();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
