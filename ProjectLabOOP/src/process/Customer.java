package process;

public class Customer extends Admin{
	private double balance;
	
	public String toString_1() {
		return PIN + "- " + Fullname + "- "+"Customer [balance=" + balance + "]";
	}
	public Customer(String pIN, String fullname, String phonenumber, String iD, String password, double money) {
		super(pIN, fullname, phonenumber, iD, password);
		this.balance = money;
	}
	public Customer() {
		super();
	}
	
	public Customer(String pIN, String fullname, String phonenumber, String iD, String password) {
		super(pIN, fullname, phonenumber, iD, password);
		this.balance = 0;
	}



	public double getBalance() {
		return balance;
	}

	public void setBalance(double money) {
		this.balance = money;
	}
	
	public boolean Withdraw(double moneyWithdraw) {
		if(balance >= moneyWithdraw) {
			balance -= moneyWithdraw;
			return true;
		}
		return false;
		
	}
	public void Deposit(double moneyDeposit) {
		balance += moneyDeposit;
	}
	
}
