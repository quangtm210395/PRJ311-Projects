/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Rin's
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    
    ServerSocket toServer;
    Socket toClient;
    DataInputStream dis; //read data from client
    DataOutputStream dos; // output to client
    ServerThread st;
    
    Server() {
        st = new ServerThread();
        st.start();
    }
    
    class ServerThread extends Thread {
        public ServerThread() {
            try {
                //open port number 3000
                toServer = new ServerSocket(3000);
                System.out.println("Server is running...\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //out put to client
//        public void send() {
//            try {
//                dos = new DataOutputStream(toClient.getOutputStream());
//                dos.writeUTF("");
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
        
        //receive data from client
        @Override
        public void run() {
            try {
                toClient = toServer.accept(); // wait clients connection
                dis = new DataInputStream(toClient.getInputStream());
                dos = new DataOutputStream(toClient.getOutputStream());
                //read information of client
                String clientName = toClient.getInetAddress().getHostName();
                while(true) {
                    String s = dis.readUTF();
                    
                    if (s != null) {
                        System.out.println(clientName + ": " + s + "\n");
                        // if s is date then get current dat
                        System.out.println(s);
                        if (s.length() <=7) {
                            dos.writeUTF("Sorry, i do not understand question \"" + s +"\"");
                        } else if (s.startsWith("list -n")) {
                            String s1 = s.substring(7, s.length()).trim();
                            String[] r = s1.split("\\s+");
                            ArrayList a = new ArrayList();
                            for (int i = 0; i < r.length; i++) {
                                try {
                                    int n = Integer.parseInt(r[i]);
                                    if (n%2!=0) {
                                        a.add(n);
                                    }
                                } catch (Exception e) {
                                }
                            }
                            dos.writeUTF("N = "+ a.size());
                        } else if (s.startsWith("list -u")) {
                            String s1 = s.substring(7, s.length()).trim();
                            String[] r = s1.split("\\s+");
                            ArrayList<Integer> a = new ArrayList<>();
                            for (int i = 0; i < r.length; i++) {
                                try {
                                    int n = Integer.parseInt(r[i]);
                                    a.add(n);
                                } catch (Exception e) {
                                }
                            }
                            
                            HashSet<Integer> b = new HashSet<>();
                            for (Integer integer : a) {
                                b.add(integer);
                            }
                            String result = a.size()==b.size()?"Yes":"No";
                            
                            dos.writeUTF("D = " + result);
                        } else {
                            dos.writeUTF("Sorry, i do not understand question \"" + s +"\"");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    String removeSpace(String s){
        s = s.trim();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == ' ' && sb.charAt(i+1) == ' ') {
                sb.replace(i, i+1, "");
                i--;
            }
        }
        return new String(sb);
    }
    
    String toUpper(String s){
        if (s.length() <= 1) {
            return s.toUpperCase();
        }
        char[] c = s.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i+1] = Character.toUpperCase(c[i+1]);
            }
        }
        s = "";
        for (int i = 0; i < c.length; i++) {
            s+= c[i];
        }
        return s;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Server();
    }
}
