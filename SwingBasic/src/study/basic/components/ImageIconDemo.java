/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.basic.components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Minnn
 */
public class ImageIconDemo extends JFrame {

    public ImageIconDemo() {
        this.setSize(400, 250);
        setLocation(300, 300);
        setVisible(true);
        setResizable(false);
        JLabel label = new JLabel();
        add(label);
        label.setSize(350, 200);
        label.setText("Quang");
        label.setToolTipText("Minnnnn");

        // hien thi size len console
        System.out.println("x: " + label.getSize().width
                + "y: " + label.getSize().height);

        setPicture(label, "icon.png");

    }

    public void setPicture(JLabel label, String filename){
        try {
            BufferedImage image = ImageIO.read(new File(filename));
            int x = label.getSize().width;
            int y = label.getSize().height;
            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx;
            int dy;
            if (x / y > ix / iy) {
                dy = y;
                dx = dy + ix / iy;
            } else {
                dx = x;
                dy = dx + iy / ix;
            }
            
            ImageIcon iIcon = new ImageIcon(image.getScaledInstance(100, 100, image.SCALE_SMOOTH));
            label.setIcon(iIcon);
        } catch (IOException ex) {
            Logger.getLogger(ImageIconDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        ImageIconDemo iconDemo = new ImageIconDemo();

    }
}
