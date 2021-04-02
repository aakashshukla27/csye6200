package edu.neu.csye6200.bg;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BGGenerationSet extends TreeTest{
    //Master stem list
    public static ArrayList<Stem> stemList = new ArrayList<Stem>();
    //Master flower list
    public static ArrayList<ArrayList<Double>> flowerList = new ArrayList<ArrayList<Double>>();
    //Returns count of elements in the stemList
    public int getMasterStemLength(){
        return stemList.size();
    }
    //Add elements to main stem list
    public void addToList(Stem stem){
        stemList.add(stem);
    }

    static Random random = new Random();
    public static boolean growthEnd = false;
    public static boolean growFlowers = false;
    /**
     *  Function to grow branches
     */
    public static void growBranches(){
            for(Stem stem: stemList){
                if(stem.category == 1){
                    if(!stem.maxLengthAchieved()){
                        stem.currY -= 10;
                    }
                }
                stem.calculateLength();
                if(stemList.get(0).length > 300) {
                    if (!stem.maxLengthAchieved()) {

                        if (stem.category == 0) {
                            stem.calculateTempEndPointRight();
                            stem.calculateLength();
                        }
                        if (stem.category == 2) {
                            stem.calculateTempEndPointLeft();
                            stem.calculateLength();
                        }
//                        if(random.nextInt(5) == 1){
//                            growFruits();
//                        }

                    }
                }
                /**
                 * this part is executed once the bark has achieved its maximum possible length
                 */
//                else if(stemList.get(0).maxLengthAchieved()){
//                    if(!stem.maxLengthAchieved()){
//
//                        if(stem.category == 0){
//                            stem.calculateTempEndPointRight();
//                            stem.calculateLength();
//                        }
//                        if(stem.category == 2){
//                            stem.calculateTempEndPointLeft();
//                            stem.calculateLength();
//                        }
////                        if(random.nextInt(5) == 1){
////                            growFruits();
////                        }
//
//                    }
                    if(checkGrowthEnd()){
                        growthEnd = true;
                        growFlowers = true;
                    }
//                }

                System.out.println(stem.id + " " + stem.length);
                TreeTest.myPanel.removeAll();
                TreeTest.myPanel.revalidate();
                TreeTest.myPanel.repaint();
            }
    }

    /**
     *Check if growth has stopped in all branches
     * @return
     */
    public static boolean checkGrowthEnd(){

        for(int i=0; i<stemList.size(); i++){
            if(!stemList.get(i).maxLengthAchieved()){
                return false;
            }
        }
        return true;
    }




    public static class GrowthImplementationThread implements Runnable{
        @Override
        public void run(){
            while(!growthEnd){
                try {
                    Thread.sleep(50);
                    growBranches();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void growFruits(){

        int[] tempArray = new int[10];
        for(int i=0; i<10; i++){
            tempArray[i] = ThreadLocalRandom.current().nextInt(1, stemList.size());
        }
        for (int i: tempArray) {
            Stem stem = stemList.get(i);
            ArrayList<Double> temp = new ArrayList<Double>();
            temp.add(stem.currX);
            temp.add(stem.currY);
            flowerList.add(temp);
        }

    }

}
