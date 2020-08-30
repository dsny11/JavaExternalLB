package generic;
import java.io.File; 
public class isEqualtoMethod {

	public static void main(String[] args) {		
		File a = new File("C:/Temp/FileOne.txt");
		File b = new File("C:/Temp/FileOne.txt");
		File c = new File("C:/Temp/FileThree.txt");
		
		isEqualto("5","5"); // String Match Verification
		isEqualto("5","6"); // String Match Verification
		System.out.println("--------------------------");
		isEqualto(10,10); // Integer Match Verification
		isEqualto(10,16); // Integer Match Verification
		System.out.println("--------------------------");		
		isEqualto(a,b); // Object Match Verification
		isEqualto(b,c); // Object Match Verification
	}
	
	public static < G,H > boolean isEqualto( G inputOne , H inputTwo ) {	      
		if (inputOne.equals(inputTwo)) {
			System.out.println("Match");
			return true;
		}
		else {
			System.out.println("No Match");
			return false;
		}
	}	
}
