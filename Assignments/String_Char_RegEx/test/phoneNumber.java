package test;

public class phoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String input = "555-123-1345";
String[] arr = input.split("-");

System.out.println("Area Code  :" + arr[0]);
System.out.println("Phone Number  :"+  arr[1] + arr[2]);
	}

}
