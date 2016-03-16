package zad2;

import java.util.ArrayList;

public class Customer {
	private String imie;
	private double pienendzy;
	ShoppingCart shoppingCart;
	
	
	public Customer(String imie,double value){
		this.imie = imie;
		this.pienendzy = value;
		this.shoppingCart = new ShoppingCart(this);
	}
	
	public void get(Kwiaty ob){
		this.shoppingCart.add(ob);
	}

	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void pack(Box pudelkoJanka) {
		
		
	}

	
}
