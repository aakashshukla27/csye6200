package edu.neu.csye6200.bg;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator2 {
    public static List<Object> shapes = new ArrayList<>();
    static SimulationHelper simulationHelper = new SimulationHelper();

    public static void main(String[] args) {
        //new SimulationFrame();
        SimulationPanel panel = new SimulationPanel();
        Trunk t1 = new Trunk(600,600,600,600);
        shapes.add(t1);
        simulationHelper.createTrunkSimulation();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
