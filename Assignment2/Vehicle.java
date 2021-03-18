
/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author Aakash Shukla
 * ID: 001557554
 *
 */
public class Vehicle {
   int passengers;
   int fuelCap;
   double kpl;
   String make, model;
   double range;
   int modelYear;

/**
*Vehicle Constructor
* @params passengers - seating capacity
* @params fuelCap - Fuel tank capacity
* @params kpl - kilometers run per litre of fuel
* @params make - Brand
* @params model - Car model
 */
   public Vehicle(int passengers,int fuelCap, double kpl, String make, String model, int modelYear ){
      //this.passengers = passengers;
      setPassengers(passengers);
      this.fuelCap = fuelCap;
      this.kpl = kpl;
      this.make = make;
      this.model = model;
      this.modelYear = modelYear;
      setRange(fuelCap, kpl);
   }
   public void setRange(int fuelCap, double kpl){
      this.range = fuelCap*kpl;
   }

   public void setPassengers(int passengers){
      if(passengers < 1){
         this.passengers = 1;
      }
      else {
         this.passengers = passengers;
      }
   }

   public String toString(){
      return "\nVehicle Make: " + this.make +
              "\nVehicle Model: " + this.model+
              "\nTank Capacity: " + this.fuelCap+ " litres"+
              "\nPassenger Capacity: " + this.passengers+
              "\nMileage: " + this.kpl + " kilometers per litre"+
              "\nRange: " + this.range + " kilometers"+
              "\nModel Year: " + this.modelYear;
   }



}
