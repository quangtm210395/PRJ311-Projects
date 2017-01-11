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
public class Main {
    public static void main(String[] args) {
        MyInbox mi = new MyInbox();
        ConsumerThread ct = new ConsumerThread(mi);
        SenderThread st = new SenderThread(mi);
        ct.start();
        st.start();
    }
}
