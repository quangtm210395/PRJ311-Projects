/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout_22_7;

/**
 *
 * @author Rin's
 */
public class HobbyPanel extends javax.swing.JPanel {

    /**
     * Creates new form HobbyPanel
     */
    public HobbyPanel() {
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

        lblSelect = new javax.swing.JLabel();
        ckbReading = new javax.swing.JCheckBox();
        ckbCooking = new javax.swing.JCheckBox();
        ckbWatching = new javax.swing.JCheckBox();

        lblSelect.setText("Select your hobby");

        ckbReading.setText("Reading");

        ckbCooking.setText("Cooking");

        ckbWatching.setText("Writting");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblSelect))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbWatching)
                            .addComponent(ckbReading)
                            .addComponent(ckbCooking))))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblSelect)
                .addGap(29, 29, 29)
                .addComponent(ckbReading)
                .addGap(5, 5, 5)
                .addComponent(ckbWatching)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckbCooking)
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ckbCooking;
    private javax.swing.JCheckBox ckbReading;
    private javax.swing.JCheckBox ckbWatching;
    private javax.swing.JLabel lblSelect;
    // End of variables declaration//GEN-END:variables
}
