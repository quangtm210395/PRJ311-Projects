/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.basic.components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Minnn
 */
public class MyGridLayout extends javax.swing.JFrame implements ActionListener {

    private JPanel mainPanel;
    private GridLayout gridLayout;
    private JLabel lbText;
    private JLabel lbResult;
    private boolean answer;

    public MyGridLayout() {
        createFrame();
    }

    private void createFrame() {
        // create Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(true);

        // add content to frame
        mainPanel = createMainPanel();
        add(mainPanel);

        // display
        setVisible(true);
        setLocationRelativeTo(null);
        setLocation(200, 200);

    }

    private JPanel createMainPanel() {
        // create panel with grid layout
        gridLayout = new GridLayout(2, 2, 10, 10);
        JPanel panel = new JPanel(gridLayout);

        // add 2 label
        lbText = createLabel(randomText());
        lbResult = createLabel("0");
        panel.add(lbText);
        panel.add(lbResult);
        
        // add six button to panel
        panel.add(createButton("Yes"));
        panel.add(createButton("No"));

        return panel;
    }

    private JButton createButton(String title) {
        JButton btn = new JButton(title);
        btn.addActionListener(this);

        return btn;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);

        return label;
    }
    
    private String randomText(){
        Random rd = new Random();
        int dg1, dg2, ans;
        char op1 = ' ';
        int choice;
        
        dg1 = rd.nextInt(9) + 1;
        dg2 = rd.nextInt(9) + 1;
        ans = rd.nextInt(16) + 2;
        choice = rd.nextInt(6);
        switch(choice){
            case 0:
                op1 = '<';
                break;
            case 1:
                op1 = '>';
                break;
            case 2:
                op1 = '+';
                break;
            case 3:
                op1 = '-';
                break;
            case 4:
                op1 = '*';
                break;
            case 5:
                op1 = '/';
                break;
        }
        
        if (choice < 2) {
            return dg1 + " " + op1 + " " + dg2;
        } else {
            int rand = rd.nextInt(2);
            if (rand == 0) {
                return "( " + dg1 + " " + op1 + " " + dg2 + " ) == " + ans;
            } else
            return "( " + dg1 + " " + op1 + " " + dg2 + " ) > " + ans;
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        String text = lbText.getText();
        
        try {
            answer = (boolean) engine.eval(text);
        } catch (ScriptException ex) {
            Logger.getLogger(MyGridLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (e.getActionCommand().equals("Yes")) {
            if (answer == true) {
                System.out.println(answer);
                lbResult.setText(addOne(lbResult.getText()));
            }
            lbText.setText(randomText());
        } else if (e.getActionCommand().equals("No")) {
            if (answer == false) {
                System.out.println(answer);
                lbResult.setText(addOne(lbResult.getText()));
            }
            lbText.setText(randomText());
        }
        
    }
    
    private String addOne(String num){
        int number = Integer.parseInt(num) + 1;
        
        return number + "";
    }
    
    private void gameLogic(){
        
    }
    
    public static void main(String[] args) {
        MyGridLayout myGridLayout = new MyGridLayout();
    }

}
