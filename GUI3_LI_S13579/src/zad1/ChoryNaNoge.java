package zad1;

public class ChoryNaNoge extends Pacjent {
	
	public ChoryNaNoge(String imie){
		super(imie);
		}

	@Override
	public String choroba() {
		return "noga";
	}

	@Override
	public String leczenie() {
		return "gips";
	}
	
	
}
