package collectionsTest;

import java.util.LinkedList;

public class LinkedLister {
	
	public static void main(String args[]) 
    { 
		LinkedList<String> normalList = new LinkedList<String>(); 
		normalList.add("Apple"); 
		normalList.add("Orange"); 
		normalList.add("Grapes"); 
		normalList.add("Fig");
		
		LinkedList<String> reversedList = new LinkedList<String>();     		
		int j = normalList.size();
		for(int i=0; i<normalList.size(); i++) {
			reversedList.add(normalList.get(j-1));
			j--;
		}
		
		printLinkedList(normalList);
		System.out.println("-------------------------------");
		printLinkedList(reversedList);
    }
	
	private static void printLinkedList(LinkedList<String> linkedList) {
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}
    }	
}
