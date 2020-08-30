package invoice;

public class Invoice {
//Introduction:Classes,Objects,Methods and Strings - No.2
	private String partNumber;
	
	private String partDescription;
	
	private int quantity;
	
	private double pricePerItem;
	
	public Invoice (String partNumber, String partDescription, int quantity, double pricePerItem  ) {
		setPartNumber(partNumber);
		setPartDescription(partDescription);
		setQuantity(quantity);
		setPricePerItem(pricePerItem);
	}
	
	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public double getInvoiceAmount() {		
		if((this.quantity>=0)&&(this.pricePerItem>=0)) {
			return quantity * pricePerItem;
		}
		else 
			return 0;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Invoice invoice = new Invoice("S3ERGK","AMDMotherBoard",3,4.50);
		System.out.println("Invoice Part Number is "+invoice.getPartNumber());
		System.out.println("Invoice Part Description is "+invoice.getPartDescription());	
		System.out.println("Invoice Quantity is "+invoice.getQuantity());
		System.out.println("Invoice Price per Item is "+invoice.getPricePerItem());
		System.out.println("Invoice Amount = Quantity * Price per Item");
		System.out.println("Invoice Amount = "+invoice.getInvoiceAmount());
	}

}

