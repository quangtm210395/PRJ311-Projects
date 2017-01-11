/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.basic.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Minnn
 */
public class ButtonDemo extends JFrame implements ActionListener{

    JLabel label = new JLabel();
    JButton button1 = new JButton();
    JButton button = new JButton();
    
    public ButtonDemo() {
        this.setSize(400, 250);
        setLocation(300, 300);
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(label);
        label.setSize(350, 200);
        label.setForeground(Color.GREEN);
        label.setText("Quang");
        label.setToolTipText("Minnnnn");
        
        
        button.setText("Click");
        add(button, "North", 1);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do something here
                //label.setText("Min");
                changeText(label, "Min");
            }
        });
        
        button1 = new JButton("Hit me");
        add(button1, "South", 1);
        button1.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == button1) {
            label.setText("Hello");
        } else if (b.getActionCommand().equals("Click")) {
            changeText(label, "Hi Im Min");
        }
    }
    
    public void changeText(JLabel label , String text){
        label.setText(text);
    }
    
    public static void main(String[] args) {
        ButtonDemo buttonDemo = new ButtonDemo();
        
    }

    
    
}
