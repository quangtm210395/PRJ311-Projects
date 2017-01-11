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
public class ConsumerThread  extends Thread {
    MyInbox mi;

    public ConsumerThread(MyInbox mi) {
        this.mi = mi;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String s = mi.consume();
                System.out.println("Reading msg " + s);
                sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
