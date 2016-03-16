package zad2;

import java.util.ArrayList;



public class Customer {
	private String imie;
	private double pienendzy;
	ShoppingCart shoppingCart;
	PriceList price = PriceList.getInstance();
	
	public Customer(String imie,double value){
		this.imie = imie;
		this.pienendzy = value;
		this.shoppingCart = new ShoppingCart(this);
	}
	
	public void get(Kwiaty ob){
		if(ob != null)
		this.shoppingCart.add(ob);
	}

	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void pack(Box pudelkoJanka) {
		if(pudelkoJanka != null)
		pudelkoJanka.arrayList.addAll(shoppingCart.arrayList);
		if(!pudelkoJanka.arrayList.isEmpty()){
			shoppingCart.arrayList.clear();
		}
	}
	ArrayList<Integer> index = new ArrayList<Integer>();
	public void pay() {
		double tmp = 0;
		
		for (Kwiaty kwiaty : shoppingCart.arrayList) {
			if(!price.containsKey(kwiaty.nazwaPrice)){ 
				shoppingCart.arrayList.remove(kwiaty);
			}
		}
		int i = 0;
		for (Kwiaty kwiaty : shoppingCart.arrayList) {
			if(price.containsKey(kwiaty.nazwaPrice)){ 
				tmp = kwiaty.getIloscKwiat() * price.get(kwiaty.nazwaPrice);
				if(pienendzy >= tmp){
					pienendzy -= tmp; 
					//System.out.println(pienendzy);
				}else {
					index.add(i);}
				}
			i++;
			}
		for (int j = 0; j < index.size(); j++) {
			int tmp1 = index.get(j);
			shoppingCart.arrayList.remove(tmp1);
		}
		index.clear();
		
	}

	public double getCash() {
		return this.pienendzy;
	}

	
}
