/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout_22_7;

import java.awt.FontMetrics;
import java.awt.TextComponent;
import java.awt.peer.TextComponentPeer;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author Rin's
 */
public class ColorPanel extends javax.swing.JPanel {

    /**
     * Creates new form ColorPanel
     */
    public ColorPanel() {
        initComponents();
        JTextArea a = new JTextArea();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblColor = new javax.swing.JLabel();
        ckbGreen = new javax.swing.JCheckBox();
        ckbRed = new javax.swing.JCheckBox();
        ckbBlue = new javax.swing.JCheckBox();

        lblColor.setText("Your favorite color is");

        buttonGroup1.add(ckbGreen);
        ckbGreen.setText("Green");

        buttonGroup1.add(ckbRed);
        ckbRed.setText("Red");

        buttonGroup1.add(ckbBlue);
        ckbBlue.setText("Blue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblColor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbRed)
                            .addComponent(ckbGreen)
                            .addComponent(ckbBlue))))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblColor)
                .addGap(18, 18, 18)
                .addComponent(ckbGreen)
                .addGap(18, 18, 18)
                .addComponent(ckbRed)
                .addGap(18, 18, 18)
                .addComponent(ckbBlue)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ckbBlue;
    private javax.swing.JCheckBox ckbGreen;
    private javax.swing.JCheckBox ckbRed;
    private javax.swing.JLabel lblColor;
    // End of variables declaration//GEN-END:variables
}