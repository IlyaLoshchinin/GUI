/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

public class Writer implements Runnable {

	Author a;
	
	public Writer(Author autor) {
		a = autor;
	}

	@Override
	public void run() {
		try {
			
			String txt;
			for (int i = 0; i < a.s.length; i++) {
				txt = a.getTextToWrite();
				System.out.println(txt);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
