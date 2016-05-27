package somkiat.bank.account.dto;

public class TransactionOut {
	String date;
	String account;
	double amount;
	
	public TransactionOut(String date, String account, double amount){
		this.date = date;
		this.account = account;
		this.amount = amount;
	}
}
