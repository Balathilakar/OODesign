package cracking.code.interviewQ.CallCenter.OODesign;

public enum Rank {
	Responder(0), Manager(1), Director(2);
	
	int value;
	
	private Rank(int v){
		value = v;
	}
	
	public int getValue(){
		return value;
	}

}
