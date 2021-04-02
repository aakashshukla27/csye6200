package edu.neu.csye6200.bg;


public class Stem implements GenerationValidator{
    BGRule bgRule = new BGRule();
    protected int id;
    protected double length;
    protected double startX, startY, endX, endY, currX, currY;
    protected int angle;
    protected int age;
    protected int category;
    protected boolean bark;

    public Stem(int id, double startX, double startY, double currX, double currY, int age, int angle, int category, boolean bark){
        this.id = id;
        this.length = 0;
        this.startX = startX;
        this.startY = startY;
        this.currX = currX;
        this.currY = currY;
        this.age = age;
        this.angle = angle;
        this.category = category;
        this.bark = bark;
        if(category == 2){
            calculateEndPointLeft();
        }
        if(category == 0){
            calculateEndPointRight();
        }
        if(category == 1){
            this.endX = startX;
            this.endY = startY - 300;
        }
    }

    public Stem(){

    }


    public boolean maxLengthAchieved() {
        Stem stem = this;
        bgRule.calculateLength(this);
        if(stem.category == 1){
            if(stem.length >= 450){
                return true;
            }
            else{
               return false;
            }
        }

        else if(stem.category == 2 || stem.category == 0){
            if(stem.length >= 150){
                stem.length = 150;
                stem.currY = stem.endY;
                stem.currX = stem.endX;
                return true;
            }
            else if(stem.length >= 149.9 && stem.length<=150){
                stem.length = 150;
                stem.currY = stem.endY;
                stem.currX = stem.endX;
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return true;
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
        if(stem.category == 2 || stem.category == 0){
            if(stem.length >= 150) {
                stem.length = 150;
                stem.currY = stem.endY;
                stem.currX = stem.endX;
            }
        }
    }
}


