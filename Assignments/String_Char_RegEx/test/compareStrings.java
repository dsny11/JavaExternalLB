package test;

public class compareStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String one = "Antony";
		String two = "Antidote";
		compareStrings(one,two);		
	}
	
	private static void compareStrings(String one, String two) {
		
		if (one.compareTo(two)>0) { 
			System.out.println("String '"+ one + "' is Greater than '" + two+"'");
		}
		else if (one.compareTo(two)<0) {
			System.out.println("String '"+ one + "' is Lesser than " + two+"'");
		}
		else {
			System.out.println("String '"+ one + "' is Equal to " + two+"'");
		}
				
	}

}
