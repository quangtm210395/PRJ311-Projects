/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample_15_7;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Rin's
 */
public class StudentFrame extends JFrame {
    JLabel lblName;
    JTextField txtName;
    JButton btnClick;
    
    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // if btnis clicked 
            if (e.getSource() == btnClick) {
                String name = txtName.getText();
                JOptionPane.showMessageDialog(StudentFrame.this, "Welcome " + name);
            }
            if (e.getSource() == txtName) {
                String name = txtName.getText();
                JOptionPane.showMessageDialog(StudentFrame.this, "Welcome " + name);
            }
        }
        
    }
    
    
    public StudentFrame(String title) {
        super(title);
        //get content panel
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        lblName = new JLabel("Enter your name: ");
        c.add(lblName);
        c.add(txtName = new JTextField(20));
        c.add(btnClick = new JButton("<html><b><u>C</u>lick</b><br>me!</html>"));
        // register listener
        MyActionListener action = new MyActionListener();
        btnClick.addActionListener(action);
        txtName.addActionListener(action);
        
        setResizable(false);
        setLocation(200,200);
        
//        setSize(300, 200);
        setTitle("Quang");
        pack(); 
        //tu dong co kick thuoc bang dung kich thuoc component ben trong
        setVisible(true);
        
        //close app when button close is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //look and feels
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        new StudentFrame("Student Frame");
    }

    
}
