package edu.src.csye6200;

public class Simulator {
    static int simulationType = 1;
    static BGGenerationSet bgGenerationSet = new BGGenerationSet();
    static Type1SimulationHelper type1SimulationHelper = new Type1SimulationHelper();

    public static void main(String[] args) throws InterruptedException {
        run();
    }
    static void run() throws InterruptedException {
        new TreeTest();
        if(simulationType == 1){
            //Stem s1 = type1SimulationHelper.createMainStem();
            Stem s1 = type1SimulationHelper.createMainStemTest(600,600,600,150,90);
            bgGenerationSet.addToList(s1);
        }
        System.out.print("Simulating");
        Thread barkThread = new Thread(new BGGenerationSet.GrowthImplementationThread());
        barkThread.start();

        while(bgGenerationSet.growthEnd == false){
            Thread.sleep(100);
        }
    }
}
