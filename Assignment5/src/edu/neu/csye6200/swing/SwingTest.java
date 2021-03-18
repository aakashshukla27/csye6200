package edu.neu.csye6200.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class SwingTest extends JFrame {
    public static void main(String[] args) {
        SwingTest demo = new SwingTest();
        demo.setVisible(true);
    }

    public SwingTest(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setSize(550,300);
    }
    public void paint(Graphics gp){
        super.paint(gp); Graphics2D graphics = (Graphics2D) gp;
        Line2D line = new Line2D.Float(0, 0, 150, 220);
        graphics.draw(line);
    }



}
