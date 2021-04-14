package edu.neu.csye6200.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyCanvas extends JPanel {

    //private MyStem stemBase

    public MyCanvas() {
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(1200,1200));
    }

    public void paint(Graphics g) {
        drawCanvas(g);
    }

    //public void setStemBase( MyStem stemBase) { }


    // private void drawStem() {
    // Iterate throught the tree and draw stems
    // }

    /**
     * Draw the panel contents manually
     * @param g
     */
    public void drawCanvas(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Cast to the better G2D interface

        Dimension size = getSize();

        g2d.setColor(Color.blue);
        g2d.fillRect(0, 0, size.width, size.height);

        g2d.setColor(Color.green);
        g2d.drawString("Hello World 2D",10, 20);

        g2d.setColor(Color.red);
        g2d.drawLine(0, 0, size.width, size.height); // Corner to corner

        // drawStem();
    }

}
