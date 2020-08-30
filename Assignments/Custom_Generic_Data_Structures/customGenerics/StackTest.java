package customGenerics;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		String input = "This is for Stack";
		System.out.println(input);
		String reversedText = reverseSentence(input);
		System.out.print(reversedText);	
	}
	
	public static String reverseSentence(String input ) {
		Stack<String> stack = new Stack<String>();	 
		input = input.replaceAll("\\s{2,}", " ");
		String[] inputArray = input.split(" ");
		for(int i = 0;i<inputArray.length;i++) { 
			stack.push(inputArray[i]); 
	    }
		String finalString = "";
		while(!(stack.empty())) { 
			finalString = finalString + stack.peek()+" ";
			stack.pop();
	    }
		return finalString;
	}

}
