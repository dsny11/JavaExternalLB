package exceptions;

public class NullPointer {
	public static void main(String[] args) {
		
		String input = null;
		String newInput = "Test";

		try{
			if (input.equals(newInput)) {
				System.out.println("Match");
			}	
			else {
				System.out.println("No Match");

			}
		}
		catch (NullPointerException n) {
			System.out.println("Null Pointer exceptions has occured because input is null");

		}
		
	
	}
}
