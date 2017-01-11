/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotePad;

import java.awt.event.KeyEvent;

/**
 *
 * @author Rin's
 */
public class ReplaceDialog extends javax.swing.JDialog {
    Main md;
    int idx;
    
    /**
     * Creates new form FindDialog
     */
    public ReplaceDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Find");
        setResizable(false);
        
        idx = 0;
        md = (Main)parent;
        setLocation(md.getX()+50, md.getY() +50);
    }
    
    void replace(String in, String out, int i) {
        String temp = md.txtArea.getText();
        String output;
        output = temp.substring(0, i) + out + temp.substring(i + in.length(), temp.length());
        md.txtArea.setText(output);
    }

    int findIndex(int idx, String in, boolean isCase) {
        String source = md.txtArea.getText();
        for (int i = idx; i < source.length(); i++) {
            if (isCase) {
                if (source.substring(i, i + in.length()).equals(in)) {
                    return i;
                }
            } else {
                if (source.substring(i, i + in.length()).equalsIgnoreCase(in)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFind = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnReplace = new javax.swing.JButton();
        btnReplaceAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtReplace = new javax.swing.JTextField();
        ckbMatchcase = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblFind.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblFind.setText("Find what");

        txtFind.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        btnFind.setText("Find next");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnReplace.setText("Replace");
        btnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplaceActionPerformed(evt);
            }
        });

        btnReplaceAll.setText("Replace all");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel1.setText("Replace with");

        txtReplace.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        ckbMatchcase.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        ckbMatchcase.setText("Match case");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(txtReplace, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ckbMatchcase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReplace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReplaceAll, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblFind))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReplace)
                    .addComponent(jLabel1)
                    .addComponent(txtReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReplaceAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(ckbMatchcase))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String in = txtFind.getText();
            if (!in.equals("")) {
                int ind = (ckbMatchcase.isSelected())? findIndex(idx, in, true) : findIndex(idx, in, false);
                if (ind != -1) {
                    md.txtArea.setSelectionStart(ind);
                    md.txtArea.setSelectionEnd(ind + in.length());
                    idx = ind+1;
                }
            }
        }
    }//GEN-LAST:event_txtFindKeyPressed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String in = txtFind.getText();
        if (!in.equals("")) {
            int ind = (ckbMatchcase.isSelected())? findIndex(idx, in, true) : findIndex(idx, in, false);
            if (ind != -1) {
                md.txtArea.setSelectionStart(ind);
                md.txtArea.setSelectionEnd(ind + in.length());
                idx = ind+1;
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplaceActionPerformed
        // TODO add your handling code here:
        if (idx != 0) idx--;
        String in = txtFind.getText();
        if (!in.equals("")) {
            int ind = (ckbMatchcase.isSelected())? findIndex(idx, in, true) : findIndex(idx, in, false);
            if (ind != -1) {
                replace(in, txtReplace.getText(), ind);
                md.txtArea.setSelectionStart(ind);
                md.txtArea.setSelectionEnd(ind + in.length());
                idx = ind;
            }
        }
    }//GEN-LAST:event_btnReplaceActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReplaceDialog dialog = new ReplaceDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnReplace;
    private javax.swing.JButton btnReplaceAll;
    private javax.swing.JCheckBox ckbMatchcase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFind;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtReplace;
    // End of variables declaration//GEN-END:variables
}