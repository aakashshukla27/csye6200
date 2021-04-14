package edu.neu.csye6200.ui;

public class Stem extends Point implements BGRule {

    int id;
    //Every stem will have a start, end and current point
    public int startX, startY, endX, endY, currX, currY;
    //Every stem will have a parent from which it is derived
    public int parent;
    //Every stem will have an angle at which it grows
    public int angle;
    //Every stem will have a category used for color coding
    public int category;
    public boolean stopGrowth;
    public int direction;

    //Constructor for stem class
    public Stem(int id, int startX, int startY, int endX, int endY, int category, int angle, int parent, int direction){
        super(id, startX, startY, endX, endY);
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        //Initially currentX and currentY will be same as start pointer
        this.currX = startX;
        this.currY = startY;
        this.endX = endX;
        this.endY = endY;
        this.category = category;
        this.parent = parent;
        this.angle = angle;
        this.stopGrowth = false;
        this.direction = direction;
    }


    public boolean mainStemPoint1Length(){
        if(this.currY == (this.startY - 150)){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean mainStemPoint2Length(){
        if(this.currY == (this.startY - 300)){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean maxLengthAchieved() {
        if((this.endX == this.currX) && (this.endY == this.currY)){
            //this.stopGrowth = true;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean quarterLengthAchieved(){
        boolean valueToReturn = false;
        switch (this.angle){
            case 0:
            case 360:
                if((this.startX + 25) == this.currX){
                    valueToReturn = true;
                }
                break;
            case 45:
                if(((this.startX + 25) == this.currX) && ((this.currY + 25) == this.startY)){
                    valueToReturn = true;
                }
                break;
            case 90:
                if(this.currY == (this.startY- 25)){
                    valueToReturn = true;
                }
                break;
            case 135:
                if(((this.startX - 25) == this.currX) && ((this.currY + 25) == this.startY)){
                    valueToReturn = true;
                }
                break;
            case 180:
                if((this.startX - 25) == this.currX){
                    valueToReturn = true;
                }
                break;
            case 225:
                if(((this.startX - 25) == this.currX) && ((this.startY + 25) == this.currY)){
                    valueToReturn = true;
                }
                break;
            case 270:
                if(this.currY == this.startY + 25){
                    valueToReturn = true;
                }
                break;
            case 315:
                if(((this.startX + 25) == this.currX) && (this.currY == (this.startY + 25))){
                    valueToReturn = true;
                }
                break;

        }
        return valueToReturn;
    }

    public boolean halfLengthAchieved(){
        boolean valueToReturn = false;
        switch (this.angle){
            case 0:
                if((this.startX + 50) == this.currX){
                    valueToReturn = true;
                }
                break;
            case 45:
                if(((this.startX + 50) == this.currX) && ((this.currY + 50) == this.startY)){
                    valueToReturn = true;
                }
                break;
            case 90:
                if(this.currY == (this.startY- 50)){
                    valueToReturn = true;
                }
                break;
            case 135:
                if(((this.startX - 50) == this.currX) && ((this.currY + 50) == this.startY)){
                    valueToReturn = true;
                }
                break;
            case 180:
                if((this.startX - 50) == this.currX){
                    valueToReturn = true;
                }
                break;
            case 225:
                if(((this.startX - 50) == this.currX) && ((this.startY + 50) == this.currY)){
                    valueToReturn = true;
                }
                break;
            case 270:
                if(this.currY == this.startY + 50){
                    valueToReturn = true;
                }
                break;
            case 315:
                if(((this.startX + 50) == this.currX) && (this.currY == (this.startY + 50))){
                    valueToReturn = true;
                }
                break;
            case 360:
                if((this.startX + 50) == this.currX){
                    valueToReturn = true;
                }

        }
        return valueToReturn;
    }

    public boolean threeQuarterLengthAchieved(){
        boolean valueToReturn = false;
        switch (this.angle){
            case 0:
                if((this.startX + 75) == this.currX){
                    valueToReturn = true;
                }
                break;
            case 45:
                if(((this.startX + 75) == this.currX) && ((this.currY + 75) == this.startY)){
                    valueToReturn = true;
                }
                break;
            case 90:
                if(this.currY == (this.startY- 75)){
                    valueToReturn = true;
                }
                break;
            case 135:
                if(((this.startX - 75) == this.currX) && ((this.currY + 75) == this.startY)){
                    valueToReturn = true;
                }
                break;
            case 180:
                if((this.startX - 75) == this.currX){
                    valueToReturn = true;
                }
                break;
            case 225:
                if(((this.startX - 75) == this.currX) && ((this.startY + 75) == this.currY)){
                    valueToReturn = true;
                }
                break;
            case 270:
                if(this.currY == this.startY + 75){
                    valueToReturn = true;
                }
                break;
            case 315:
                if(((this.startX + 75) == this.currX) && (this.currY == (this.startY + 75))){
                    valueToReturn = true;
                }
                break;
            case 360:
                if((this.startX + 75) == this.currX){
                    valueToReturn = true;
                }
        }
        return valueToReturn;
    }

    public boolean mainStemPoint1LengthSim3(){
        if(this.currY == (this.startY - 200)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean mainStemPoint2LengthSim3(){
        if(this.currY == (this.startY - 250)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean mainStemPoint3LengthSim3(){
        if(this.currY == (this.startY - 300)){
            return true;
        }
        else{
            return false;
        }
    }
}
