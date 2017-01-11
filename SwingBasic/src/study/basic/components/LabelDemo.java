/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.basic.components;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Minnn
 */
public class LabelDemo extends JFrame{
    public LabelDemo(){
        this.setSize(400,250);
        setVisible(true);
        setLocation(300, 300);
        setResizable(true);
        JLabel label = new JLabel("Quang");
        add(label);
        
        label.setText("Min");
        // dung de chu thich, dua chuot vao hien ra
        label.setToolTipText("Tran Minh Quang"); 
        label.setForeground(Color.GREEN);
    }
    
    public static void main(String[] args) {
        LabelDemo label = new LabelDemo();
        
    }
}
