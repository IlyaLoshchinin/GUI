/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad1;



public abstract class Spiewak {
	private String nazwisko;
	private int numerStartowy = 0;
	public static int numer = 0;
	 String text = spiewaj();
	
	public Spiewak(String nazwisko){
		numer += 1;
		this.numerStartowy = numer;
		this.nazwisko = nazwisko;
	}
	abstract String spiewaj();
	
	public String toString(){
		return "("+numerStartowy+")" + " "+ nazwisko+": "+ text;
	}
	
	
	static Spiewak najglosniej(Spiewak[] obj){
		
		int maks = 0,index = 0,ile = 0;
		for (int j1 = 0; j1 < obj.length; j1++) {
			
			for (int i = 0; i < obj[j1].text.length(); i++) {
				if(Character.isUpperCase(obj[j1].text.charAt(i))) {
					ile++;
				}
			}
			if(ile >= maks){
				maks = ile;
				index = j1;
			}
			ile = 0;
			
		}
		
		return obj[index];
	}
}
