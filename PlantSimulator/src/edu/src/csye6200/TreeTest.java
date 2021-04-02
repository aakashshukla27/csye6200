package edu.src.csye6200;

import javax.swing.*;
import java.awt.*;

public class TreeTest extends JFrame {
    static MyPanel myPanel;
    TreeTest(){
        myPanel = new MyPanel();
        myPanel.removeAll();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,1000);
        this.setBackground(Color.black);
        this.setLocationRelativeTo(null);
        this.add(myPanel);
        this.pack();
        this.setVisible(true);
    }
}
