package edu.src.csye6200;

public class BGRule {
    public void calculateLength(Stem stem){
        stem.length = Math.sqrt(Math.pow((stem.currX - stem.startX), 2) + Math.pow((stem.currY - stem.startY), 2));
    }
    public void calculateMaxLength(Stem stem){
        stem.maxLength = Math.sqrt(Math.pow((stem.endX - stem.startX), 2) + Math.pow((stem.endY - stem.startY), 2));
    }

    public void calculateEndPointLeft(Stem stem){
        double radianAngle = Math.toRadians(stem.angle);
        stem.endX = stem.startX - (150 * Math.sin(radianAngle));
        stem.endY = stem.startY + (150 * Math.cos(radianAngle));
    }

    public void calculateEndPointRight(Stem stem){
        double radianAngle = Math.toRadians(stem.angle);
        stem.endX = stem.startX + (150 * Math.sin(radianAngle));
        stem.endY = stem.startY + (150 * Math.cos(radianAngle));
    }

    public void returnTempEndPointLeft(Stem stem){
        double slope = (stem.endY - stem.startY)/ (stem.endX-stem.startX);
        double constant = stem.startY - (slope * stem.startX);
        stem.currX -= 0.5;
        stem.currY = (slope * stem.currX) + constant;
    }

    public void returnTempEndPointRight(Stem stem){
        double slope = (stem.endY - stem.startY)/ (stem.endX-stem.startX);
        double constant = stem.startY - (slope * stem.startX);
        stem.currX += 0.5;
        stem.currY = (slope * stem.currX) + constant;
    }
}
