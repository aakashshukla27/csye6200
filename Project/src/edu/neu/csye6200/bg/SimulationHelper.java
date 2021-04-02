package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class SimulationHelper{

    /**
     * @return creates tree bark
     */
    public Stem createMainStem(){
        BGGenerationSet.stemList.clear();
        return new Stem(1, 600, 600, 600, 600, 0, 90, 1, true);
    }

    /**
     * creates branches to the left of bark
     * @param radius
     * @param startX
     * @param startY
     * @param angle
     * @return
     */
    public Stem createBranchesLeft(int radius, double startX, double startY, int angle){
        return new Stem(0, startX, startY, startX, startY, 0, angle, 2, false);

    }

    /**
     * creates branches to the right of the bark
     * @param radius
     * @param startX
     * @param startY
     * @param angle
     * @return
     */
    public Stem createBranchesRight(int radius, double startX, double startY, int angle){
        return new Stem(0, startX, startY, startX, startY, 0, angle, 0, false);
    }




}
