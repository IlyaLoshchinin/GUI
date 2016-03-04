package zad1;

public class BankCustomer {
	
	private Person person;	
	private Account konto = new Account();
	
	public BankCustomer(Person person){
		this.person = person;
	}
	
	public Account getAccount(){
		if(konto != null)
			return konto;
		return null;
	}
	
	@Override
	public String toString(){
		String tmp = "Klient: " + person.getName() + " stan konta " + konto.getBalance();
		return tmp;
	}
}
