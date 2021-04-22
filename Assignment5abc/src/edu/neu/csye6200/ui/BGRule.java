package edu.neu.csye6200.ui;

public interface BGRule {
    //Check if Stem has reached maximum length
    boolean maxLengthAchieved();
    //Calculate current coordinates of the stem while it grows
    boolean quarterLengthAchieved();

    boolean threeQuarterLengthAchieved();

    boolean halfLengthAchieved();

    boolean mainStemPoint1Length();

    boolean mainStemPoint2Length();

}
