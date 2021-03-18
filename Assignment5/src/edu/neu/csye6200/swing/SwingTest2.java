package edu.neu.csye6200.swing;

import javax.swing.*;
import java.awt.*;

public class SwingTest2 {

    private JFrame frame = null;
    private JPanel mainPanel = null;
    private JPanel eastPanel = null;
    private JButton startBtn, stopBtn;
    private MyCanvas canvas;
    public SwingTest2(){
        initGUI();
    }

    private void initGUI(){
        frame = new JFrame();
        frame.setTitle("MyAPPUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        frame.setLayout(new BorderLayout());

        frame.add(getMainPanel(), BorderLayout.NORTH);
        canvas = new MyCanvas();
        frame.add(canvas, BorderLayout.CENTER );
        //frame.add(eastPanel(), BorderLayout.EAST);
        frame.setVisible(true);
    }

    public JPanel getMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new FlowLayout()); // Widgets flow from left to right
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        mainPanel.add(startBtn);
        mainPanel.add(stopBtn);
        return mainPanel;
    }
//    public JPanel eastPanel(){
//        eastPanel = new JPanel();
//        eastPanel.setBackground(Color.CYAN);
//        eastPanel.setSize(300, 300);
//        return eastPanel;
//    }





    public static void main(String[] args) {
        SwingTest2 myApp = new SwingTest2();

    }
}
