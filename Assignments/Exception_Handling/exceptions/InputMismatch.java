package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =  new Scanner(System.in);
		int input = 0;
		System.out.println("Enter integer : ");
		
		try {
			input = s.nextInt();
			System.out.println("Entered integer is: "+input);
		}
		catch (InputMismatchException i) {
			System.out.println("Enter only integer values!");
		}
		
		
	}

}

