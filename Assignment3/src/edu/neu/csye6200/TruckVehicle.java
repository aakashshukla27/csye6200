package edu.neu.csye6200;

import java.io.IOException;

public class TruckVehicle extends Vehicle{

    int height, width, length;
    long cargoArea;

    /**
     * Vehicle Constructor
     *
     * @param passengers
     * @param fuelCap
     * @param kpl
     * @param make
     * @param model
     * @param modelYear
     * @param licensePlate
     * @params passengers - seating capacity
     * @params fuelCap - Fuel tank capacity
     * @params kpl - kilometers run per litre of fuel
     * @params make - Brand
     * @params model - Car model
     * @params licensePlate - Car license number
     */
    public TruckVehicle(int passengers, int fuelCap, double kpl, String make, String model,
                        int modelYear, String licensePlate, int height, int width, int length) throws IOException {

        super(passengers, fuelCap, kpl, make, model, modelYear, licensePlate);
        this.height = height;
        this.width = width;
        this.length = length;
        this.cargoArea = height * width * length;
    }

    /***
     * calculates cargo volume
     */
    public void calculateCargoArea(){
        System.out.println("The cargo area is : " + this.cargoArea + " cubic units.");
    }

    /***
     *
     * @return vehicle details
     */
    public String printDetails(){
        String tempString = "Length: " + this.length +
                "\nWidth: " + this.width+
                "\nHeight: " + this.height+
                "\nCargo Volume: " + this.cargoArea;

        return this.toString() + tempString;
    }

}
