package methods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class temperatureConverted {
	//Methods - No.2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option=0;
		double temp=0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter '1' to perform Celsius to Fahrenheit");
		System.out.println("Enter '2' to perform Fahrenheit to Celsius");
		System.out.println("Enter '0' to exit!");
		System.out.println("---------------------------------------------------------------------");
		option = s.nextInt();
		if ((option==1) || (option==2)) {
			if (option==1) {
				System.out.println("Enter Celsius Value");		
				temp = s.nextDouble();
				System.out.println(temp+ " Celsius is "+String.format("%.4f", getFahrenheit(temp))+  " Fahrenheit");
			}
			else if (option==2) {
				System.out.println("Enter Fahrenheit Value");		
				temp = s.nextDouble();
				System.out.println(temp+ " Fahrenheit is "+String.format("%.4f", getCelsius(temp))+  " Celsius");
			}
		}
		else if ((option<0)||(option>2)) {
			System.out.println("Invalid Option!. Exiting program... ");
			System.exit(0);
		}		
		else {
			System.out.println("Invalid Option " + s.next() +" chosen");
			System.exit(0);
		}		
	}
	
	private static double getFahrenheit(double celsius) {		
		return (celsius * (9.0d/5.0d)) + 32; 
	}
	
	private static double getCelsius(double fahrenheit) {
		return (fahrenheit -32)* (5.0d/9.0d); 		
	}

}
