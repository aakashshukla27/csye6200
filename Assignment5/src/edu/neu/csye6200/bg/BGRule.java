package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class BGRule extends Stem{
    ArrayList<Stem> stemList = new ArrayList<Stem>();

    public class GrowthImplementationThread implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(1000);
                for (Stem stem: stemList) {
                    stem.length = Math.min(stem.length + 1, 100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public class NewBranchThread implements Runnable{
        @Override
        public void run(){
            try{
                Thread.sleep(1000);
                for(Stem stem : stemList){
                    if(stem.length == 5){
                        Stem newStem1 = new Stem(stem.id, Enumeration.DirectionOfGrowth.LEFT);
                        Stem newStem2 = new Stem(stem.id, Enumeration.DirectionOfGrowth.RIGHT);
                    }
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
