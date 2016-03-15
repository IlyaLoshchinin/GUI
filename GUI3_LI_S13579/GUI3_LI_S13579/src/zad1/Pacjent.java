package zad1;

public class Pacjent {
	private String imie;
	private String nazwaChoroby;
	private String zastosowano;

	 public String nazwisko() {
		return imie;
	}
	 public String choroba() {
		return nazwaChoroby;
	}
	 public String leczenie() {
		return zastosowano;
	}
	  
	protected void setImie(String imie) {
		this.imie = imie;
	}
	protected void setNazwaChoroby(String nazwaChoroby) {
		this.nazwaChoroby = nazwaChoroby;
	}
	protected void setZastosowano(String zastosowano) {
		this.zastosowano = zastosowano;
	}
}
