package zad2;

public class ReversibleString implements Reversible {
	private String str;

	public ReversibleString(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}

	@Override
	public Reversible reverse() {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += this.str.charAt(i);
		}
		str = rev;
		return this;
	}
}
