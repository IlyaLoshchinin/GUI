package zad1;

import java.util.ArrayList;

public class WatekB implements Runnable {

	volatile boolean flag = false;
	private int WagaSumObiektow = 0;
	private ArrayList<Towar> listA = WatekA.listA;
	WatekA a;

	public WatekB(WatekA a) {
		this.a = a;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {

		synchronized (listA) {
			while (!flag) {
				try {
					listA.wait();
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}
			int i = 0;
			int licz = 0;

			while (!Thread.interrupted() && flag) {

				if (!listA.isEmpty()) {
					for (; i < listA.size(); i++) {
						WagaSumObiektow += listA.get(i).getWagaT();
						licz++;
						if (licz % 100 == 0) {
							System.out.println("policzono wage " + licz
									+ " towarów");
						}
					}
				}
				try {
					listA.notify();
					listA.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}
		System.out.println(WagaSumObiektow);

	}

}
