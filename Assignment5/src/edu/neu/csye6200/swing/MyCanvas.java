package edu.neu.csye6200.swing;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel {
    public MyCanvas(){

    }

    public void paint(Graphics g){
        drawCanvas(g);
    }

    public void drawCanvas(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        g2d.setColor(Color.blue);
        g2d.fillRect(0,0, size.width, size.height);

        g2d.setColor(Color.green);
        g2d.drawString("Hello World 2D", 10, 20);

        g2d.setColor(Color.red);
        g2d.drawLine(0, (size.height), size.width, 0);
    }
}
