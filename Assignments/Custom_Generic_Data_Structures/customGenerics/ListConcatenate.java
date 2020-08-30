package customGenerics;

import java.util.LinkedList;

public class ListConcatenate {
	
	private LinkedList<Character> linkedListOne = new LinkedList<Character>();
	
	private LinkedList<Character> linkedListTwo = new LinkedList<Character>();
	
	public LinkedList<Character> getLinkedListOne() {
		return linkedListOne;
	}

	public void setLinkedListOne(LinkedList<Character> linkedListOne) {
		this.linkedListOne = linkedListOne;
	}

	public LinkedList<Character> getLinkedListTwo() {
		return linkedListTwo;
	}

	public void setLinkedListTwo(LinkedList<Character> linkedListTwo) {
		this.linkedListTwo = linkedListTwo;
	}

	public ListConcatenate (Character[] charArrayOne, Character[] charArrayTwo) {		
		for(int i=0; i<charArrayOne.length; i++) {
			getLinkedListOne().add(charArrayOne[i]);
		}
		for(int j=0; j<charArrayTwo.length; j++) {
			getLinkedListTwo().add(charArrayTwo[j]);
		}
	}
	
	public static LinkedList<Character> listConcatenation (LinkedList<Character> listOne, LinkedList<Character> listTwo) {
		LinkedList<Character> listFinal  = new LinkedList<Character>();		
		for(int j=0; j<listTwo.size(); j++) {
			listOne.add(listTwo.get(j));
		}
		return listOne;
	}

	public static void main(String[] args) {		
		Character[] charArrayOne = {'a','f','e'};
		Character[] charArrayTwo = {'k','d','q','p'};
		
		ListConcatenate lister = new ListConcatenate(charArrayOne,charArrayTwo);
		System.out.println("First Linked List Values : "+lister.getLinkedListOne());
		System.out.println("Second Linked List Values : "+lister.getLinkedListTwo());
		
		LinkedList<Character> listFinal  = lister.listConcatenation(lister.getLinkedListOne(), lister.getLinkedListTwo());
		System.out.println("Concatenating Second Linked list values to First One...");
		System.out.println("First Linked List Values (Post Concatenation) : "+lister.getLinkedListOne());
	}
}
