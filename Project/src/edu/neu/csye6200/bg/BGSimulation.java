package edu.neu.csye6200.bg;

import java.util.Observable;

public class BGSimulation extends Observable implements Runnable {

	private Thread thread = null;
	private boolean done = false; // Set true to end a simulation loop
	private boolean paused = false; // Set true to puase the simulation loop
	private int ctr = 0;
	
	public BGSimulation() {
		System.out.println("Constructing the BGSimulation");
	}

	/**
	 * Start the simulation
	 */
	public void startSim() {
		System.out.println("Starting the simulation");
		if (thread == null)
			thread = new Thread(this); // We are the Runnable
		
		// Set control flags here
		
		thread.start();
		
	}
	
	/**
	 * Toggle the paused state between off/on
	 */
	public void pauseSim() {
		paused = !paused; // Flip the paused state
		System.out.println("Pause state is " + paused);
	}
	
	
	
	/** 
	 * Stop the simulation
	 */
	public void stopSim() {
		System.out.println("Stoppin the simulation");
		if (thread == null) return;
		done = true; // Stops an existing simulation loop
	}

	@Override
	public void run() {
       runSimLoop(); // Run the simulation
       thread = null;
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
