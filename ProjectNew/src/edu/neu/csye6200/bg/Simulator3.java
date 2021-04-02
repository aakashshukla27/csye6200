package edu.neu.csye6200.bg;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Shape;
public class Simulator3 extends JFrame {
    public Simulator3(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    private void init(){
        final Design d = new Design();
        d.addRect(400,400,10,1);
        for(int i=0; i<50; i++){
            d.growTrunk();
        }
    }

    private class Design extends JComponent{
        private ArrayList<Shape> shapes = new ArrayList<Shape>();
        public void paint(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for(Shape s : shapes){
                g2d.draw(s);
            }
        }
        public void addRect(int xi, int yi, int xf, int yf){
            //shapes.add((Shape) new Trunk(xi,yi,xf,yf));
            shapes.add(new Rectangle(xi,yi,xf,yf));
            repaint();
        }
        public void growTrunk(){
            Rectangle r1 = (Rectangle) shapes.get(0);
            r1.height += 1;
            shapes.add(0,r1);
            repaint();
        }
    }

    public static void main(String[] args) {
        new Simulator3();
    }
}
