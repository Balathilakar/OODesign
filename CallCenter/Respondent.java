package cracking.code.interviewQ.CallCenter.OODesign;

public class Respondent extends Employee {
	
	public Respondent(CallHandler callHandler){
		super(callHandler);
		rank = Rank.Responder;
	}
	

}
