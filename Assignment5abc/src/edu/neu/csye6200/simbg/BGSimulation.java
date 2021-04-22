package edu.neu.csye6200.simbg;

import edu.neu.csye6200.ui.*;

import java.util.Observable;

public class BGSimulation extends Observable implements Runnable {


    private boolean done = false; // Set true to end a simulation loop
    public static boolean paused = false; // Set true to pause the simulation loop
    private int ctr = 0;
    //Instances of 3 simulation threads
    Rule1Thread rule1 = null;
    Rule2Thread rule2 = null;
    Rule3Thread rule3 = null;

    public BGSimulation() {
        System.out.println("Constructing the BGSimulation");
    }

    /**
     * Start the simulation
     */
    public void startSim(String simulationType) {
        paused = false;
        System.out.println("Starting the simulation");
        //Clearing panel before starting simulation
        MyAppUI.canvas.removeAll();
        MyAppUI.canvas.revalidate();
        MyAppUI.canvas.repaint();
        MyAppUI.canvas.updateUI();
        /**
         * Creating new instance of simulation based on selection in combo box
         */
        switch (simulationType){
            case "Tree 1":
                Rule1Thread.stemList.clear();
                Rule1Thread.rotatedStems.clear();

                rule1 =new Rule1Thread(MyAppUI.frameWidth/2 - 50, MyAppUI.frameHeight/2, MyAppUI.frameWidth/2 - 50,
                        MyAppUI.frameWidth/2 -450,1, 90, 0);
                rule1.start();

                break;
            case "Tree 2":

                Rule2Thread.stemList.clear();
                Rule2Thread.rotatedStems.clear();
                rule2 =new Rule2Thread(MyAppUI.frameWidth/2 - 50, MyAppUI.frameHeight/2, MyAppUI.frameWidth/2 - 50,
                        MyAppUI.frameWidth/2 -450,1, 90, 0);
                rule2.start();
                break;
            case "Tree 3":

                Rule3Thread.stemList.clear();
                Rule3Thread.rotatedStems.clear();
                rule3 =new Rule3Thread(MyAppUI.frameWidth/2 - 50, MyAppUI.frameHeight/2, MyAppUI.frameWidth/2 - 50,
                        MyAppUI.frameWidth/2 -350,1, 90, 0);
                rule3.start();
                break;
        }


    }

    /**
     * Toggle the paused state between off/on and call the sleep and resume methods of threads
     */
    public void pauseSim(String simulationType) throws InterruptedException {

        switch (simulationType){
            case "Tree 1":
                if(!paused){
                    paused = true;
                    rule1.sleep();
                }
                else {
                    paused = false;
                    rule1.resume();
                }
                break;
            case "Tree 2":
                if(!paused){
                    paused = true;
                    rule2.sleep();
                }
                else {
                    paused = false;
                    rule2.resume();
                }
                break;
            case "Tree 3":
                if(!paused){
                    paused = true;
                    rule3.sleep();

                }
                else {
                    paused = false;
                    rule3.resume();
                }
                break;
        }
    }



    /**
     * Stop the simulation by calling stop method in the threads
     */
    public void stopSim(String simulationType) {
        System.out.println("Stopping the simulation");
        switch (simulationType){
            case "Tree 1":
                rule1.stop();
                break;
            case "Tree 2":
                rule2.stop();
                break;
            case "Tree 3":
                rule3.stop();
                break;
        }


    }

    /**
     * over ride for run method
     */
    @Override
    public void run() {
        runSimLoop(); // Run the simulation
        //thread = null;
    }

    // The main simulation loop
    private void runSimLoop() {
        while(!done) {
            if (!paused)
                updateSim(); // Advance the simulation
            sleep(500L); // Do a half second delay
        }
    }

    /**
     * Perform a thread sleep
     * @param millis time to sleep in millis
     */
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Perform an update to our simulation - cause growth to occur
     */
    private void updateSim() {
        System.out.println("Updating the simulation state - growth" + ctr++);

        setChanged(); // Indicate that new data is available
        notifyObservers("New data " + ctr);
        if (ctr > 10000) done = true;
    }
}
