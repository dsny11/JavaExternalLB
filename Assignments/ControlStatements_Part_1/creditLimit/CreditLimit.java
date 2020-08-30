package creditLimit;

public class CreditLimit {
	//Control Statements Part-I - No.1
	private int accountNumber;
	
	private int balanceMonthStart;
	
	private int totalCharge;
	
	private int totalCredits;
	
	private int allowedCreditLimit;
	
	private int newBalance;	
	
	public CreditLimit (int accountNumber, int balanceMonthStart, int totalCharge, int totalCredits, int allowedCreditLimit ) {
		setAccountNumber(accountNumber);
		setBalanceMonthStart(balanceMonthStart);
		setTotalCharge(totalCharge);
		setTotalCredits(totalCredits);
		setAllowedCreditLimit(allowedCreditLimit);
		setNewBalance();
	}

	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getBalanceMonthStart() {
		return balanceMonthStart;
	}


	public void setBalanceMonthStart(int balanceMonthStart) {
		this.balanceMonthStart = balanceMonthStart;
	}


	public int getTotalCharge() {
		return totalCharge;
	}


	public void setTotalCharge(int totalCharge) {
		this.totalCharge = totalCharge;
	}


	public int getTotalCredits() {
		return totalCredits;
	}


	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}


	public int getAllowedCreditLimit() {
		return allowedCreditLimit;
	}


	public void setAllowedCreditLimit(int allowedCreditLimit) {
		this.allowedCreditLimit = allowedCreditLimit;
	}
	
	public void setNewBalance() {
		this.newBalance = this.balanceMonthStart+this.totalCharge-this.totalCredits;
	}
	
	public int getNewBalance() {
		return this.newBalance;
	}
	
	public boolean isExceedingCreditLimit() {
		return this.newBalance > this.allowedCreditLimit;
	}
	
	public void printBalalnceAndCreditLimitStatus() {
		if (isExceedingCreditLimit()) {
			System.out.println("New Balance "+this.newBalance);
			System.out.println("Credit Limit "+this.allowedCreditLimit);
			System.out.println("Credit Limit Exceeded!");
		}
		else  {
			System.out.println("New Balance "+this.newBalance);
			System.out.println("Credit Limit "+this.allowedCreditLimit);
			System.out.println("Balance is under Credit Limit");			
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditLimit creditlimitOne = new CreditLimit(23,500,350,40,1000);
		creditlimitOne.printBalalnceAndCreditLimitStatus();
		System.out.println("---------------------------------------------");	
		CreditLimit creditlimitTwo = new CreditLimit(25,500,2000,40,2000);
		creditlimitTwo.printBalalnceAndCreditLimitStatus();
	}
}
