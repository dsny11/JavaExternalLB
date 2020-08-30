package exceptions;

public class ArrayOutofBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input = new String[] {"One", "Two"};
		
		try {
			System.out.println("Array Value = "+ input[2]);

		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Array Index OutOfBounds Exception has occured !");
		}
	}

}
