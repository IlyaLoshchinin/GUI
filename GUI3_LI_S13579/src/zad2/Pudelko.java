package zad2;

import java.util.ArrayList;

public abstract class Pudelko {
	private Customer imie;
	ArrayList<Kwiaty> arrayList = new ArrayList<Kwiaty>();
	
	public Pudelko(Customer imie){
		this.imie = imie;
	}
	
	public void add(Kwiaty ob){
		arrayList.add(ob);
	}
	
	
}
