package zad1;

public abstract class Pacjent {
	private String imie;
	
	 public Pacjent(String imie){
		 this.imie = imie;
	 }
	 
	public abstract String choroba();
	public abstract String leczenie();

	public String nazwisko() {	
		return imie;
	}
	  
}
