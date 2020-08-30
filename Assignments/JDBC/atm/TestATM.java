package atm;

import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bStart = true;
		boolean bMenu = true;
		boolean bFull = true;
		long accountNumber = 0;
		int accountPIN = 0;		
		double amount=0;
		String option="";
		long receipientAccountNumber=0;
		long phoneNumber = 0;
		String email="";
		Scanner s = new Scanner(System.in);
		Account account =new Account();
		Customer customer =new Customer();
		while (bFull) {
		while (bMenu) {
			System.out.println("--Just Bank ATM--");
			System.out.println("Enter AccountNumber");
			accountNumber = s.nextLong();
			System.out.println("Enter PIN");
			accountPIN = s.nextInt();
			account  = new Account(accountNumber,accountPIN,customer);
			customer = BankDBConnection.getCustomerInformation(account);			
			account.setCustomer(customer);			
			if(BankDBConnection.validate(account, false)){
				System.out.println("-------------------------------");
				System.out.println("Welcome : " + customer.getName());
				System.out.println("-------------------------------");
				bMenu=false;
				bStart=true;				
			}			
		}//while menu		
		while(bStart) {			
			System.out.println("Enter 1 to Check Balance");
			System.out.println("Enter 2 to Withdraw Money");
			System.out.println("Enter 3 to Deposit Money");
			System.out.println("Enter 4 to Transfer");
			System.out.println("Enter 5 to Update Customer Details");
			System.out.println("Enter 6 to End Session");
			option = s.next();
			switch(option) {
			case "1" :
				BankDBConnection.getBalance(account);
				break;
			case "2" :
				System.out.println("Enter Amount to be withdrawn Money : ");
				amount = s.nextDouble();
				if(BankDBConnection.getBalance(account)>=amount) {
					BankDBConnection.insertTransaction(account, amount, "Debit");
					BankDBConnection.manageAmount(account, amount, false, false);
					
				}
				else {
					System.out.println("Balance is lesser than amount to be withdrawn!");
				}
				
				break;
				//code for other switch cases
			case "3" :
				System.out.println("Enter Amount to be Deposited : ");
				amount = s.nextDouble();
				BankDBConnection.insertTransaction(account, amount, "Credit");
				BankDBConnection.manageAmount(account, amount, true, false);
				break;
			case "4" :				
				System.out.println("Enter Receipient Account Number for Transfer");
				receipientAccountNumber=s.nextLong();
				Account accountReceipient = new Account(receipientAccountNumber);
				if(account.getAccountNumber()==accountReceipient.getAccountNumber()) {
					System.out.println("Sender and Receipient account number cannot be the same");
					System.out.println("-------------------------------------------------------");
				}
				else {
					System.out.println("Enter Amount to be Transfered!");
					amount = s.nextDouble();
					if(BankDBConnection.getBalance(account)>=amount) {
						if (BankDBConnection.validate(accountReceipient, true)) {
							BankDBConnection.manageAmount(account, amount, false, false);
							BankDBConnection.manageAmount(accountReceipient, amount, true, true);	
							BankDBConnection.insertTransaction(account, amount, "Debit");
							BankDBConnection.insertTransaction(accountReceipient, amount, "Credit");
						}	
					}
					else {
						System.out.println("Balance is lesser than amount entered!");
					}					
				}								
				break;
			case "5":
				System.out.println("Enter 1 to edit Customer Phone Number");
				System.out.println("Enter 2 to edit Customer Email");
				option = s.next();
				switch(option) {
				case "1" : 
					System.out.println("Enter New Phone Number");
					phoneNumber = s.nextLong();				
					BankDBConnection.updateCustomerPhone(account,phoneNumber);		
					break;
				case "2" : 
					System.out.println("Enter New Email");
					email = s.next();
					BankDBConnection.updateCustomerEmail(account,email);		
					break;
				default :
					System.out.println("Invalid option entered");
				}
				break;
			case "6":
				bStart=false;
				bMenu=true;
				break;
			default :
				System.out.println("Invalid option entered");
			}						
		}//while landingpage
	   }//while full
	}//main method

}
