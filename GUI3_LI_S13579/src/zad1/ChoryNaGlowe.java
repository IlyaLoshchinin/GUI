package zad1;

public class ChoryNaGlowe extends Pacjent{
	
	public ChoryNaGlowe(String imie){
		super(imie);
		}

	@Override
	public String choroba() {
		return "glowa";
	}

	@Override
	public String leczenie() {
		return "aspiryna";
	}
	
	
}
