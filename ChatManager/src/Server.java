
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DuyDT
 */
public class Server extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    DataInputStream dis = null;
    DataOutputStream dos = null;
    
    ServerSocket ser = null;
    Socket [] sockets = new Socket[10];
    int n = 0;
    ServerThread[] st = new ServerThread[10];
    
    class ServerThread extends Thread{
        Socket client = null;    
        int stt = 0;
        boolean isRunning =false;
        public ServerThread(Socket client, int stt) {
            try{
                this.stt = stt;
                this.client = client;
                this.isRunning = true;
//                s[n] = this.client;                
//                t.addElement("Client " + n);
//                n++;
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public void send() {
            try{
                Socket sk = client;
                String name = t.get(stt);
                dos = new DataOutputStream(sk.getOutputStream());
                if (cd[stt] != null) {
                    if (!cd[stt].txtTypeChat.getText().equals("")) {
                        dos.writeUTF(cd[stt].txtTypeChat.getText() );
                        cd[stt].txtArea.append("Me: " + cd[stt].txtTypeChat.getText() + "\n");
                        txtArea.append("Me -> " +name +": " + cd[stt].txtTypeChat.getText() + "\n");
                    }
                } 
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        
        @Override
        public void run() {
            try{ 
                while(true) {
                    dis = new DataInputStream(client.getInputStream());
                    String s = dis.readUTF();
                    String name = t.get(stt);
                    if(s != null) {
                        txtArea.append(name + ": " + s + "\n");
                        if (cd[stt] != null) {
                            cd[stt].txtArea.append(name + ": " + s +"\n");
                        }
                    }
                    //dis.close();
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    class StartThread extends Thread {

        public void send() {
            try{
                int i = lstClient.getSelectedIndex();
                Socket sk = sockets[i>=0?i:0];
                String name = t.get(i);
                dos = new DataOutputStream(sk.getOutputStream());
                if (!txtTypeChat.getText().equals("")) {
                    dos.writeUTF(txtTypeChat.getText() );
                    txtArea.append("Me -> " +name +": " + txtTypeChat.getText() + "\n");
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        @Override
        public void run() {
           try{
            ser = new ServerSocket(2000);
            while(true){
//                c = new ServerThread(ser.accept());
                sockets[n] = ser.accept();
                dis = new DataInputStream(sockets[n].getInputStream());
                String s = dis.readUTF();
                if (s != null) {
                    t.addElement(s);
                } else t.addElement("Client " + n);
                st[n] = new ServerThread(sockets[n], n);
                st[n].start();
                n++;
                
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }        
    }
    
    ServerThread c = null;
    DefaultListModel<String> t =  new DefaultListModel<>();
    ChatDialog[] cd = new ChatDialog[10];
    StartThread mainthread = null;
    
    public Server() {
        initComponents();
        lstClient.setModel(t);
        setTitle("Chat Manager");
        mainthread = new StartThread();
        mainthread.start();
        txtArea.setText("Server is ready now\n");
        setResizable(false);
      //init();
      
        lstClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    
                    int index = lstClient.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        System.out.println(st[index]);
//                        if (st[index] != null && st[index].isRunning == true) {
//                            st[index].start();
//                        } else 
                            if (st[index].isRunning == false) {
                            st[index].resume();
                        }
                        String name = t.get(index);
                        cd[index] = new ChatDialog(Server.this, false);
                        cd[index].index = index;
                        cd[index].setTitle("Chat with "+name);
                        cd[index].lblName.setText(name);
                        cd[index].setVisible(true);
                    }
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClient = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtTypeChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Online now", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        lstClient.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(lstClient);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quick chat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        txtTypeChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTypeChatKeyPressed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtTypeChat, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTypeChat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if (!txtTypeChat.getText().equals("")) {
            mainthread.send();
            txtTypeChat.setText("");
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtTypeChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeChatKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtTypeChat.getText().equals("")) {
                mainthread.send();
                txtTypeChat.setText("");
            }
        }
    }//GEN-LAST:event_txtTypeChatKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    javax.swing.JList lstClient;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtTypeChat;
    // End of variables declaration//GEN-END:variables
}
