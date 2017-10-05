package cracking.code.interviewQ.CallCenter.OODesign;


/*Employee is a super class for Director, Manager, and Responder classes. It is implemented as an
abstract class, since there is no reason to instantiated an employee type directly.*/

abstract public class Employee {
	
	private Call currentCall = null;
	
	protected Rank rank;
	
	private CallHandler callHandler;
	
	public Employee(CallHandler handler){
		callHandler = handler;
	}
	
	/*Start the conversation*/
	public void receiveCall(Call call){
		currentCall = call;
	}
	
	/*The issue is resolved. finish the call.*/
	public void callCompleted(){
		if(currentCall != null){
			/*Disconnect the call*/
			currentCall.disconnect();
			
			/*Free the employee*/
			currentCall = null;
		}
		
		/*Check if there is a call waiting in the queue*/
		assignNewCall();
	}
	
	/*Assign new call to an employee, if the employee is free*/
	public boolean assignNewCall(){
		if(!isFree()){
			return false;
		}
		return callHandler.assignCall(this);
	}
	
	/*Return whether or not the employee is free*/
	public boolean isFree(){
		return currentCall == null;
	}
	
	public Rank getRank(){
		return rank;
	}
	
}
