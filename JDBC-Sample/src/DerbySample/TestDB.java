/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbySample;

import com.entiti.ProductCode;
import com.models.DBContext;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rin's
 */
public class TestDB extends javax.swing.JFrame {

    /**
     * Creates new form TestDB
     */
    DBContext dbc = null;
    List<ProductCode> list;
    DefaultTableModel ds = null;
    
    public TestDB() {
        initComponents();
        ds = new DefaultTableModel();
        jTable1.setModel(ds);
        ds.addColumn("Product_Dode");
        ds.addColumn("Discount_Dode");
        ds.addColumn("Description");
        
        try {
            // TODO add your handling code here:
            dbc = new DBContext();
            list = dbc.getAllProductCode();
            for (ProductCode productCode : list) {
                ds.addRow(productCode.toObject());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    int i = jTable1.getSelectedRow();
                    int total = jTable1.getRowCount();
                    if (i >=0 && i < total) {
                        String pCode = ds.getValueAt(i, 0).toString();
                        String dCode = ds.getValueAt(i, 1).toString();
                        String desc = ds.getValueAt(i, 2).toString();
                        txtpCodeUpd.setText(pCode);
                        txtdCodeUpd.setText(dCode);
                        txtDescUpd.setText(desc);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblpCode = new javax.swing.JLabel();
        txtpCode = new javax.swing.JTextField();
        lbldCode = new javax.swing.JLabel();
        txtdCode = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtDelete = new javax.swing.JTextField();
        lblDelete = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtpCodeUpd = new javax.swing.JTextField();
        txtdCodeUpd = new javax.swing.JTextField();
        txtDescUpd = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblSearch.setText("Enter P_Code");

        lblpCode.setText("Enter pCode");

        lbldCode.setText("Enter dCode");

        lblDesc.setText("Enter description");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblDelete.setText("Enter pCode to delete");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setText("pCode");

        jLabel2.setText("dCode");

        jLabel3.setText("Desc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnLoad))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblpCode)
                                    .addComponent(lbldCode)
                                    .addComponent(lblDesc)
                                    .addComponent(lblDelete))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(txtpCode)
                                    .addComponent(txtdCode)
                                    .addComponent(txtDesc))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDelete)
                                    .addComponent(btnAdd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtpCodeUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDescUpd)
                                        .addComponent(txtdCodeUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65)
                                .addComponent(btnUpdate)))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(lblSearch))
                .addGap(18, 18, 18)
                .addComponent(btnLoad)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpCode)
                    .addComponent(txtpCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldCode)
                    .addComponent(txtdCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesc)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDelete)
                    .addComponent(btnDelete))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpCodeUpd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdCodeUpd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescUpd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        ds.setRowCount(0);
        String txt = txtSearch.getText();
        List<ProductCode> l = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            l = db.getProductCodeByCode(txt);
            for (ProductCode productCode : l) {
                ds.addRow(productCode.toObject());
            }
        } catch (Exception ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String name = txtSearch.getText();
            List<ProductCode> l = new ArrayList<>();
            ds.setRowCount(0);
            for (ProductCode proC : list) {
                if (proC.getpCode().contains(name.toUpperCase())) {
                    l.add(proC);
                    ds.addRow(proC.toObject());
                }
            }
            if (l.isEmpty()) {
                for (ProductCode proC : list) {
                    ds.addRow(proC.toObject());
                }
            }
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        ds.setRowCount(0);
        try {
            // TODO add your handling code here:
            dbc = new DBContext();
            list = dbc.getAllProductCode();
            for (ProductCode productCode : list) {
                ds.addRow(productCode.toObject());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private boolean isExisted(ProductCode s) {
        for (ProductCode a1 : list) {
            if (a1.getpCode().equals(s.getpCode())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isExisted(String pCode) {
        for (ProductCode a1 : list) {
            if (a1.getpCode().equals(pCode)) {
                return true;
            }
        }
        return false;
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            DBContext db = new DBContext();
            ProductCode p = new ProductCode(txtpCode.getText(), txtdCode.getText(), txtDesc.getText());
            if (isExisted(p)) {
                JOptionPane.showMessageDialog(this, "This pCode existed!");
            } else {
                boolean check = db.addNewProductCode(p);
                if (check) {
                    ds.setRowCount(0);
                    try {
                        // TODO add your handling code here:
                        dbc = new DBContext();
                        list = dbc.getAllProductCode();
                        for (ProductCode productCode : list) {
                            ds.addRow(productCode.toObject());
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    JOptionPane.showMessageDialog(this, "Add succesful!");
                } else JOptionPane.showMessageDialog(this, "Add failed!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            DBContext db = new DBContext();
            String pCode = txtDelete.getText();
            if (isExisted(pCode)) {
                boolean check = db.deleteProductCode(pCode);
                if (check) {
                    ds.setRowCount(0);
                    try {
                        // TODO add your handling code here:
                        dbc = new DBContext();
                        list = dbc.getAllProductCode();
                        for (ProductCode productCode : list) {
                            ds.addRow(productCode.toObject());
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    JOptionPane.showMessageDialog(this, "Delete succesful!");
                } else JOptionPane.showMessageDialog(this, "Delete failed!");
            } else JOptionPane.showMessageDialog(this, "This pCode does not existed!");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        ProductCode p = new ProductCode(txtpCodeUpd.getText(), txtdCodeUpd.getText(), txtDescUpd.getText());
        try {
            DBContext db = new DBContext();
            if (isExisted(p)) {
                boolean check = db.updateProductCode(p);
                if (check) {
                    ds.setRowCount(0);
                    try {
                        // TODO add your handling code here:
                        dbc = new DBContext();
                        list = dbc.getAllProductCode();
                        for (ProductCode productCode : list) {
                            ds.addRow(productCode.toObject());
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Update succesful!");
                } else JOptionPane.showMessageDialog(this, "Update failed!");
            } else JOptionPane.showMessageDialog(this, "This pCode does not existed!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(TestDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lbldCode;
    private javax.swing.JLabel lblpCode;
    private javax.swing.JTextField txtDelete;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDescUpd;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtdCode;
    private javax.swing.JTextField txtdCodeUpd;
    private javax.swing.JTextField txtpCode;
    private javax.swing.JTextField txtpCodeUpd;
    // End of variables declaration//GEN-END:variables
}
