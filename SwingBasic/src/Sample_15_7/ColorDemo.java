/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample_15_7;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rin's
 */
public class ColorDemo extends javax.swing.JFrame {

    /**
     * Creates new form ColorDemo
     */
    List<String> listColor = null;
    List<Color> arr = null;
    
    class ThreadChange extends Thread {

        @Override
        public void run() {
            if (arr == null) {
                arr = new ArrayList<>();
            }
            if (listColor == null) {
                listColor = lstColor.getSelectedValuesList();
            }
            System.out.println(listColor);
            for (String listColor1 : listColor) {
                Color color;
                try {
                    Field field = Class.forName("java.awt.Color").getField(listColor1.toLowerCase());
                    color = (Color) field.get(null);
                } catch (Exception e) {
                    color = null; // Not defined
                }
                arr.add(color);
            }
            try {
                while (true) {
                    if (arr.size() > 0) {
//                        for (int i = 0; i < arr.size(); i++) {
//                            lblCode.setForeground(arr.get(i));
//                            sleep(500);
//                        }
                        int i = 0;
                        while(true) {
                            lblCode.setForeground(arr.get(i%arr.size()));
                            sleep(500);
                            i++;
                            if (i >= arr.size()) {
                                i = 0;
                            }
                        }
                    } else {
                        lblCode.setForeground(Color.CYAN);
                        sleep(500);
                        lblCode.setForeground(Color.BLACK);
                        sleep(500);
                    }

                }

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    public ColorDemo() {
        initComponents();
//        arrBtn.add(ckbRed);
//        arrBtn.add(ckbBlue);
//        arrBtn.add(ckbGreen);
//        arrBtn.add(ckbBlack);
//        arrBtn.add(ckbWhite);
//        arrBtn.add(ckbPink);

//        Color c = Color.decode(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRun = new javax.swing.JButton();
        lblCode = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstColor = new javax.swing.JList<>();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        lblCode.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCode.setText("Color");

        lstColor.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Red", "Blue", "Green", "Black", "White", "Pink" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstColor);

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(lblCode)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btnRun)
                .addGap(28, 28, 28)
                .addComponent(btnStop)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblCode))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRun)
                    .addComponent(btnStop))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        ThreadChange tc = null;
    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        if (tc != null) {
            listColor = null;
            arr = null;
            tc.interrupt();
        }
        tc = null;
        if (tc == null) {
            tc = new ThreadChange();
            tc.start();
        }
        
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (tc != null) {
            listColor = null;
            arr = null;
            tc.interrupt();
        }
        tc = null;
    }//GEN-LAST:event_btnStopActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColorDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnStop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JList<String> lstColor;
    // End of variables declaration//GEN-END:variables
}
