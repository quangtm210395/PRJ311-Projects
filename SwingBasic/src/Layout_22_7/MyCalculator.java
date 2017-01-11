/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout_22_7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Rin's
 */
public class MyCalculator extends JFrame implements ActionListener {

    JPanel pnlTop, pnlCenter;
    JTextField txt;
    JButton[] btn;
    String opt = "%^MC789/456*123-0.=+";

    class MyAction implements ActionListener {
        String temp = "";
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //get label of clicked button
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            
            String s = e.getActionCommand();
            if ("0123456789.".contains(s)) {
                //append txt
                txt.setText(txt.getText().trim() + s);
                temp += s;
            }
            if ("+-*/%".contains(s)) {
                txt.setText("");
                if ("+-*/%".contains(temp.charAt(temp.length() - 1) +"") ) {
//                    System.out.println(temp.length());
                    temp = temp.substring(0, temp.length()- 1);
                }
                temp += s;
            }
            if ("=".equals(s)) {
                try {
                    txt.setText(String.format("%10s", engine.eval(temp)));
                } catch (ScriptException ex) {
                    Logger.getLogger(MyCalculator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (s.equals("C")) {
                txt.setText("");
                temp = "";
            }
            
        }
    }

    public MyCalculator(String title) {
        super(title);
        //whole frame is borderlayout
        Container c = getContentPane();
        c.setLayout(new BorderLayout(0, 0));
        setSize(250, 300);
        //top panel is flow layout
        pnlTop = new JPanel(new BorderLayout());
        //center panel is grid layout(0,4)
        pnlCenter = new JPanel(new GridLayout(0, 4, 5, 5));
        //add pnlTop to the top
        c.add(pnlTop, BorderLayout.NORTH);
        c.add(pnlCenter, BorderLayout.CENTER);
        //build pnlTop
        pnlTop.add(txt = new JTextField(15));
        txt.setHorizontalAlignment(JTextField.RIGHT);
        //build pnlCenter
        MyAction ma = new MyAction();
        btn = new JButton[opt.length()];
        for (int i = 0; i < opt.length(); i++) {
            pnlCenter.add(btn[i] = new JButton(opt.charAt(i) + ""));
            btn[i].addActionListener(ma);
        }

//        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyCalculator("My Calculator");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
