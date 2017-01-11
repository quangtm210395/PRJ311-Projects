/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_18_7;

import com.entity.MyFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.KeyStroke;

/**
 *
 * @author Rin's
 */
public class FontChooseDialog extends javax.swing.JDialog {

    private MyFont mf = null;
    String[] fontFamilies = null;
    String[] fontStyle = {"Plain", "Bold", "Italic", "Bold Italic"};
    String[] fontSize = null;
    MenuDemo md;

    /**
     * Creates new form FontChooseDialog
     */
    public FontChooseDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        md = (MenuDemo) parent;
        loadFonts();

//        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
//        InputMap im = vertical.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        im.put(KeyStroke.getKeyStroke("DOWN"), "positiveUnitIncrement");
//        im.put(KeyStroke.getKeyStroke("UP"), "negativeUnitIncrement");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void loadFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontFamilies = ge.getAvailableFontFamilyNames();
        lstFont.setListData(fontFamilies);
        lstFont.setSelectionBackground(Color.CYAN);
        lstStyle.setListData(fontStyle);
        lstStyle.setSelectionBackground(Color.CYAN);
        fontSize = new String[34];
        for (int i = 0; i < 34; i++) {
            fontSize[i] = (8 + 2 * i) + "";
        }
        lstSize.setListData(fontSize);
        lstSize.setSelectionBackground(Color.CYAN);

        MyFont mf1 = md.getFonts();
        txtFont.setText(fontFamilies[mf1.getFont()]);
        lstFont.setSelectedIndex(mf1.getFont());
        txtStyle.setText(fontStyle[mf1.getStyle()]);
        lstStyle.setSelectedIndex(mf1.getStyle());
        txtSize.setText(mf1.getSize() + "");
        lstSize.setSelectedIndex((mf1.getSize() - 8) / 2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFont = new javax.swing.JLabel();
        lblStyle = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        txtFont = new javax.swing.JTextField();
        txtStyle = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtPreview = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFont = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstStyle = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSize = new javax.swing.JList<>();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose a Font"));

        lblFont.setText("Font:");

        lblStyle.setText("Style:");

        lblSize.setText("Size:");

        txtFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFontActionPerformed(evt);
            }
        });
        txtFont.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFontKeyReleased(evt);
            }
        });

        txtStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStyleActionPerformed(evt);
            }
        });
        txtStyle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStyleKeyReleased(evt);
            }
        });

        txtSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSizeActionPerformed(evt);
            }
        });
        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSizeKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));

        txtPreview.setEditable(false);
        txtPreview.setColumns(20);
        txtPreview.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtPreview.setRows(1);
        txtPreview.setTabSize(1);
        txtPreview.setText("AaBbYyZz");
        jScrollPane4.setViewportView(txtPreview);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        lstFont.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFont.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFontValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFont);

        lstStyle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstStyle.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstStyleValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstStyle);

        lstSize.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSize.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSizeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstSize);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFont)
                            .addComponent(txtFont)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblStyle)
                                    .addGap(78, 78, 78)
                                    .addComponent(lblSize))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFont)
                    .addComponent(lblStyle)
                    .addComponent(lblSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancel))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstFontValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFontValueChanged
        // TODO add your handling code here:
        txtFont.setText(lstFont.getSelectedValue());
        txtPreview.setFont(new Font(txtFont.getText(), lstStyle.getSelectedIndex(), lstSize.getSelectedIndex() * 2 + 8));
    }//GEN-LAST:event_lstFontValueChanged

    private void lstStyleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstStyleValueChanged
        // TODO add your handling code here:
        txtStyle.setText(lstStyle.getSelectedValue());
        txtPreview.setFont(new Font(txtFont.getText(), lstStyle.getSelectedIndex(), lstSize.getSelectedIndex() * 2 + 8));
    }//GEN-LAST:event_lstStyleValueChanged

    private void lstSizeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSizeValueChanged
        // TODO add your handling code here:
        txtSize.setText(lstSize.getSelectedValue());
        txtPreview.setFont(new Font(txtFont.getText(), lstStyle.getSelectedIndex(), lstSize.getSelectedIndex() * 2 + 8));
//        txtPreview.setFont(new Font(lstFont.getSelectedValue(), lstStyle.getSelectedIndex(), lstSize.getSelectedIndex() * 2 + 8));
    }//GEN-LAST:event_lstSizeValueChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        mf = new MyFont(lstFont.getSelectedIndex(), lstStyle.getSelectedIndex(), lstSize.getSelectedIndex());
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStyleActionPerformed
        // TODO add your handling code here:
        if (txtStyle.hasFocus()) {
            for (int i = 0; i < fontStyle.length; i++) {
                if (fontStyle[i].toLowerCase().startsWith(txtStyle.getText())) {
                    lstStyle.ensureIndexIsVisible(i);
                    lstStyle.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_txtStyleActionPerformed

    private void txtFontKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFontKeyReleased
        // TODO add your handling code here:
        if (txtFont.hasFocus()) {
            for (int i = 0; i < fontFamilies.length; i++) {
                if (fontFamilies[i].toLowerCase().startsWith(txtFont.getText()) ) {
                    lstFont.ensureIndexIsVisible(i);
                }
            }
        }
    }//GEN-LAST:event_txtFontKeyReleased

    private void txtStyleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStyleKeyReleased
        // TODO add your handling code here:
        if (txtStyle.hasFocus()) {
            for (int i = 0; i < fontStyle.length; i++) {
                if (fontStyle[i].toLowerCase().startsWith(txtStyle.getText())) {
                    lstStyle.ensureIndexIsVisible(i);
                }
            }
        }
    }//GEN-LAST:event_txtStyleKeyReleased

    private void txtSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyReleased
        // TODO add your handling code here:
        if (txtSize.hasFocus()) {
            for (int i = 0; i < fontSize.length; i++) {
                if (fontSize[i].toLowerCase().startsWith(txtSize.getText())) {
                    lstSize.ensureIndexIsVisible(i);
                }
            }
        }
    }//GEN-LAST:event_txtSizeKeyReleased

    private void txtFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFontActionPerformed
        // TODO add your handling code here:
        if (txtFont.hasFocus()) {
            for (int i = 0; i < fontFamilies.length; i++) {
                if (fontFamilies[i].toLowerCase().startsWith(txtFont.getText())) {
                    lstFont.ensureIndexIsVisible(i);
                    lstFont.setSelectedIndex(i);
//                    break;
                }
            }
        }
    }//GEN-LAST:event_txtFontActionPerformed

    private void txtSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSizeActionPerformed
        // TODO add your handling code here:
        if (txtSize.hasFocus()) {
            for (int i = 0; i < fontSize.length; i++) {
                if (fontSize[i].toLowerCase().startsWith(txtSize.getText())) {
                    lstSize.ensureIndexIsVisible(i);
                    lstSize.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_txtSizeActionPerformed


    
    public MyFont getMyFont() {
        if (mf != null) {
            return mf;
        } else {
            return null;
        }

    }

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
            java.util.logging.Logger.getLogger(FontChooseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FontChooseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FontChooseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FontChooseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FontChooseDialog dialog = new FontChooseDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFont;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblStyle;
    private javax.swing.JList<String> lstFont;
    private javax.swing.JList<String> lstSize;
    private javax.swing.JList<String> lstStyle;
    private javax.swing.JTextField txtFont;
    private javax.swing.JTextArea txtPreview;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtStyle;
    // End of variables declaration//GEN-END:variables
}