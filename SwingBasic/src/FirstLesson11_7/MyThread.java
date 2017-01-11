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
public class MyThread extends Thread{
    
    //thread's schedule
    @Override
    public void run() {
        for(int i =1; i <= 5; i++){
            try {
                System.out.println("This is " + getName());
                sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
    
    
    
}
