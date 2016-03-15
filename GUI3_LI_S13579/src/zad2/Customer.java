package zad2;

import java.util.ArrayList;

public class Customer extends ArrayList<Kwiaty>{
	private String imie;
	private double pienendzy;
	
	
	
	public Customer(String imie,double value){
		this.imie = imie;
		this.pienendzy = value;
	}
	
	public void get(Kwiaty ob){
		super.add(ob);
	}

	public ShoppingCart getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
