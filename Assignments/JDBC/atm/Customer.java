package atm;

public class Customer {

	private String name;
	private long phoneNumber;
	private String emailID;
	
	public Customer() {
		
	}
	
	public Customer(String name) {
		setName(name);
	}
	
	public Customer(String name, long phoneNumber, String emailID ) {
		setName(name);
		setPhoneNumber(phoneNumber);
		setEmailID(emailID);		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
}
