package atm;

public class Account {

	private long accountNumber;
	private int accountPIN;	
	private Customer customer;
	private double balance;
	
	public Account () {
		
	}
	public Account (long accountNumber, int accountPIN ) {
		setAccountNumber(accountNumber);
		setAccountPIN(accountPIN);
	}
	
	public Account (long accountNumber, int accountPIN, Customer customer ) {
		setAccountNumber(accountNumber);
		setAccountPIN(accountPIN);
		setCustomer(customer);
	}
	
	public Account (long accountNumber) {
		setAccountNumber(accountNumber);		
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountPIN() {
		return accountPIN;
	}
	public void setAccountPIN(int accountPIN) {
		this.accountPIN = accountPIN;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
