package collectionsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class duplicateWordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "This is my string";
		System.out.println("Input : "+ input);
		input = input.toLowerCase();
		input = input.replaceAll("\\s+", "");		
		String[] inputArray = input.split(""); 
		List<String> inputList = new ArrayList<>();
		inputList.addAll(Arrays.asList(inputArray));		
		System.out.println("Output : "+getDuplicate(inputList));			
	}
	
	private static Set<String> getDuplicate(List<String> inputList){	
		Set<String> duplicateValueSet = new HashSet<>(); 
		Set<String> initialSet = new HashSet<>();
		for (String value : inputList) {
		   if (!initialSet.add(value)) {
			   duplicateValueSet.add(value);
		   }
		}
		return duplicateValueSet;		
	}
}
