/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Rin's
 */
public class Main {
    public static void main(String[] args) {
        try {
            String path = "http://stackoverflow.com/questions/12772821/how-to-implement-undo-redo-in-java-for-mvc-model";
            URL u = new URL(path);
            //read information of url path
            System.out.println("Host: " + u.getHost());
            System.out.println("Protocol: " + u.getProtocol());
            System.out.println("Query: " + u.getQuery());
            System.out.println("File: " + u.getFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
            String s = "";
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
