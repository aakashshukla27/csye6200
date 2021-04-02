package edu.src.csye6200;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    MyPanel(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(1200,1200));
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (Stem stem : BGGenerationSet.stemList) {
            g2d.setColor(Color.GRAY);
            g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
        }
    }
}
