package cracking.code.interviewQ.ParkingLot.OODesign;

/*Represents a level in a parking garage*/

public class Level {
	
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0; // number of free spots
	private static int SPOT_PER_ROW = 5;
	
	public Level(int flr, int numberSpots)
	{
		floor = flr;
		spots = new  ParkingSpot[numberSpots];
				
		int largeSpots = numberSpots/4;
		int bikeSpots = numberSpots/4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;
		
		for(int i = 0;i < numberSpots;i++){
				VehicleSize sz = VehicleSize.MotorCycle;
				if(i < largeSpots){
					sz = VehicleSize.Large;
				}else if(i < largeSpots + compactSpots){
					sz = VehicleSize.Compact;
				}
				int row = i/SPOT_PER_ROW;
				spots[i] = new ParkingSpot(this,row,i, sz);
		}
		availableSpots = numberSpots;
	}
	
	public int availableSpots(){
		return availableSpots;
	}
	
	/*Try to find place to park this vehicle. return false if failed*/
	public boolean  parkVehicle(Vehicle vehicle){
		if(availableSpots() < vehicle.getSpotsNeeded()){
			return false;
		}
		int spotNumber = findAvailableSpots(vehicle);
		
		if(spotNumber < 0){
			return false;
		}
		return parkStartingAtSpot(spotNumber,vehicle);
	}
	
	/*Park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded.*/
	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle){
		vehicle.clearSpots();
		boolean success = true;
		for(int i = spotNumber;i < spotNumber + vehicle.spotsNeeded;i++){
			success &= spots[i].park(vehicle);
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}
	
	/* find a spot to park this vehicle. return index of spot, or -1 on failure */
	private int findAvailableSpots(Vehicle vehicle){
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		
		for(int i = 0; i < spots.length;i++){
				ParkingSpot spot = spots[i];
				if(lastRow != spot.getRow()){
					spotsFound = 0;
					lastRow = spot.getRow();
				}
				if(spot.canFitVehicle(vehicle)){
					spotsFound++;
				}else{
					spotsFound = 0;
				}
				if(spotsFound == spotsNeeded){
					return i - (spotsNeeded - 1);
				}
		}
		return -1;		
	}
	
	public void print(){
		int lastRow = -1;
		for(int i = 0;i < spots.length;i++){
			ParkingSpot spot = spots[i];
			if(spot.getRow() != lastRow){
				System.out.println(" ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
	
	
/* When a car was removed from the spot, Increment availableSpots */	
	public void spotFreed(){
		availableSpots--;
	}

}
