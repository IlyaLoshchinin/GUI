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

			String txt = a.getTextToWrite();

			while (txt != null) {
				System.out.println(txt);
				txt = a.getTextToWrite();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
