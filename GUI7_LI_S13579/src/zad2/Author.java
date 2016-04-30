/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.util.concurrent.LinkedBlockingQueue;

public class Author implements Runnable {

	String[] s;
	
	LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public Author(String[] args) {
		if (args != null) {
			s = new String[args.length];
			for (int i = 0; i < args.length; i++) {
				s[i] = args[i];
			}
		}
	}

	@Override
	public void run() {

		for (int i = 0; i < s.length; i++) {
			try {
				Thread.sleep(1000);
				setTextToWrite(s[i]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	 void setTextToWrite(String s) throws InterruptedException {
			 queue.put(s);
	}

	String getTextToWrite() throws InterruptedException {
			return queue.take();
	}

}
