package cracking.code.interviewQ.ParkingLot.OODesign;

public class Car extends Vehicle {
	
	public Car(){
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}
	


	@Override
	boolean canFitInSpot(ParkingSpot spot) {
	return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}

	@Override
	void print() {
		System.out.println("C");
	}
	

}
