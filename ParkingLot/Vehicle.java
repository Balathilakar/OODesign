package cracking.code.interviewQ.ParkingLot.OODesign;

import java.util.ArrayList;

abstract public class Vehicle {

	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;
	
	public int getSpotsNeeded(){
		return spotsNeeded;
	}
	
	public VehicleSize getSize(){
		return size;
	}
	
	/*Parking vehicle in this spot(among others, potentially.)*/
	public void parkInSpot(ParkingSpot spot){
		parkingSpots.add(spot);
	}
	
	/*Remove car from spot, and notify spot that its gone.*/
	public void clearSpots(){
		for(int i = 0; i < parkingSpots.size();i++){
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}
	
	
	abstract boolean canFitInSpot(ParkingSpot spot);
	abstract void print();
	
}
