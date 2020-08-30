package sales;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SalesCalculator {
	//Control Statements Part-II - No.2
	private int productNumber;
	
	private int quantitySold;
	
	private double finalPrice;
	
	private HashMap<Integer,Integer> cart = new HashMap() ; 	
	
	public void addItemsToCart (int productNumber,int quantitySold) {		
		if (this.cart.containsKey(productNumber)) {
			this.cart.put(productNumber, this.cart.get(productNumber)+quantitySold);
		}
		else {
			this.cart.put(productNumber, quantitySold);
		}				
	}
	
	public void displayItemsInCart() {
		this.finalPrice = 0 ;
		Set set = this.cart.entrySet();
		Iterator iterator = set.iterator();	      
	    while(iterator.hasNext()) {
	    	Map.Entry mp = (Map.Entry)iterator.next();	         
	        System.out.println("Product Number : "+ mp.getKey() + " & Quantity Sold : "+ mp.getValue()+" --> Total Price : "+ (getRetailPrice(Integer.parseInt(mp.getKey().toString()))) * (Integer.parseInt(mp.getValue().toString()))  );	  
	        this.finalPrice = this.finalPrice + (getRetailPrice(Integer.parseInt(mp.getKey().toString()))) * (Integer.parseInt(mp.getValue().toString()));
	    }
	    System.out.println("Cart Total -- > " + this.finalPrice);
	    System.out.println("---------------------------------------------------------------------");
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int productNumber=0;
		int quantitySold=0;
		String start = "start";
		SalesCalculator sc = new SalesCalculator();
		while (start.equals("start")) {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Product Number: (Enter a positive Integer or type 0 to quit program!)");			
			productNumber = s.nextInt();	
			exitProgram(productNumber);
			System.out.println("Enter Quantity Sold: (Enter a positive Integer or type 0 to quit program!)");
			quantitySold = s.nextInt();
			exitProgram(quantitySold);
			sc.addItemsToCart(productNumber, quantitySold);	
			sc.displayItemsInCart();
		}	
	}
	public static double getRetailPrice(int n) {
		double retailPrice=0;
		switch (n) {		
			case 1:
				retailPrice=2.98;
				break;	
			case 2:
				retailPrice=4.50;
				break;
			case 3:
				retailPrice=9.98;
				break;
			case 4:
				retailPrice=4.49;
				break;
			case 5:
				retailPrice=6.87;
				break;
			default:
				System.out.println("Retial price not available for product "+n);
		}
		return retailPrice;		
	}
	
	public static void exitProgram(int type) {
		if (type==0) {
			System.exit(0);
		}
	}
	
}