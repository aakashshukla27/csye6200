package edu.neu.csye6200.bg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class MyPanel extends JPanel {
    MyPanel(){
        this.setPreferredSize(new Dimension(1200,1200));
    }
    Random random = new Random();
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        Simulator.width = (int) size.getWidth();
        Simulator.height = (int) size.getHeight();
        for (Stem stem : BGGenerationSet.stemList) {
            if(stem.category == 1){
                g2d.setColor(new Color(123,63,0));
                Stroke stroke = new BasicStroke(4f);
                g2d.setStroke(stroke);
                g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
            }
            if(stem.category == 0 || stem.category == 2){
                g2d.setColor(new Color(0,128,0));
                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);
                g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
                if(random.nextInt(5) == 1) {
                    ArrayList<Double> temp = new ArrayList<Double>();
                    temp.add(stem.currX);
                    temp.add(stem.currY);
                    BGGenerationSet.flowerList.add(temp);

                }
            }
        }
        if(BGGenerationSet.growFlowers){
            for(ArrayList<Double> flower : BGGenerationSet.flowerList){
                Shape circle = new Ellipse2D.Double(flower.get(0), flower.get(1), 1, 1);
                g2d.setColor((Color.red));
                g2d.draw(circle);
            }
        }

    }


}
