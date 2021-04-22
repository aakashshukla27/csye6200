package edu.neu.csye6200.ui;

import java.util.concurrent.atomic.AtomicBoolean;

public class GraphicThread implements Runnable{
    private static Thread worker; //main thread of the simulation
    private static final AtomicBoolean running = new AtomicBoolean(false); //current state of thread is stored here
    private static boolean stop = false; //used for stopping the simulation

    public void start() {
        worker = new Thread(this);
        stop = false;
        running.set(true);
        worker.start();
    }

    /**
     * stop the thread
     */
    public void stop() {
        stop = true;
        running.set(false);
    }

    /**
     * put thread in infinite sleep - wakes up when the pause button is pressed again
     */
    public void sleep() {
        running.set(false);
    }

    /**
     * resume the thread when pause pause button is pressed again
     */
    public void resume(){
        running.set(true);
    }


    @Override
    public void run() {

        while (running.get()){
            MyAppUI.canvas.removeAll();
            MyAppUI.canvas.revalidate();
            MyAppUI.canvas.repaint();
            MyAppUI.canvas.updateUI();
        }
    }
}
