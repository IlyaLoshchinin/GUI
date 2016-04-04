package zad2;

public class ReversibleDouble implements Reversible {
	private double dbl;

	public ReversibleDouble(double dbl) {
		this.dbl = dbl;
	}

	@Override
	public String toString() {
		return Double.toString(dbl);
	}

	@Override
	public Reversible reverse() {
		dbl = 1.0 / dbl;
		return this;
	}

}
