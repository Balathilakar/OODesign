package cracking.code.interviewQ.CallCenter.OODesign;

public class Manager extends Employee {
	
	public Manager(CallHandler callHandler){
		super(callHandler);
		rank = Rank.Manager;
	}
	
}
