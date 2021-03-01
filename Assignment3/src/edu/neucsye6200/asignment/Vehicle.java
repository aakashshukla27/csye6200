package edu.neucsye6200.asignment;
import edu.neu.csye6200.VehicleRegistry;

import java.io.IOException;
import java.util.HashMap;

/**
 * CSYE 6200 Vehicle starter class
 *
 * @author Aakash Shukla
 * ID: 001557554
 */
public class Vehicle {
    int passengers, fuelCap, modelYear;
    double kpl, range;
    String make, model, licensePlate;
    VehicleRegistry t = new VehicleRegistry();
    public Vehicle(int passengers, int fuelCap, double kpl, String make, String model, int modelYear, String licensePlate) throws IOException {
        setPassengers(passengers);
        this.fuelCap = fuelCap;
        this.kpl = kpl;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        setRange(fuelCap, kpl);
        this.licensePlate = licensePlate;
        addDetailsToInventory(licensePlate, make + " " + model);
        WriteToFile(this);
    }
    /**
     * @param fuelCap
     * @param kpl     returns the vehicle range
     */
    public void setRange(int fuelCap, double kpl) {
        this.range = fuelCap * kpl;
    }

    /**
     * @param passengers
     * @set sets max number of passengers in vehicle
     */
    public void setPassengers(int passengers) {
        if (passengers < 1) {
            this.passengers = 1;
        } else {
            this.passengers = passengers;
        }
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @return formatted string of vehicle details
     */
    public String toString() {
        return "\nVehicle Make: " + this.make +
                "\nVehicle Model: " + this.model +
                "\nTank Capacity: " + this.fuelCap + " litres" +
                "\nPassenger Capacity: " + this.passengers +
                "\nMileage: " + this.kpl + " kilometers per litre" +
                "\nRange: " + this.range + " kilometers" +
                "\nModel Year: " + this.modelYear +
                "\nLicense Plate: " + this.licensePlate + "\n";
    }

    public void addDetailsToInventory(String licensePlate, String model) {

        t.AddVehicleDetails(licensePlate, model);
    }
}
