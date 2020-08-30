package exceptions;

public class DivideByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 - Arithmetic Exception
		int i = 0;
		try {
			System.out.println("Division Result " + 50/i);	
		}
		catch (ArithmeticException e) {
			System.out.println("Divide by Zero exception has occured - provide a non zero value for i !");
		}	
	}
}
