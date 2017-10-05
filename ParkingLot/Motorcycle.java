package cracking.code.interviewQ.ParkingLot.OODesign;

public class Motorcycle extends Vehicle {
	
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.MotorCycle;
	}
	
	public boolean canFitInSpot(ParkingSpot spot){
		return spot.getSize() == VehicleSize.MotorCycle;
	}
	
	public void print(){
		System.out.print("M");
	}

}
