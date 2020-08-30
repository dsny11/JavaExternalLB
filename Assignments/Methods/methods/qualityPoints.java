package methods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class qualityPoints {
	//Methods - No.1
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Student Average : ");
		System.out.println("Quality Points is : " +getQualityPoints(s.nextInt()));
	}
	
	private static int getQualityPoints(int average) {		
		if ((average>=90) && (average<=100)) {
			return 4;
		}
		else if ((average>=80) && (average<=89)) {
			return 3;
		}		
		else if ((average>=70) && (average<=79)) {
			return 2;
		}
		else if ((average>=60) && (average<=69)) {
			return 1;
		}
		else if ((average>=0) && (average<60)) {
			return 0;
		}
		else {
			System.out.println("Invalid Student Average!");
			return 0;
			
		}
	}

}
