/**
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neu.csye6200.bg.BGSimulation;

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
	private MyCanvas canvas;
	
	private BGSimulation simulation;
	
	
	/**
	 * Constructor
	 */
	public MyAppUI() {
      //initGUI(); // Now performed in the BGApp class
      simulation = new BGSimulation();
      
      customizeGUI();
      showUI(); // Execute a UI Thread startup 
	}

	// Build needed GUI components
	//*** This method is now in the BGApp class
	/*
	private void initGUI() {
		frame = new JFrame();
		frame.setSize(400,300);
		frame.setTitle("MyAppUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Press red button to stop app
	
		// Build center content
		frame.setLayout(new BorderLayout());
		
		// Add a panel to the center
		frame.add(getMainPanel(), BorderLayout.NORTH);
		
		canvas = new MyCanvas(); // Build a custon JPanel that we can draw into
		
		frame.add(canvas, BorderLayout.CENTER);
		
	    frame.setVisible(true); // **** FORCE THE DIPLAY ON ****
	}
	*/
	
	/*
	 * Misc. UI adjustments are implemented here
	 */
	private void customizeGUI() {
		frame.setSize(600, 400); // Width, height
		frame.setTitle("MyAppUI)");
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
		
		
		//startBtn.addActionListener(this); // Subscribe this class to events
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Start pressed - Anonymous inner callback");
				simulation.startSim(); // Start the Simulation
			}
		});
		
		
	    pauseBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		
				
		// Add two buttons that 'flow'
		mainPanel.setLayout(new FlowLayout()); // Widgets will flow form left to right
		
		// Add buttons to the panel
		mainPanel.add(startBtn);
		mainPanel.add(pauseBtn);
		mainPanel.add(stopBtn);
		
		return mainPanel;
	}

    private JPanel getCanvasPanel() {
    	if (canvas == null) // Only build this once
		    canvas = new MyCanvas(); // Build a custon JPanel that we can draw into
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
		System.out.println("Action Event: " + e);
		if (e.getActionCommand().equalsIgnoreCase("Start")) {
			System.out.println("Start pressed");
			simulation.startSim(); // Start the Simulation
		}
		else if (e.getActionCommand().equalsIgnoreCase("Pause")) {
			System.out.println("Pause pressed");
			simulation.pauseSim(); // Pause the Simulation
		}
		else if (e.getActionCommand().equalsIgnoreCase("Stop")) {
			System.out.println("Stop pressed");
			simulation.stopSim(); // Stop the Simulation
		}
		
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
