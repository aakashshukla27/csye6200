package edu.neu.csye6200.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TreePractice  {

    private JFrame frame = null;
    private JPanel mainPanel = null;
    private TreeCanvas canvas;

    public TreePractice(){
        initGUI();
    }
    private void initGUI(){
        frame = new JFrame();
        frame.setTitle("MyAPPUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        frame.setLayout(new BorderLayout());

        //frame.add(getMainPanel(), BorderLayout.NORTH);
        canvas = new TreeCanvas();
        frame.add(canvas, BorderLayout.CENTER );
        frame.setVisible(true);
    }
    public JPanel getMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new FlowLayout()); // Widgets flow from left to right

        return mainPanel;
    }

    public static void main(String[] args) {
        TreePractice myApp = new TreePractice();
    }
}
