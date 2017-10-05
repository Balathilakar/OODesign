package cracking.code.interviewQ.ParkingLot.OODesign;

public class Question {
	
	public static void main(String ag[]){
		
		ParkingLot lot = new ParkingLot();
		
		Vehicle v = null;
		
		while(v == null || lot.parkVehicle(v)){
			lot.print();
			int r = (int) (Math.random()*10);
			
			if(r < 8){
				v = new Bus();
			}else if(r < 2){
				v = new Motorcycle();
			}else {
				v = new Car();
			}
			
			System.out.print("Parking a ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking failed. Final state: ");
		lot.print();
	}

}
