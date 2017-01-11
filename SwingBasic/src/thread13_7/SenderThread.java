/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread13_7;

import java.util.Random;

/**
 *
 * @author Rin's
 */
public class SenderThread extends Thread {

    MyInbox mi;

    public SenderThread(MyInbox mi) {
        this.mi = mi;
    }

    @Override
    public void  run() {
        try {
            String[] s = {"xin chao", "chao", "hello", "ciao", "hi"};
            Random r = new Random();
            while (true) {
                String msg = s[r.nextInt(s.length)];
                mi.receive(msg);
                System.out.println("Receiving msg " + msg);
                sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
