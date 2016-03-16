package zad2;

import java.util.HashMap;

public class PriceList extends HashMap<String,Double> {
	
	
	public static class SingletonHolder {
		public static final PriceList HOLDER_INSTANCE = new PriceList();
	}
		
	public static PriceList getInstance() {
		return SingletonHolder.HOLDER_INSTANCE;
	}

	public void put(String string, double d) {
		super.put(string, d);
	}
	
	
	
}
