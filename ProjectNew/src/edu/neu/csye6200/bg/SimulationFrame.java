package edu.neu.csye6200.bg;

import javax.swing.*;

public class SimulationFrame extends JFrame{
    SimulationPanel panel;

    SimulationFrame(){
        panel = new SimulationPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }




}
