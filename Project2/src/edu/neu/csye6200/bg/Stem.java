package edu.neu.csye6200.bg;

public class Stem {
    BGRule bgRule = new BGRule();
    protected int id;
    protected double startX, startY, endX, endY, currX, currY;
    protected int angle;
    protected int parent;
    protected double length;
    public Stem(int id, double startX, double startY, int angle, int parent){
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.currX = startX;
        this.currY = startY;
        this.angle = angle;
        this.parent = parent;
        calculateEndPoints();
    }
    public void calculateEndPoints(){
        bgRule.calculateLength(this);
    }
}
