package factorial;

import java.math.BigInteger;

public class factorial {
	//Control Statements Part-II - No.1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Number----Factorial");		
		for (int i=1;i<=20;i++) {
			System.out.println(i+"---------"+fact(i));
		}	
		for (long i=1;i<=100;i++) {
			System.out.println(i+"---------"+fact(i));
		}	
	}	
	
	public static long fact (int n) {
		
		if (n==0) {
			return 1;
		}
		else {
			return fact(n-1) * (n);
		}
	}
	
public static BigInteger fact (long n) {
		
	BigInteger result = BigInteger.ONE;
    for (long i = 2; i <= n; i++)
        result = result.multiply(BigInteger.valueOf(i));
    return result;
	}

}
