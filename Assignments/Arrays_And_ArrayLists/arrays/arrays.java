package arrays;

public class arrays {

	public static void main(String[] args) {
		//a. Set the 10 elements of integer array counts to zero.
		int [] counts = {1,2,3,4,5,6,7,8,9,10,11,12};
		for (int i=0; i<counts.length;i++) {
			if(i<10) {
				counts[i]=0;
			}
			System.out.println("count["+i+"] = " + counts[i]);
		}
		
		System.out.println("--------------------------------------");

		//b. Add one to each of the 15 elements of integer array bonus.
		int [] bonus = new int[20];
		for (int i=0; i<bonus.length;i++) {
			if(i<15) {
				bonus[i]=bonus[i]+1;	
			}			
			System.out.println("bonus["+i+"] = " + bonus[i]);
		}		
		
		System.out.println("--------------------------------------");
		
		//c) Display the five values of integer array bestScores in column format.
		int [] bestScores = {1,2,3,4,5,6,7,8,9,10,11,12};
		for (int i=0; i<bestScores.length;i++) {
			if(i<5) {					
				System.out.println("bestScores["+i+"] = " + bestScores[i]);
			}				
		}
	}
}
