package arrays;

import java.util.Scanner;

public class productOfIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Product of a Series of Integers ");
		System.out.println("---------------------------------------------");
		System.out.println("Enter Integers seperated by commas");
		String inputValue = s.next();		
		System.out.println("Product of entered Series of Integer(s) is : "+ getProduct(inputValue) );
	}
	
	private static Integer getProduct(String inputValue) {
		int productValue=1;
		String[] inputValueArray = inputValue.split(",");		
		for (int i=0 ; i<inputValueArray.length;i++) {
			productValue = productValue * Integer.parseInt(inputValueArray[i]);
		}
		return productValue;
	}

}
