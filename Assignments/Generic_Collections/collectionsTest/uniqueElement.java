package collectionsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class uniqueElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "This is my string";
		System.out.println("Input : "+ input);
		input = input.toLowerCase();
		input = input.replaceAll("\\s+", "");	
		String[] inputArray = input.split("");		
		Set<String> uniqueSet = new HashSet<>(Arrays.asList(inputArray));		
		System.out.println(uniqueSet);
	}

}
