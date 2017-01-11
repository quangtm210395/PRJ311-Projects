/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_13_7;

import static java.lang.Thread.sleep;
import java.util.Random;
import static java.lang.Thread.sleep;

/**
 *
 * @author Rin's
 */
class Store {

    private String productName;
    private boolean hasNew;

    public synchronized void put(String newProduct) {
        try {
            //wait until new msg arrives
            while(hasNew == true) {
                wait();
            }
            this.productName = newProduct;
            hasNew = true;
            notify();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    public synchronized String get() {
        try {
            while(hasNew == false) {
                wait();
            }
            hasNew = false;
            notify();
        } catch (Exception e) {
            System.out.println(e);
        }
        return productName;
    }

}

class Producer extends Thread {

    private Store myStore;
    private String[] availableProduct;

    public Producer(Store myStore, String[] availableProduct) {
        this.myStore = myStore;
        this.availableProduct = availableProduct;
    }
    //-------------------------------
    
    @Override
    public void run() {
        try {
            Random r = new Random();
            while (true) {
                String newProduct = availableProduct[r.nextInt(availableProduct.length)];
                System.out.println("New product arrived: " + newProduct);
                myStore.put(newProduct);
                sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Seller extends Thread {

    private Store myStore;

    public Seller(Store myStore) {
        this.myStore = myStore;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                String s = myStore.get();
                System.out.println("Product sold: Computer" + s);
                System.out.println("Waiting for new product!");
                sleep(1000);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //-------------------------------

}

public class MyApp {

    public static void main(String[] args) {
        //shared object
        Store myStore = new Store();
        String[] availableProduct = {"Computer", "Printer", "Laptop",
            "Tablet", "Mobile", "Scanner"};
        Producer p = new Producer(myStore, availableProduct);
        Seller s = new Seller(myStore);

        p.start();

        s.start();
    }
}
