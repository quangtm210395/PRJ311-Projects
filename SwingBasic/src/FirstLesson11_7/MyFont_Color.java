package FirstLesson11_7;


import java.awt.Color;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rin's
 */
public class MyFont_Color extends javax.swing.JFrame {

    /**
     * Creates new form MyFont_Color
     */
    class ColorThread implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    lbText.setForeground(Color.BLACK);
                    Thread.sleep(500);
                    lbText.setForeground(Color.RED);
                    Thread.sleep(500);
                    lbText.setForeground(Color.BLUE);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    class FontThread implements Runnable {

        @Override
        public void run() {
            Font lbFont = lbText.getFont();
            
            int size = lbFont.getSize();
            System.out.println(size);
            try {
                while (true) {
//                    lbText.setFont(new Font(lbFont.getName(), Font.PLAIN, (size + 5)));
                    
                    lbText.setFont(lbText.getFont().deriveFont((float)(lbFont.getSize() + (size += 5) % 40)));
                    
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    Thread t1 = null;
    Thread t2 = null;

    public MyFont_Color() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbText = new javax.swing.JLabel();
        btnChangeColor = new javax.swing.JButton();
        btnChangeSize = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbText.setText("Hello I'm Min");

        btnChangeColor.setText("Change Color");
        btnChangeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeColorActionPerformed(evt);
            }
        });

        btnChangeSize.setText("Change Font size");
        btnChangeSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeSizeActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnChangeColor)
                        .addGap(30, 30, 30)
                        .addComponent(btnChangeSize))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lbText)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnStop)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeColor)
                    .addComponent(btnChangeSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStop)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeColorActionPerformed
        if (t1 == null) {
            ColorThread ct = new ColorThread();
            t1 = new Thread(ct);
            t1.start();
        }
    }//GEN-LAST:event_btnChangeColorActionPerformed

    private void btnChangeSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeSizeActionPerformed
        if (t2 == null) {
            FontThread ft = new FontThread();
            t2 = new Thread(ft);
            t2.start();
        }
    }//GEN-LAST:event_btnChangeSizeActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (t1 != null) {
            t1.interrupt();
            t1 = null;
        }
        if (t2 != null) {
            t2.interrupt();
            t2 = null;
        }
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
            java.util.logging.Logger.getLogger(MyFont_Color.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFont_Color.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFont_Color.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFont_Color.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFont_Color().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeColor;
    private javax.swing.JButton btnChangeSize;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel lbText;
    // End of variables declaration//GEN-END:variables
}