package edu.neu.csye6200.swing;

import javax.swing.*;

public class SwingDemo {
    public SwingDemo(){
        JFrame jfrm = new JFrame("A Simple Swing Application");
        jfrm.setSize(275,100);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Swing is pathetic shit.");
        jfrm.add(jLabel);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
