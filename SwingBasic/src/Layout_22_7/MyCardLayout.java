/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout_22_7;

import Sample_15_7.ColorDemo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Rin's
 */
public class MyCardLayout extends JFrame implements ActionListener{
    JPanel p1, p2;
    JButton btn;
    CardLayout c;
    
    
    
    public MyCardLayout () {
        super("MyCardLayout");
        //whole frame is border layout
        Container cc = getContentPane();
        cc.setLayout(new BorderLayout());
        //top panel is flow layout
        p1 = new JPanel (new FlowLayout());
        //center panel is cardlayout
        p2 = new JPanel(c = new CardLayout());
        
        //add p1 to top/north of cc
        cc.add(p1, BorderLayout.NORTH);
        //add p2 to center of cc
        cc.add(p2,BorderLayout.CENTER);
        //build c
//        c.addLayoutComponent(new HobbyPanel(), "hobby");
//        c.addLayoutComponent(new ColorPanel(), "color");
        //build p1
        p1.add(btn = new JButton("Next"));
        btn.addActionListener(this);
        //build p2
        p2.add(new HobbyPanel());
        p2.add(new ColorPanel());
        
        setSize(300, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //display next panel in c to p2
        c.next(p2);
    }
    
    public static void main(String[] args) {
        new MyCardLayout();
    }
}
