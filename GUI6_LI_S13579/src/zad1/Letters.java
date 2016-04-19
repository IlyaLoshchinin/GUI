package zad1;

public class Letters implements Runnable{
	
	private String str;
	private char name;
	Thread[] wiatek;
	
	public Letters(char name){
		this.name = name; 
	}
	
	public Letters(String string) {
		str = string;
		wiatek = new Thread[str.length()];
		int i = 0;
		for ( i = 0; i < wiatek.length-1; i++) {
			name = str.charAt(i);
			wiatek[i] = new Thread(new Letters(name), "Thread " + str.charAt(i));
		}
		
		char b = str.charAt(i);
		 Runnable letRun = () -> {
			while (!Thread.interrupted()) {
				System.out.print(b);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		};
		
		wiatek[i] = new Thread(letRun, "Thread " + str.charAt(i));
			
	}

	public Thread[] getThreads() {
		return wiatek;
	}

	@Override
	public void run() {
		
		while (!Thread.interrupted()) {
			System.out.print(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	

}
