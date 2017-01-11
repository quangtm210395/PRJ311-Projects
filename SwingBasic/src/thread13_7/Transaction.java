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
public class Transaction {
    //shared data
    public /*synchronized*/ void doTran(String tranName) {
        try {
            System.out.println("Checking account...");
            Thread.sleep(1000);
            System.out.println("Doing transaction named " + tranName);
            Thread.sleep(1500);
            System.out.println("Finishing transaction named " + tranName);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
