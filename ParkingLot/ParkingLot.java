package cracking.code.interviewQ.ParkingLot.OODesign;

/*The Parking Lot class is essentially a wrapper class for an array of Levels.*/
public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 3;
	
	public ParkingLot(){
		levels = new Level[NUM_LEVELS];
		for(int i = 0;i < NUM_LEVELS;i++){
			levels[i] = new Level(i,10);
		}
	}
	
	/*Park the vehicle in a spot(or multiple spot). Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle){
		for(int i = 0; i < levels.length;i++){
			if(levels[i].parkVehicle(vehicle)){
				return true;
			}
		}
		return false;
	}
	
	public void print(){
		for(int i = 0; i < levels.length;i++){
			System.out.print("Level"+i+": ");
			levels[i].print();
		}
	}
	

}
