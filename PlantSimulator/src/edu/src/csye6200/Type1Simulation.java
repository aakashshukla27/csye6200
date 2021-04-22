package edu.src.csye6200;

public class Type1Simulation {

    Type1Simulation(int startX, int startY, int endX, int endY, int angle) throws InterruptedException {
        BGGenerationSet bgGenerationSet = new BGGenerationSet();
        Type1SimulationHelper type1SimulationHelper = new Type1SimulationHelper();

        //Stem s1 = type1SimulationHelper.createMainStemTest(600,600,600,150,90);
        Stem s1 = type1SimulationHelper.createMainStemTest(startX,startY,endX,endY,angle);
        bgGenerationSet.addToList(s1);
        System.out.print("Simulating");
        Thread barkThread = new Thread(new BGGenerationSet.GrowthImplementationThread());
        barkThread.start();

        while(bgGenerationSet.growthEnd == false){
            Thread.sleep(100);
        }
        System.out.println("\nSimulation Ended");
    }


}
