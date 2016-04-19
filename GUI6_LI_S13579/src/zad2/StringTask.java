package zad2;

public class StringTask implements Runnable {
	
	enum TaskState{
		CREATED , RUNNING , ABORTED , READY
	}
	
	private String napis;
	private String plusNapis = "";
	private int iloscVyvolan;
	private TaskState taskState;
	private Thread watek;
	private boolean done = false;
	
	StringTask(String string,int value){
		this.napis = string;
		this.iloscVyvolan = value;
		taskState = TaskState.CREATED;
	}
	
	 public String getResult(){
		     return plusNapis;                 
	 }
	 
	  public TaskState getState(){
		  return taskState;
	  }
	  
	  public void start(){
		 watek = new Thread(this);
		 watek.start();
		 taskState = TaskState.RUNNING;
	  }
	  
	  public void abort(){
		  watek.interrupt();
		  taskState = TaskState.ABORTED;
	  }
	  
	  public boolean isDone(){
		  return done;
	  }
	
	
	@Override
	public void run() {
		int i = 0;
		while(iloscVyvolan-(i++) > 0 && !Thread.interrupted()){
			plusNapis += napis;
			}
	
			if(plusNapis.length() == iloscVyvolan){
				taskState = TaskState.READY;
			}
			done = true;
	}
	
	
	
	
	
}
