/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Net;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;

/**
 *
 * @author Rin's
 */
public class ServerChat extends javax.swing.JFrame {

    /**
     * Creates new form ServerChat
     */
    
    ServerSocket toServer;
    Socket toClient;
    DataInputStream dis; //read data from client
    DataOutputStream dos; // output to client
    ServerThread st;
    DefaultListModel<String> lstModel;
    
    class ServerThread extends Thread {
        public ServerThread() {
            try {
                //open port number 3000
                toServer = new ServerSocket(3000);
                txtArea.setText("Server is running...\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //out put to client
        public void send() {
            try {
                dos = new DataOutputStream(toClient.getOutputStream());
                String s = txtField.getText();
                txtArea.append("ME: " + s  + "\n");
                dos.writeUTF(s);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
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
                    
//                    lstModel.addElement(toClient);
                    
                    String s = dis.readUTF();
                    if (s != null) {
                        txtArea.append(clientName + ": " + s + "\n");
                        // if s is date then get current dat
                        System.out.println(s);
                        if (s.startsWith("char -n")) {
                            String s1 = s.substring(7, s.length()).trim();
                            String[] r = s1.split("\\s+");
                            dos.writeUTF("N: "+ r.length);
                        } else if (s.startsWith("char -d")) {
                            int count = 0;
                            String s1 = s.substring(7, s.length()).trim();
                            
                            HashMap<Character, Integer> map = new HashMap<>();
                            
                            for (int i = 0; i < s1.length(); i++) {
                                if (map.containsKey(s1.charAt(i)) && s1.charAt(i) != ' ') {
                                    map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
                                } else {
                                    map.put(s1.charAt(i),1);
                                }
                            }
                            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                                if (entry.getValue() > 1) {
                                    count ++;
                                }
                            }
                            
                            dos.writeUTF("D: " + count);
                        } else if (s.startsWith("char -s")) {
                            String s1 = s.substring(7, s.length()).trim();
                            String s2 = removeSpace(s1);
                            dos.writeUTF("S: " + toUpper(s2));
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
    
    public ServerChat() {
        initComponents();
        
        lstModel = new DefaultListModel<>();
        lstClient.setModel(lstModel);
        lstClient.setSelectedIndex(0);
        
        st = new ServerThread();
        st.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClient = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        txtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldKeyPressed(evt);
            }
        });

        jScrollPane2.setViewportView(lstClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtField, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            st.send();
            txtField.setText("");
        }
    }//GEN-LAST:event_txtFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstClient;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}
