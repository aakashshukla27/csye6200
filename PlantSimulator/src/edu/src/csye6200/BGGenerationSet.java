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
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, 45);
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, 135);
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
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, 45);
                    createNewBranches(stemList.get(0).currX, stemList.get(0).currY, 150, 135);
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
                    stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(0).currX, stemList.get(0).currY,
                            stemList.get(0).currX, stemList.get(0).currY, stemList.get(0).currX + 50, stemList.get(0).currY-50, 0, 45, 1));
                    stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(0).currX, stemList.get(0).currY,
                            stemList.get(0).currX, stemList.get(0).currY, stemList.get(0).currX - 50, stemList.get(0).currY-50, 0, 135, 1));
                    stemList.add(new Stem(getMasterStemLength() + 1, stemList.get(0).currX, stemList.get(0).currY,
                            stemList.get(0).currX, stemList.get(0).currY, stemList.get(0).currX, stemList.get(0).currY-50, 0, 90, 1));
                }
            }

        }
    }

    public static void generateLeaves(int id, int angle){
        if(stemList.get(id).angle == 45){
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY + 50, 50, 90);
            createNewLeaves(stemList.get(id).currX - 50, stemList.get(id).currY + 50, 50, 0);

        }
        if(stemList.get(id).angle == 135){
            createNewLeaves(stemList.get(id).currX + 50, stemList.get(id).currY + 50, 50, 90);
            createNewLeaves(stemList.get(id).currX + 50, stemList.get(id).currY + 50, 50, 180);
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