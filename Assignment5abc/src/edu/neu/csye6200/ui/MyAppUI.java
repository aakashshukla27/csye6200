/**
 *
 */
package edu.neu.csye6200.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.neu.csye6200.simbg.BGSimulation;

/**
 * @author mgmunson
 *
 */
public class MyAppUI extends BGApp {

    //private JFrame frame = null; // Now held in BGApp
    private JPanel mainPanel;
    private JButton startBtn;
    private JButton pauseBtn;
    private JButton stopBtn;
    public static TreePanel canvas;
    private JComboBox jComboBox;
    private BGSimulation simulation;
    private JLabel label;
    public static String simulationType = "Tree 1";
    public static int frameWidth = 1200;
    public static int frameHeight = 1200;
    /**
     * Constructor
     */
    public MyAppUI() {
        //initGUI(); // Now performed in the BGApp class
        simulation = new BGSimulation();

        customizeGUI();
        showUI(); // Execute a UI Thread startup
    }



    /*
     * Misc. UI adjustments are implemented here
     */
    private void customizeGUI() {
        frame.setSize(1200, 1200); // Width, height
        frame.setTitle("Biological Growth Simulator");
    }

    /**
     * Build a Main panel
     * @return a JPanel with content
     */
    public JPanel getMainPanel() {
        if (mainPanel != null) return mainPanel; // Only build the panel once

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);

        // Create the buttons
        startBtn = new JButton("Start");
        pauseBtn = new JButton("Pause");
        stopBtn = new JButton("Stop");
        String[] simulationTypes = {"Tree 1", "Tree 2", "Tree 3"};
        jComboBox = new JComboBox(simulationTypes);
        jComboBox.setSelectedIndex(0);

        label = new JLabel("Simulation Type: ");
        label.setForeground(Color.red);

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                simulationType = (String)jComboBox.getSelectedItem();
                System.out.println(simulationType + " Selected");
            }
        });

        // Subscribe this class to events
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start pressed - Anonymous inner callback");
                simulation.startSim(simulationType); // Start the Simulation
            }
        });
        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    simulation.pauseSim(simulationType);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulation.stopSim(simulationType);
            }
        });


        //pauseBtn.addActionListener(this);
        //stopBtn.addActionListener(this);


        // Add two buttons that 'flow'
        mainPanel.setLayout(new FlowLayout()); // Widgets will flow form left to right

        //Add combobox
        mainPanel.add(label);
        mainPanel.add(jComboBox);

        // Add buttons to the panel
        mainPanel.add(startBtn);
        mainPanel.add(pauseBtn);
        mainPanel.add(stopBtn);

        return mainPanel;
    }

    private JPanel getCanvasPanel() {
        if(canvas == null)
            canvas = new TreePanel();
        return canvas;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyAppUI myApp = new MyAppUI();
        System.out.println("MyAppUI is exiting !!!!!!!!!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Action Event: " + e);
//        if (e.getActionCommand().equalsIgnoreCase("Start")) {
//            System.out.println("Start pressed");
//            MyAppUI.canvas.removeAll();
//            MyAppUI.canvas.revalidate();
//            MyAppUI.canvas.repaint();
//            MyAppUI.canvas.updateUI();
//            simulation.startSim(simulationType); // Start the Simulation
//        }
//        else if (e.getActionCommand().equalsIgnoreCase("Pause")) {
//            System.out.println("Pause pressed");
//            try {
//                simulation.pauseSim(simulationType); // Pause the Simulation
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
//        }
//
//        else if (e.getActionCommand().equalsIgnoreCase("Stop")) {
//            System.out.println("Stop pressed");
//            simulation.stopSim(simulationType); // Stop the Simulation
//        }

    }

    @Override
    public JPanel getNorthPanel() {
        return getMainPanel();
    }

    @Override
    public JPanel getCenterPanel() {
        return getCanvasPanel();
    }

}
