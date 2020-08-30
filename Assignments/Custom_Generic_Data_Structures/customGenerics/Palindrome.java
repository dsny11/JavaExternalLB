package customGenerics;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String input = "TENET";
		input = input.replaceAll("\\s{2,}", " ");
		input = input.replaceAll(",", "");
		System.out.println("Actual String : " + input);
		if(isPalindrome(input)) {
			System.out.println("String is Palindrome!");
		}
		else {
			System.out.println("String is NOT a Palindrome!");
		}		
	}
	
	public static boolean isPalindrome(String input) {		
		return input.equals(reverseString(input));
	}
	
	public static String reverseString(String input ) {
		Stack<String> stack = new Stack<String>();	 
		input = input.replaceAll("\\s{2,}", " ");
		String[] inputArray = input.split("");
		for(int i = 0;i<inputArray.length;i++) {		
			stack.push(inputArray[i]); 
	    }
		String finalString = "";
		while(!(stack.empty())) { 
			finalString = finalString + stack.peek();			
			stack.pop();
	    }
		return finalString;
	}

}
