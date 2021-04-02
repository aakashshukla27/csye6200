package edu.neu.csye6200.bg;

public interface GenerationValidator {
    boolean maxLengthAchieved();

    void calculateEndPointLeft();

    void calculateEndPointRight();

    void calculateTempEndPointRight();

    void calculateTempEndPointLeft();

    void calculateLength();
}
