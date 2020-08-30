package exceptions;

public class NumberFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "a";
		Integer first = 10;
		Integer total = 0;
		
		try {
			total = first +Integer.parseInt(number);
			System.out.println("Total is : " + total);	
		}
		catch (NumberFormatException n ) {
			System.out.println("Provide an Integer Value for String 'number'");
		}
		
		
	}

}
