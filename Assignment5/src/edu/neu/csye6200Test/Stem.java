package edu.neu.csye6200Test;

public class Stem {

    private int id;
    private double length;
    private double startX, startY, endX, endY;
    private int parent;
    private int angle;
    private int age;
    private int category;
    SimulationRules stemList = new SimulationRules();

    /**
     * constructor for stem class
     * @param startX - x initial
     * @param startY - y initial
     * @param endX - x final
     * @param endY - y final
     * @param parent - branch id from where the current branch originates - trunk originates from 0
     * @param angle - polar angle calculated wrt to parent branch
     * @param category - 3 main categories - trunk, branch, leaves
     */

    public Stem(int startX, int startY, int endX, int endY, int parent, int angle, int category){
        this.id = stemList.stemList.size()+1;
        this.length = 0;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.parent = parent;
        this.angle = angle;
        this.category = category;
        stemList.stemList.add(this);
    }

    /**
     * Change the length of stem by 1 unit, maximum height will be capped at 200
     * @param stem
     */
    public void changeLength(Stem stem){
        stem.length = Math.min(stem.length + 1, 200);
        calculateNewEndPoint(stem);
    }

    /**
     * Calculate the new coordinates of the end points after implementing the growth
     * @param stem
     */
    public void calculateNewEndPoint(Stem stem){
        if(stem.angle == 90){
            stem.endY = stem.endY - stem.length;
        }
    }


    public void generateNewBranch(Stem stem){
        switch(stem.category){
            case 1:
                if(stem.length >= 25){
                    //new Stem(stem.startX, stem.startY - )
                }
        }
    }


}
