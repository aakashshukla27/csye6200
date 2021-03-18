package edu.neu.csye6200.swing;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TreeCanvas extends JPanel {
    public static final Color VERY_LIGHT_RED = new Color(255,102,102);
    public TreeCanvas(){

    }

    public void paint(Graphics g){
        try {
            drawCanvas(g);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void drawCanvas(Graphics g) throws InterruptedException {
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        g2d.setColor(Color.cyan);

        g2d.fillRect(0,0, size.width, size.height*3/4);



        g2d.setColor(new Color(Color.HSBtoRGB(0,14,27)));
        g2d.fillRect(0, size.height*3/4, size.width, size.height*1/4);
        int startPositionX = size.width/2;
        int startPositionY = size.height*3/4;
        int endPositionX = size.width/2;
        int endPositionY = size.height*3/4 - 10;
        g2d.setColor(Color.red);
        g2d.drawLine(size.width/2,size.height*3/4 , size.width/2, size.height*3/4 - 10);
//        int i =1;
//        do{
//            i++;
//            //Thread.sleep(5000);
//            TimeUnit.SECONDS.sleep(5);
//            g2d.drawLine(startPositionX, startPositionY, endPositionX, endPositionY);
//        }
//        while(i<50);


    }




}
