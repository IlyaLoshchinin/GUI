package zad1;

public class Account {
	
	private static double InterestRate;
	private double balance;
		
	public void deposit(double value){
		if(value > 0){
			balance += value;
			}
	}
	
	public void withdraw(double value){
		if(balance >= value && value > 0){
			balance -= value;	
		}
	}
	
	public void transfer(Account konto,double value){
		if(balance >= value && value > 0 && konto != null){
			konto.balance += value;	
			balance -= value;
		}
	}
	
	public void addInterest(){
		if(balance > 0){
			balance += (1*balance*InterestRate) / 100;
		}
	}
	
	public double getBalance(){
		return balance;
	}
	
	public static void setInterestRate(double procent){
		if(procent > 0)
			InterestRate = procent;
		
	}
}
