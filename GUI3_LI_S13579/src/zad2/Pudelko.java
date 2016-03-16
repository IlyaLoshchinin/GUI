package zad2;

import java.util.ArrayList;

public abstract class Pudelko {
	private Customer obj;
	ArrayList<Kwiaty> arrayList = new ArrayList<Kwiaty>();
	
	public Pudelko(Customer obj){
		this.obj = obj;
	}
	
	public void add(Kwiaty ob){
		if(ob != null)
			arrayList.add(ob);
	}
	@Override
	public String toString(){
		String str = "";
		for (Kwiaty kwiaty : arrayList) {
			str +=  kwiaty.getClass().getSimpleName()+ " -> " + kwiaty.getIloscKwiat() + " szt.\n"; 
		}
		return str;
	}
}
