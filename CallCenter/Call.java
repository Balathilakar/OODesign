package cracking.code.interviewQ.CallCenter.OODesign;


/*Represent a call from a user. calls have a minimum rank and are assigned to the first employee who can
handle that call.*/

public class Call {
	
	/*Minimal rank of employee who can handle this call*/
	private Rank rank;
	
	/*Person who is calling*/
	private Caller caller;
	
	/*Employee who is hanlding the call.*/
	private Employee handler;
	
	public Call(Caller c){
		rank = Rank.Responder;
		caller = c;
	}
	
	/*Set Employee who is handling the call*/
	public void setHanlder(Employee e){
		handler = e;
	}
	
	/*Play recorded message to the customer*/
	public void reply(String message){
		System.out.println(message);
	}
	
	public Rank getRank(){
		return rank;
	}
	
	public void setRank(Rank r){
		rank = r;
	}
	
	public Rank incrementRank(){
		if(rank == Rank.Responder){
			return Rank.Manager;
		}else if(rank == Rank.Manager){
			return Rank.Director;
		}
		return rank;		
	}
	
	/*Disconnect call*/
	public void disconnect(){
		reply("Thank you for calling");
	}
}
