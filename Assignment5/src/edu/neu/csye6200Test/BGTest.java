package edu.neu.csye6200Test;

public class BGTest {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Stem stem1 = new Stem(250,450,250,450,0,90,1);
        SimulationRules simulationRules = new SimulationRules();
        SimulationRules.GrowthImplementationThread growthThread = new SimulationRules.GrowthImplementationThread();

        Thread newThread = new Thread(growthThread);
        newThread.start();

    }
}
