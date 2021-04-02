package edu.src.csye6200;

import java.util.ArrayList;

public class Type1SimulationHelper {

    public Stem createMainStem(){
        //BGGenerationSet.stemList.clear();
        return new Stem(1, 600, 600, 600, 600, 600, 150, 1, 90, 1);
    }

    public Stem createMainStemTest(double startX, double startY, double endX, double endY, int angle){
        return new Stem(1, startX, startY, startX, startY, endX, endY, 1, angle, 1);
    }

    public Stem createSubBranch(double startX, double startY, int length, int angle){
        if(angle == 45){
            return new Stem(BGGenerationSet.getMasterStemLength() + 1, startX, startY, startX, startY, startX+100,
                    startY - 100, 0, 45 , 0);
        }
        else if(angle == (135)){
            return new Stem(BGGenerationSet.getMasterStemLength() + 1, startX, startY, startX, startY, startX-100,
                    startY - 100, 0, 135 , 0);
        }
        else{
            return new Stem(BGGenerationSet.getMasterStemLength() + 1, startX, startY, startX, startY, startX,
                    startY - 100, 0, 90 , 1);
        }
    }
    public Stem createLeaves(double startX, double startY, int length, int angle){
        if(angle == 90){
            return new Stem(BGGenerationSet.getMasterStemLength() + 1, startX, startY, startX, startY, startX,
                    startY - length, 0, angle , 1);
        }
        if(angle == 0){
            return new Stem(BGGenerationSet.getMasterStemLength() + 1, startX, startY, startX, startY, startX + length,
                    startY, 0, angle , 1);
        }
        else{
            return new Stem(BGGenerationSet.getMasterStemLength() + 1, startX, startY, startX, startY, startX - length,
                    startY, 0, angle , 1);
        }
    }



}
