package zad1;

public class Towar {
	private volatile int idTowaru;
	private volatile int wagaT;

	public Towar(int id, int waga) {
		idTowaru = id;
		wagaT = waga;
	}

	public int getIdTowaru() {
		return idTowaru;
	}

	public int getWagaT() {
		return wagaT;
	}

}
