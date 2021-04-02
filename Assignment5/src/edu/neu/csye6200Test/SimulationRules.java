package edu.neu.csye6200Test;

import java.util.ArrayList;

public class SimulationRules {
    static ArrayList<Stem> stemList = new ArrayList<Stem>();


    /*
    This thread grows length of each stem/branch in the stemList by 1 unit, implementation is in the stem class
     */
    public static class GrowthImplementationThread implements Runnable{
        @Override
        public void run() {
            try{
                do{
                    Thread.sleep(10000);
                    for(Stem stem : stemList){
                        stem.changeLength(stem);
                    }
                }
                while (true);

            }
            catch(Exception ex){

            }
        }
    }

    public static class NewBranchGeneratorThead implements Runnable{
        @Override
        public void run(){
            try{
                Thread.sleep(10000);
                for(Stem stem : stemList){

                }
            }
            catch(Exception ex){

            }

        }

    }


}
