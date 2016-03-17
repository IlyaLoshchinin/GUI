package zad2;

public abstract class Kwiaty {
	private int iloscKwiat;
	private String nazwaPrice;
	private String color;
	
	public Kwiaty(int value,String nazwaPrice,String color){
		this.iloscKwiat = value;
		this.nazwaPrice = nazwaPrice;
		this.color = color;
	}
	
	public int getIloscKwiat() {
		return iloscKwiat;
	}
	
	public String getNazwaPrice() {
		return nazwaPrice;
	}
	
	public String getColor() {
		return color;
	}
}
