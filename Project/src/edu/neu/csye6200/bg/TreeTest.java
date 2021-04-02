package edu.neu.csye6200.bg;

import javax.swing.*;

public class TreeTest extends JFrame {
    static MyPanel myPanel;
    TreeTest(){
        myPanel = new MyPanel();
        myPanel.removeAll();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,1000);
        this.setLocationRelativeTo(null);
        this.add(myPanel);
        this.pack();
        this.setVisible(true);
    }
}
