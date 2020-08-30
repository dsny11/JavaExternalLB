package superClass;

public class ExceptionC extends ExceptionB  {

	public ExceptionC(String message) {
		super(message);	
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			throw new ExceptionC("Error");
		}
		catch(ExceptionA e) {
			System.out.println(e.getMessage());		
		}
	}
}
