package zad2;

public abstract class Kwiaty {
	private int iloscKwiat;
	protected String nazwaPrice;
	protected String color;
	
	public Kwiaty(int value){
		this.iloscKwiat = value;
	}
	
	public int getIloscKwiat() {
		return iloscKwiat;
	}
	
	public String getNazwaPrice() {
		return nazwaPrice;
	}
	
	
}
