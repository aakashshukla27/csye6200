package edu.neu.csye6200.agency;

import java.io.IOException;

public class Vehicle {
    int passengers, fuelCap, modelYear;
    double kpl, range;
    String make, model, licensePlate;


    /**
     * Vehicle Constructor
     *
     * @params passengers - seating capacity
     * @params fuelCap - Fuel tank capacity
     * @params kpl - kilometers run per litre of fuel
     * @params make - Brand
     * @params model - Car model
     * @params licensePlate - Car license number
     */
    public Vehicle(int passengers, int fuelCap, double kpl, String make, String model, int modelYear, String licensePlate) throws IOException {
        setPassengers(passengers);
        this.fuelCap = fuelCap;
        this.kpl = kpl;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        setRange(fuelCap, kpl);
        this.licensePlate = licensePlate;
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

    public String toString() {
        return "\n\tVehicle Make: " + this.make +
                "\n\tVehicle Model: " + this.model +
                "\n\tTank Capacity: " + this.fuelCap + " litres" +
                "\n\tPassenger Capacity: " + this.passengers +
                "\n\tMileage: " + this.kpl + " kilometers per litre" +
                "\n\tRange: " + this.range + " kilometers" +
                "\n\tModel Year: " + this.modelYear +
                "\n\tLicense Plate: " + this.licensePlate + "\n";
    }

}
