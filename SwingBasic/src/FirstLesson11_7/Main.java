package FirstLesson11_7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rin's
 */
public class Main {
    public static void main(String[] args) {
        //main thread
        System.out.println("Hello, this is main thread");
        //create 2 sub thread
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        //change name of mt1 and mt2
        mt1.setName("Blue");
        mt2.setName("Green");
        //start mt1, mt2 = execute thread's schedule
        mt1.setDaemon(true);
        mt1.start();
        mt1.setPriority(7);
        mt2.start();
        //thread priority
        System.out.println("Information of mt1: " + mt1);
        System.out.println("Information of mt2: " + mt2);
        // set thread to "ngam"
        
        
        while(mt1.isAlive() == true || mt2.isAlive() == true){
            // print out mt1's status
            ;
//            System.out.println(mt1.getState()); 
        }
            
        System.out.println("End of program");
        
    }
}

