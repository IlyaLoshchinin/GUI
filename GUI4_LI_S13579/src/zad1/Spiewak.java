/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad1;

public abstract class Spiewak {
	private String nazwisko;
	private int numerStartowy = 0;
	private String text = spiewaj();

	public static int numer = 0;

	public Spiewak(String nazwisko) {
		this.numerStartowy = ++numer;
		this.nazwisko = nazwisko;
	}

	abstract String spiewaj();

	public String toString() {
		return "(" + numerStartowy + ")" + " " + nazwisko + ": " + text;
	}

	static Spiewak najglosniej(Spiewak[] obj) {

		int maks = 0, index = 0, ile = 0;
		for (int j = 0; j < obj.length; j++) {

			for (int i = 0; i < obj[j].text.length(); i++) {
				if (Character.isUpperCase(obj[j].text.charAt(i))) {
					ile++;
				}
			}
			if (ile >= maks) {
				maks = ile;
				index = j;
			}
			ile = 0;

		}

		return obj[index];
	}
}
