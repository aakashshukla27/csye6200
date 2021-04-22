package edu.neu.csye6200.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TreePanel extends JPanel implements ComponentListener {
    TreePanel(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(1200,1200));

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        switch (MyAppUI.simulationType){
            case "Tree 1":
                this.removeAll();
                if(Rule1Thread.rotatedStems.size() == 0){
                    this.removeAll();
                    for (Stem stem : Rule1Thread.stemList) {
                        switch (stem.category) {
                            case 1 -> g2d.setColor(new Color(205, 133, 63));
                            case 2 -> g2d.setColor(Color.GREEN);
                            case 3 -> g2d.setColor(Color.red);
                            case 4 -> g2d.setColor(new Color(255, 105, 180));
                        }
                        g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
                        if(stem.maxLengthAchieved() && stem.parent != 0){
                            g2d.setColor(new Color(105,18,235));
                            g2d.drawOval((int)stem.currX, (int)stem.currY, 5,5);
                        }
                    }
                }
                else {
                    for(RotatedStem rotatedStem : Rule1Thread.rotatedStems){
                        switch (rotatedStem.category) {
                            case 1 -> g2d.setColor(new Color(205, 133, 63));
                            case 2 -> g2d.setColor(Color.GREEN);
                            case 3 -> g2d.setColor(Color.red);
                            case 4 -> g2d.setColor(new Color(255, 105, 180));
                        }
                        g2d.drawLine((int)rotatedStem.xi, (int)rotatedStem.yi, (int)rotatedStem.xc1, (int)rotatedStem.yc1);
                        if(rotatedStem.connection != 0){
                            g2d.setColor(new Color(105,18,235));
                            g2d.drawOval((int)rotatedStem.xi, (int)rotatedStem.yi, 5,5);
                        }

                    }
                }

                break;
            case "Tree 2":
                if(Rule2Thread.rotatedStems.size() == 0){
                    for (Stem stem : Rule2Thread.stemList) {
                        switch (stem.category) {
                            case 1 -> g2d.setColor(new Color(205, 133, 63));
                            case 2 -> g2d.setColor(Color.GREEN);
                            case 3 -> g2d.setColor(Color.red);
                            case 4 -> g2d.setColor(new Color(255, 105, 180));
                        }
                        g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
                        if(stem.maxLengthAchieved() && stem.parent != 0){
                            g2d.setColor(new Color(105,18,235));
                            g2d.drawOval((int)stem.currX, (int)stem.currY, 5,5);
                        }
                    }
                }
                else {
                    int width = 5, height = 5, count = 1;

                    for(RotatedStem rotatedStem : Rule2Thread.rotatedStems){
                        count++;
                        switch (rotatedStem.category) {
                            case 1 -> g2d.setColor(new Color(205, 133, 63));
                            case 2 -> g2d.setColor(Color.GREEN);
                            case 3 -> g2d.setColor(Color.red);
                            case 4 -> {
                                g2d.setColor(new Color(255, 105, 180));
                                if (width < 12 && count % 2 == 0) {
                                    width++;
                                    height++;
                                }
                            }
                        }
                        g2d.drawLine((int)rotatedStem.xi, (int)rotatedStem.yi, (int)rotatedStem.xc1, (int)rotatedStem.yc1);
                        if(rotatedStem.connection != 0){
                            g2d.setColor(new Color(105,18,235));
                            g2d.fillOval((int)rotatedStem.xi, (int)rotatedStem.yi, width,height);

                        }

                    }
                }
                break;
            case "Tree 3":
                if(Rule3Thread.rotatedStems.size() == 0){
                    for (Stem stem : Rule3Thread.stemList) {
                        switch(stem.category){
                            case 1: g2d.setColor(new Color(205,133,63));break;
                            case 2: g2d.setColor(Color.GREEN);break;
                            case 3: g2d.setColor(Color.red);break;
                            case 4: g2d.setColor(new Color(255,105,180));break;
                        }
                        g2d.drawLine((int)stem.startX, (int)stem.startY, (int)stem.currX, (int)stem.currY);
                        if(stem.maxLengthAchieved() && stem.parent != 0){
                            g2d.setColor(new Color(105,18,235));
                            g2d.drawOval((int)stem.currX, (int)stem.currY, 5,5);
                        }
                    }
                }
                else {
                    int width = 5, height = 5, count = 1;

                    for(RotatedStem rotatedStem : Rule3Thread.rotatedStems){
                        count++;
                        switch(rotatedStem.category){
                            case 1: g2d.setColor(new Color(205,133,63));break;
                            case 2: g2d.setColor(Color.GREEN);break;
                            case 3: g2d.setColor(Color.red);break;
                            case 4: g2d.setColor(new Color(255,105,180));
                                if(width <12 && count%3 == 0){
                                    width++;
                                    height++;
                                }
                                break;
                        }
                        g2d.drawLine((int)rotatedStem.xi, (int)rotatedStem.yi, (int)rotatedStem.xc1, (int)rotatedStem.yc1);
                        if(rotatedStem.connection != 0){
                            g2d.drawLine((int)rotatedStem.xi, (int)rotatedStem.yi, (int)rotatedStem.xi, (int)rotatedStem.yi + 10);
                            switch (rotatedStem.category){
                                case 3:
                                    g2d.setColor(Color.ORANGE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.cyan);
                                    break;
                                default:
                                    g2d.setColor(Color.red);
                                    break;
                            }
                            //g2d.setColor(Color.ORANGE);
                            g2d.fillOval((int)rotatedStem.xi, (int)rotatedStem.yi+10, width,height);

                        }

                    }
                }
                break;
        }
    }

    /**
     * over ride to generate responsive design
     * @param e
     */
    @Override
    public void componentResized(ComponentEvent e) {
        MyAppUI.canvas.removeAll();
        MyAppUI.canvas.revalidate();
        MyAppUI.canvas.repaint();
        MyAppUI.canvas.updateUI();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
