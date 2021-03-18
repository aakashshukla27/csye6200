package edu.neu.csye6200.agency;

public class TestClass {
    public static void main(String[] args) {
        VehicleRegistrySingleton s = VehicleRegistrySingleton.getInstance();

//        s.vehicleInventory.add("12 ABCD");
//        s.vehicleDetails.put("12 ABCD", "Test");

        s.getVehicleByLicense("12 ABCD");
    }
}
