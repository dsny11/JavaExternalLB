package textGenerator;

public class TextGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "8253688"; //String has to be of 7 characters
		String[] inputArray =input.split("");
		
		int count = 0;		
		for (int i=0;i<getStringArray(inputArray[0]).length;i++) {		
			for (int j=0;j<getStringArray(inputArray[1]).length;j++) {
				for (int k=0;k<getStringArray(inputArray[2]).length;k++) {
					for (int l=0;l<getStringArray(inputArray[3]).length;l++) {
						for (int m=0;m<getStringArray(inputArray[4]).length;m++) {
							for (int n=0;n<getStringArray(inputArray[5]).length;n++) {
								for (int o=0;o<getStringArray(inputArray[6]).length;o++) {
									System.out.println(getStringArray(inputArray[0])[i]+ getStringArray(inputArray[1])[j]+getStringArray(inputArray[2])[k]+ getStringArray(inputArray[3])[l]+getStringArray(inputArray[4])[m]+ getStringArray(inputArray[5])[n]+getStringArray(inputArray[6])[o]);
									count++;
								}
							}
						}
					}
				}				
			}
		}
		System.out.println("Total possible combinations : " + count);
	}
	
	private static String[] getStringArray(String inputArray) {
		String [] finalArray = new String[] {} ;
		String[] two = {"A","B","C"};
		String[] three = {"D","E","F"};
		String[] four = {"G","H","I"};
		String[] five = {"J","K","L"};
		String[] six = {"M","N","O"};
		String[] seven = {"P","R","S"};
		String[] eight = {"T","U","V"};
		String[] nine = {"W","X","Y"};
		if (inputArray.equals("2")) {
			finalArray =  two;
		}
		else if (inputArray.equals("3")) {
			finalArray =  three;
		}
		else if (inputArray.equals("4")) {
			finalArray =  four;
		}
		else if (inputArray.equals("5")) {
			finalArray =  five;
		}
		else if (inputArray.equals("6")) {
			finalArray =  six;
		}
		else if (inputArray.equals("7")) {
			finalArray =  seven;
		}
		else if (inputArray.equals("8")) {
			finalArray =  eight;
		}
		else if (inputArray.equals("9")) {
			finalArray =  nine;
		}
		else {
			finalArray = null;
			System.out.println("Invalid Number found in input - Valid numbers are integers 2 to 9 (inclusive)");
			System.exit(0);
		}
		return finalArray;
	}
}
