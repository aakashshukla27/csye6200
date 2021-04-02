package edu.neu.csye6200.bg;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    SimulationPanel(){
        this.setPreferredSize(new Dimension(1000,1000));
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawLine(0,0,500,500);
        for (Object s : Simulator.shapes) {
            if (s instanceof Trunk) {
                ((Trunk) s).draw(g);
                //g2d.drawLine(((Trunk) s).xi,((Trunk) s).yi,((Trunk) s).xf,((Trunk) s).yf);
            }
        }
    }

}
