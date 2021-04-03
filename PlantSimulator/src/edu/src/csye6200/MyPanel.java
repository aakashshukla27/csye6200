package edu.src.csye6200;

import org.w3c.dom.css.RGBColor;

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
            switch(stem.category){
                case 1: g2d.setColor(new Color(205,133,63));break;
                case 2: g2d.setColor(Color.GREEN);break;
                case 3: g2d.setColor(Color.red);break;
            }

            g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
        }
    }
}
