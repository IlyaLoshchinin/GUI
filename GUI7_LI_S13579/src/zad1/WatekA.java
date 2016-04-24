package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WatekA implements Runnable {

	Pattern p;
	Matcher m;
	WatekB b;

	static volatile ArrayList<Towar> listA = new ArrayList<Towar>();

	public ArrayList<Towar> listA() {
		return listA;
	}

	public void setLinkToB(WatekB b) {
		this.b = b;
	}

	@Override
	public void run() {

		synchronized (listA) {
			try {
				p = Pattern.compile("(\\d+(?=\\s*))(\\s*\\d+)");
				BufferedReader bufReader = new BufferedReader(new FileReader(
						"../Towary.txt"));
				StringBuffer str = new StringBuffer();

				String line;
				while ((line = bufReader.readLine()) != null) {
					str.append(line).append("\n");
				}
				bufReader.close();

				String s = str.toString();
				m = p.matcher(s);

				b.setFlag(true);

				while (!Thread.interrupted() && m.find()) {

					listA.add(new Towar(Integer.parseInt(m.group(1)), Integer
							.parseInt(m.group(2).substring(1))));

					if (listA.size() % 200 == 0) {
						System.out.println("utworzono " + listA.size()
								+ " obiektów");
						try {
							listA.notify();
							listA.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} // koniec while

			} catch (IOException e) {
				e.printStackTrace();
			}

			listA.notify();
			b.setFlag(false);
		}
	}

}
