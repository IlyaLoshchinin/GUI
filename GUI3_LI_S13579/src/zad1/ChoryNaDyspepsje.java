package zad1;

public class ChoryNaDyspepsje extends Pacjent{
	
	public ChoryNaDyspepsje(String imie){
		super(imie);
		}

	@Override
	public String choroba() {
		return "dyspepsja";
	}

	@Override
	public String leczenie() {
		return "wegiel";
	}
	
}
