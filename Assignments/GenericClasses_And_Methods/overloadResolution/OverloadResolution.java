package overloadResolution;


public class OverloadResolution<F> {
	
	private F one;
	
	public OverloadResolution(F one) {
		setOne(one);
	}

	public F getOne() {
		return one;
	}

	public void setOne(F one) {
		System.out.println("Generic Method Call!");
		this.one = one;
	}
	
	/*
	public void setOne(int inp) {
		System.out.println("Generic Method Overload Call!");
		this.one = (F) inp; // UnComment this method and you can see that this will cause a compile time error because downcasts are never considered when compiler tries 
							//to find an exact match to perform overload resolution
	}
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadResolution g = new OverloadResolution(3);
		System.out.println(g.getOne());
		g.setOne(45);
		System.out.println(g.getOne());
		g.setOne(55);
		System.out.println(g.getOne());
	}
}
