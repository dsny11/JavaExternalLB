package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class duplicateEliminator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input  = new int [5];		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 5 integers only from 10 to 100 (inclusive)");
		for(int i=0;i<input.length;i++) {
			input[i]=s.nextInt();	
			validateInput(input[i]);
		}
		
		System.out.println("------------------------------------------");
		System.out.println("Unique Values : ");
		printUniqueArrayValue(input);
		System.out.println("------------------------------------------");
		System.out.println("Duplicate Values : ");
		printDuplicateArrayValue(input, input);		
		System.out.println("------------------------------------------");
		
		
	}
	
	private static int[] getDuplicate(int[] arrayOne, int[] arrayTwo) {
		int[] uniqueArray = new int[5];
		int it=0;
		int temp=0;
		for (int i=0;i<arrayOne.length;i++) {
			temp=0;
			for (int j=0;j<arrayTwo.length;j++) {
				if (arrayOne[i]==arrayTwo[j]) {
					temp = temp+1;
					if (temp==2) {
						uniqueArray[it]=arrayOne[i];
						it++;	
					}						
				}
			}
		}		
		return uniqueArray;
	}
	
	private static int[] getUnique(int[] inputArray) {
		int[] duplicateArray = Arrays.copyOf(inputArray, inputArray.length); 
		int[] uniqueArray = new int[5];
		int it=0;
		for (int i=0;i<duplicateArray.length;i++) {						
			if (!(duplicateArray[i]==101) ) {		
				uniqueArray[it]=duplicateArray[i];
				duplicateArray = replaceArrayValue(duplicateArray,duplicateArray[i],101);
				it++;															
			}
		}		
		return uniqueArray;
	}
	
	private static int[] replaceArrayValue(int [] inputArray,int value, int valueToBeReplaced) {
		for (int i=0;i<inputArray.length;i++) {
			if (inputArray[i]==value) {
				inputArray[i]=valueToBeReplaced;
			}
		}
		return inputArray;
	}
	
	private static void printUniqueArrayValue(int[] inputArray) {
		int[] uniqueArray = getUnique(inputArray);		
		for (int i =0; i<uniqueArray.length;i++) {	
			if (!(uniqueArray[i]==0)) {
				System.out.println(uniqueArray[i]);	
			}						
		}
	}
	
	private static void printDuplicateArrayValue(int[] arrayOne, int[] arrayTwo ) {
	int[] temp = getDuplicate(getUnique(arrayOne),arrayTwo);
	boolean bfound = false;
	for (int i =0; i<temp.length;i++) {			
		if (temp[i]==0) {
			break;
		}
		System.out.println(temp[i]);
		bfound=true;
	}
	if (!bfound) {
		System.out.println("No Duplicate Values Found!");
	}
	}
	
	private static void validateInput(int inputArray) {		
		if (!((inputArray>=10)&&(inputArray<=100))) {
			System.out.println("Invalid value provided - Exiting Program...");
			System.exit(0);
			}
		}
}
