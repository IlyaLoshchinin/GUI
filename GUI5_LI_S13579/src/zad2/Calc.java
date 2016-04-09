/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Calc extends HashMap<Character, Do>   {
	BigDecimal liczba1;
	BigDecimal liczba2;
	char znak;
	
	public String doCalc(String string) {
		
		
		try {
			
			Scanner scan = new Scanner(string);
			liczba1 = scan.nextBigDecimal();
			znak = scan.next("[\\*\\-\\+\\/](?=(\\s*\\d+))").charAt(0);
			liczba2 = scan.nextBigDecimal();
			scan.close();
			
			put('*',
				new Do() {
				public BigDecimal doing(){
					return liczba1.multiply(liczba2).stripTrailingZeros();
				}
			});
		
			put('+',
				new Do() {
				public BigDecimal doing(){
					return liczba1.add(liczba2);
				}
			});
			
			put('/',
				new Do() {
				public BigDecimal doing(){
					BigDecimal a = liczba1.divide(liczba2 , 7 , RoundingMode.HALF_UP);
					return a.stripTrailingZeros();
				}
			});
			
			put('-',
				new Do() {
				public BigDecimal doing(){
					return liczba1.subtract(liczba2);
				}
			});
		
		
		
		return this.get(znak).doing().toPlainString();
		} catch (Exception e) {
			return "Invalid command to calc";
		}
		
	}

}
