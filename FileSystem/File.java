package cracking.code.interviewQ.FileSystem.OODesign;

public class File extends Entry {
	private String contents;
	private int size;
	
	
	public File(String n, Directory p, int sz){
		super(n,p);
		size = sz;
	}
	
	public int size(){
		return size;
	}
	
	public String getContents(){
		return contents;
	}
	
	public void setContents(String c){
		contents = c;
	}
	

}
