package edu.neu.csye6200.bg;

public class BGRule {
    public void calculateLength(Stem stem){
        stem.length = Math.sqrt(Math.pow((stem.currX - stem.startX), 2) + Math.pow((stem.currY - stem.startY), 2));
    }

    public void calculateEndPoint(Stem stem){

    }
}
