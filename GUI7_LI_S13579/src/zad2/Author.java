/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.util.concurrent.LinkedBlockingQueue;

public class Author implements Runnable {

	volatile String txt = null;
	volatile boolean newTxt = false;
	String[] s;

	static LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();

	public Author(String[] args) {
		if (args != null) {
			s = new String[args.length + 1];
			int i = 0;
			for (i = 0; i < args.length; i++) {
				s[i] = args[i];
			}
			s[i] = null;
		}
	}

	@Override
	public void run() {

		for (int i = 0; i < s.length; i++) {
			try {
				Thread.sleep(1000);
				setTextToWrite(s[i]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void setTextToWrite(String s) throws InterruptedException {
		while (newTxt == true) {
			queue.put(this);
		}
		txt = s;
		newTxt = true;
		try {
			queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	String getTextToWrite() throws InterruptedException {
		while (newTxt == false) {
			queue.put(this);
		}
		newTxt = false;
		queue.take();
		return txt;
	}

}
