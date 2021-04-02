package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class Simulator {
    static BGGenerationSet bgGenerationSet = new BGGenerationSet();
    static SimulationHelper simulationHelper = new SimulationHelper();
    static int width = 0, height = 0;

    static int simulationType = 1;
    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {
        new TreeTest();

        if(simulationType == 1){
            Stem s1 = simulationHelper.createMainStem();
            bgGenerationSet.addToList(s1);
            for(int i=1; i<180; i+=5){
                Stem sL = simulationHelper.createBranchesLeft(150, s1.endX, s1.endY, i);
                Stem sR = simulationHelper.createBranchesRight(150,s1.endX, s1.endY, i);
                sL.id = bgGenerationSet.getMasterStemLength() + 1;
                bgGenerationSet.addToList(sL);
                sR.id = bgGenerationSet.getMasterStemLength() + 1;
                bgGenerationSet.addToList(sR);
            }
        }
        if(simulationType == 2){
            Stem s1 = simulationHelper.createMainStem();
            bgGenerationSet.addToList(s1);

        }




//        while(bgGenerationSet.growthEnd == false){
//            bgGenerationSet.growBranches();
//        }

        System.out.print("Simulating");
        Thread barkThread = new Thread(new BGGenerationSet.GrowthImplementationThread());
        barkThread.start();

        while(bgGenerationSet.growthEnd == false){
            Thread.sleep(100);
        }
        System.out.print("Stopped");

    }
}
