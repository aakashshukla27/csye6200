package edu.neu.csye6200.bg;
import java.util.ArrayList;
import java.util.List;
public class Stem {
    BGRule stemList = new BGRule();
    int id;
    double length;
    Enumeration.DirectionOfGrowth direction;
    double age;
    int angleOfGrowth;
    int positionX;
    int positionY;
    int parent;
    public Stem(){
        this.id = stemList.stemList.size();
        this.length = 1;
        this.direction = Enumeration.DirectionOfGrowth.UP;
        this.age = 0;
        this.angleOfGrowth = 90;
        this.positionX = 0;
        this.positionY = -100;
        this.parent = 0;
        stemList.stemList.add(this);
    }

    public Stem(int id, Enumeration.DirectionOfGrowth dg){
        this.id = stemList.stemList.size();
        this.length = 1;
        this.direction = dg;
        this.age = 0;
        this.angleOfGrowth = 90;
        this.positionX = 0;
        this.positionY = -100;
        this.parent = id;
        stemList.stemList.add(this);
    }


}
