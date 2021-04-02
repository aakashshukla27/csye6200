package edu.neu.csye6200.bg;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator extends JPanel {
    public static List<Object> shapes = new ArrayList<>();


    public void addTrunk(int X, int Y) {
        //shapes.add(new Trunk(X, Y));
        repaint();
    }
//    public Simulator(String shape){
//
//        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension(400, 400));
//        int w = 400;
//        int h = 400;
//        int x = (w/2);
//        int y = h-100;
//        for(int i=0; i<100; i++){
//           y -= 1;
//           addTrunk(w/2,y);
//        }
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Trunk) {
                ((Trunk) s).draw(g);
            }

        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        String shape = "Trunk";
        frame.add(new Simulator());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public Simulator(){
        Trunk trunk = new Trunk(600,600, 600, 600);
        shapes.add(trunk);
        //SimulationHelper.createTrunkSimulation();
    }
}
