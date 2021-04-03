package edu.src.csye6200;

public class Stem implements GenerationValidator{
    BGRule bgRule = new BGRule();
    int id;
    double length;
    double startX,startY, endX, endY, currX, currY;
    int angle;
    int age;
    int category;
    double maxLength;

    public Stem(int id, double startX, double startY, double currX, double currY,double endX, double endY, int age, int angle, int category){
        this.id = id;
        this.length = 0;
        this.startX = startX;
        this.startY = startY;
        this.currX = currX;
        this.currY = currY;
        this.age = age;
        this.angle = angle;
        this.category = category;
        this.endX = endX;
        this.endY = endY;
        calculateMaxLength();
    }
    public void calculateMaxLength(){
        bgRule.calculateMaxLength(this);
    }

    public boolean maxLengthAchieved() {
        Stem stem = this;
        bgRule.calculateLength(this);
        if((this.currX == this.endX)&&(this.currY == this.endY)){
            return true;
        }
        else if(this.length >= this.maxLength){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean quarterLengthReached(){
        Stem stem = this;
        bgRule.calculateLength(this);
        if(this.length == this.maxLength/4){
            return true;
        }
        else{
            return false;
        }
    }


    public void calculateEndPointLeft() {
        Stem stem = this;
        bgRule.calculateEndPointLeft(this);
    }


    public void calculateEndPointRight() {
        Stem stem = this;
        bgRule.calculateEndPointRight(this);
    }


    public void calculateTempEndPointRight() {

        bgRule.returnTempEndPointRight(this);
    }


    public void calculateTempEndPointLeft() {

        bgRule.returnTempEndPointLeft(this);
    }

    public void calculateLength(){
        Stem stem = this;
        bgRule.calculateLength(this);

    }
}
