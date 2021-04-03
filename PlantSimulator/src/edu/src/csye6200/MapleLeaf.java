package edu.src.csye6200;

import javax.swing.*;
import java.awt.*;

class MapleLeaf {
    private final Point[] vertices = {
            new Point(50, 110), new Point(50, 90), new Point(30, 90),
            new Point(0, 70), new Point(10, 60), new Point(0, 50),
            new Point(20, 40), new Point(10, 30), new Point(40, 50),
            new Point(30, 10), new Point(40, 20), new Point(50, 0),
            new Point(60, 0), new Point(70, 20), new Point(80, 10),
            new Point(70, 50), new Point(100, 30), new Point(90, 40),
            new Point(110, 50), new Point(100, 60), new Point(110, 70),
            new Point(80, 90), new Point(60, 90), new Point(60, 110),
            new Point(50, 110)
    };

    public void draw(int x, int y, Graphics2D g2d) {
        Point lastPoint = null;
        for (Point p : vertices) {
            if (lastPoint != null) {
                g2d.drawLine(
                        x + (int) lastPoint.getX(),
                        y + (int) lastPoint.getY(),
                        x + (int) p.getX(),
                        y + (int) p.getY());
            }

            lastPoint = p;
        }
    }
    public static void main(String[] args) {
        // Spawn a new window and set it's size:
        JFrame window = new JFrame("Your window");
        window.setSize(200, 200);

        // Create a new panel for drawing
        JPanel canvas = new JPanel() {

            // This method will be called whenever the screen is updating
            @Override
            protected void paintComponent(Graphics g) {
                // Create new maple leaf and draw it on screen
                new MapleLeaf().draw(10, 10, (Graphics2D) g);
            }

        };

        window.add(canvas);
        window.setVisible(true);
    }
}

