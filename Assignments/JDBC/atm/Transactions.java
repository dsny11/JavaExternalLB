package atm;

public class Transactions {

	private Account accountID;
	
	private int transactionTypeID;

	public Account getAccountID() {
		return accountID;
	}

	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}

	public int getTransactionTypeID() {
		return transactionTypeID;
	}

	public void setTransactionTypeID(int transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
	}
	
	
}
