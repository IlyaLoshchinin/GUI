/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad1;

public class Main {

	public static void main(String[] args) {
		WatekA w1 = new WatekA();
		WatekB b = new WatekB(w1);
		w1.setLinkToB(b);

		Thread wA = new Thread(w1);
		Thread wB = new Thread(b);

		wA.start();
		wB.start();

	}
}
