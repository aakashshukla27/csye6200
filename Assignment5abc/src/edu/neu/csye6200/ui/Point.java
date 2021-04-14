package edu.neu.csye6200.ui;

public abstract class Point {
    int id;
    //Every stem will have a start, end and current point
    public int startX, startY, endX, endY, currX, currY;
    //Every stem will have a parent from which it is derived
    public int parent;

    public Point(int id, int startX, int startY, int endX, int endY){
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        //Initially currentX and currentY will be same as start pointer
        this.currX = startX;
        this.currY = startY;
        this.endX = endX;
        this.endY = endY;
    }

}
