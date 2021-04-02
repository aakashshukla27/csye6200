package edu.src.csye6200;

public interface GenerationValidator {
    boolean maxLengthAchieved();

    void calculateEndPointLeft();

    void calculateEndPointRight();

    void calculateTempEndPointRight();

    void calculateTempEndPointLeft();

    void calculateLength();
    void calculateMaxLength();
}
