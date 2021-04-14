package edu.src.csye6200;

import java.util.ArrayList;
import java.util.HashMap;

public class BGGenerationSet {
    public static boolean growthEnd = false;
    public static Type1SimulationHelper type1SimulationHelper = new Type1SimulationHelper();
    //public int[] idGrowth = new int[5];
    public static HashMap<Integer, Integer> idGrowth = new HashMap<Integer, Integer>();
    //Master stem list
    public static ArrayList<Stem> stemList = new ArrayList<Stem>();

    //Returns count of elements in the stemList
    public static int getMasterStemLength() {
        return stemList.size();
    }

    //Add elements to main stem list
    public static void addToList(Stem stem) {
        stemList.add(stem);
    }

    public static void growTrunk() throws InterruptedException {
        while (!checkGrowthEnd()) {
            growBranches();
            Thread.sleep(50);
            if (stemList.get(0).length >= 150) {
                if(stemList.get(0).length == 150){
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle - 45);
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle + 45);
                }
                if((stemList.get(0).length > 151) && (stemList.get(0).length < 152)){
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle - 45);
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle + 45);
                }

                if(stemList.get(1).maxLengthAchieved()){
                    if(!idGrowth.containsKey(stemList.get(1).id)){
                        idGrowth.put(stemList.get(1).id, 1);
                        generateLeaves(1, stemList.get(1).angle);

                    }
                }
                if(stemList.get(2).maxLengthAchieved()){
                    if(!idGrowth.containsKey(stemList.get(2).id)){
                        idGrowth.put(stemList.get(2).id, 1);
                        generateLeaves(2, stemList.get(2).angle);

                    }
                }
            }
            if (stemList.get(0).length >= 300) {
                if(stemList.get(0).length == 300){
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle - 45);
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle + 45);
                }
                if((stemList.get(0).length > 301) && (stemList.get(0).length < 302)){
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle - 45);
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, stemList.get(0).angle + 45);
                }


                if(stemList.get(7).maxLengthAchieved()){
                    if(!idGrowth.containsKey(stemList.get(7).id)){
                        idGrowth.put(stemList.get(7).id, 1);
                        generateLeaves(7, stemList.get(7).angle);

                    }
                }
                if(stemList.get(8).maxLengthAchieved()){
                    if(!idGrowth.containsKey(stemList.get(8).id)){
                        idGrowth.put(stemList.get(8).id, 1);

                        generateLeaves(8, stemList.get(8).angle);

                    }
                }
            }
            if(stemList.get(0).maxLengthAchieved()){
                if(!idGrowth.containsKey(stemList.get(0).id)) {
                    idGrowth.put(stemList.get(0).id, 1);
                    createTop(stemList.get(0).angle, 0);
                    createTop(stemList.get(7).angle, 7);
                    createTop(stemList.get(8).angle, 8);
                    createTop(stemList.get(2).angle, 2);
                    createTop(stemList.get(1).angle, 1);
                }
            }
            if(stemList.get(stemList.size()-1).maxLengthAchieved()){
                ArrayList<Stem> tempList = new ArrayList<Stem>();
                for(int i=0; i<stemList.size(); i++){
                    if(stemList.get(i).category == 3){
                        tempList.add(stemList.get(i));
                    }
                }

                for(Stem tempStem: tempList){

                }
            }


        }

    }

    public static void createTop(int angle, int id){
        if(angle == 90){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX + 50, stemList.get(id).currY-50, 0, 45, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX - 50, stemList.get(id).currY-50, 0, 135, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX, stemList.get(id).currY-50, 0, 90, 3));
        }
        if(angle == 0 || angle == 360){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX + 50, stemList.get(id).currY-50, 0, 45, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX + 50, stemList.get(id).currY+50, 0, 315, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX+50, stemList.get(id).currY, 0, 0, 3));
        }
        if(angle == 45){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX, stemList.get(id).currY-50, 0, 90, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX + 50, stemList.get(id).currY, 0, 0, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX+50, stemList.get(id).currY-50, 0, 45, 3));
        }
        if(angle == 135){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX - 50, stemList.get(id).currY, 0, 180, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX, stemList.get(id).currY-50, 0, 90, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX-50, stemList.get(id).currY-50, 0, 135, 3));
        }
        if(angle == 180){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX - 50, stemList.get(id).currY-50, 0, 135, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX - 50, stemList.get(id).currY+50, 0, 225, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX-50, stemList.get(id).currY, 0, 180, 3));
        }
        if(angle == 225){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX, stemList.get(id).currY+50, 0, 270, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX - 50, stemList.get(id).currY, 0, 180, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX-50, stemList.get(id).currY+50, 0, 225, 3));
        }
        if(angle == 270){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX + 50, stemList.get(id).currY+50, 0, 315, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX - 50, stemList.get(id).currY+50, 0, 225, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX, stemList.get(id).currY-50, 0, 270, 3));
        }
        if(angle == 315){
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX + 50, stemList.get(id).currY, 0, 0, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX, stemList.get(id).currY+50, 0, 270, 2));
            stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(id).currX, stemList.get(id).currY,
                    stemList.get(id).currX, stemList.get(id).currY, stemList.get(id).currX+50, stemList.get(id).currY+50, 0, 315, 3));
        }
    }

    public static void generateLeaves(int id, int angle){
        if(stemList.get(id).angle == 45){
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY + 50, 50, angle+45);
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY + 50, 50, angle - 45);

        }
        if(stemList.get(id).angle == 135){
            createNewLeaves(stemList.get(id).currX + 50, stemList.get(id).currY + 50, 50, angle-45);
            createNewLeaves(stemList.get(id).currX + 50, stemList.get(id).currY + 50, 50, angle+45);
        }
        if(stemList.get(id).angle == 90){
            createNewLeaves(stemList.get(id).currX ,stemList.get(id).currY + 50, 50, angle+45);
            createNewLeaves(stemList.get(id).currX, stemList.get(id).currY + 50, 50, angle - 45);

        }
        if(stemList.get(id).angle == 0 || stemList.get(id).angle == 360){
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY, 50, 315);
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY, 50, angle+45);
        }
        if(stemList.get(id).angle == 180){
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY, 50, 225);
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY, 50, 135);
        }
        if(stemList.get(id).angle == 270){
            createNewLeaves(stemList.get(id).currX, stemList.get(id).currY - 50, 50, 315);
            createNewLeaves(stemList.get(id).currX, stemList.get(id).currY - 50, 50, 225);
        }
        if(stemList.get(id).angle == 315){
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY - 50, 50, 0);
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY - 50, 50, 270);
        }
        if(stemList.get(id).angle == 225){
            createNewLeaves(stemList.get(id).currX + 50, stemList.get(id).currY - 50, 50, 180);
            createNewLeaves(stemList.get(id).currX + 50, stemList.get(id).currY - 50, 50, 270);
        }

    }

    public static void growBranches() {
        for (Stem stem : stemList) {
            if (!stem.maxLengthAchieved()) {
                if (stem.angle == 90) {
                    stem.currY -= 1;
                    stem.calculateLength();
                }
                if (stem.angle == 45) {
                    stem.currX += 1;
                    stem.currY -= 1;
                    stem.calculateLength();
                }
                if (stem.angle == 135) {
                    stem.currX -= 1;
                    stem.currY -= 1;
                    stem.calculateLength();
                }
                if(stem.angle == 0){
                    stem.currX += 1;
                    stem.calculateLength();
                }
                if(stem.angle == 180){
                    stem.currX -= 1;
                    stem.calculateLength();
                }
                if(stem.angle == 225){
                    stem.currX -= 1;
                    stem.currY += 1;
                    stem.calculateLength();
                }
                if(stem.angle == 270){
                    stem.currY += 1;
                    stem.currX = stem.currX;
                    stem.calculateLength();
                }
                if(stem.angle == 315){
                    stem.currX += 1;
                    stem.currY += 1;
                    stem.calculateLength();
                }
            }

            System.out.println(stem.id + " " + stem.length);
            TreeTest.myPanel.removeAll();
            TreeTest.myPanel.revalidate();
            TreeTest.myPanel.repaint();
        }
    }

    public static boolean checkGrowthEnd() {

        for (int i = 0; i < stemList.size(); i++) {
            if (!stemList.get(i).maxLengthAchieved()) {
                return false;
            }
        }
        growthEnd = true;
        return true;
    }

    public static class GrowthImplementationThread implements Runnable {
        @Override
        public void run() {
            while (!checkGrowthEnd()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    growTrunk();
                    Simulator.displayList.add(stemList);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createNewBranches(double startX, double startY, int length, int angle) {
        stemList.add(type1SimulationHelper.createSubBranch(startX, startY, length, angle));
    }
    public static void createNewLeaves(double startX, double startY, int length, int angle) {
        stemList.add(type1SimulationHelper.createLeaves(startX, startY, length, angle));
    }
}