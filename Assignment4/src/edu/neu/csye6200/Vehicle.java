package edu.neu.csye6200;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * CSYE 6200 Vehicle starter class
 *
 * @author Aakash Shukla
 * ID: 001557554
 */
public class Vehicle{
    int passengers, fuelCap, modelYear;
    double kpl, range;
    String make, model, licensePlate;
    VehicleRegistry t = new VehicleRegistry();

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

    public void WriteToFile(Vehicle data) throws IOException {
        HashMap<String, String> vehicleDetailsHelper = new HashMap<String, String>();
        vehicleDetailsHelper.put("Make", data.make);
        vehicleDetailsHelper.put("Model", data.model);
        vehicleDetailsHelper.put("Year",String.valueOf(data.modelYear));
        vehicleDetailsHelper.put("Capacity", String.valueOf(data.passengers));
        vehicleDetailsHelper.put("Tank", String.valueOf(data.fuelCap));
        vehicleDetailsHelper.put("Mileage", String.valueOf(data.kpl));
        vehicleDetailsHelper.put("Range", String.valueOf(data.range));
        vehicleDetailsHelper.put("License", data.licensePlate);
        RentalAgencyIO fw = new RentalAgencyIO();
        fw.WriteToFile(vehicleDetailsHelper, data.licensePlate);
    }

}
