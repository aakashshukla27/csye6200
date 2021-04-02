package edu.neu.csye6200.bg;

import java.awt.*;

public class Trunk {
    public int xi, yi, xf, yf;
    public Trunk(int xi, int yi, int xf, int yf){
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
    }
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.gray);
        g2d.drawLine(xi, yi, xf, yf);
    }

    public void updateTrunkHeight(){
        this.yf -= 1;
        BGRule.calculateTrunkLength(this);
    }
//    public int getTrunkHeight(){
//        BGRule.calculateTrunkLength(this);
//        return this.currentLength;
//    }
}
