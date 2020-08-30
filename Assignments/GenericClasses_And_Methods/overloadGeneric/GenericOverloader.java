package overloadGeneric;

public class GenericOverloader<F> {
	
	private F one;
	
	public GenericOverloader(F one) {
		setOne(one);
	}

	public F getOne() {
		return one;
	}

	public void setOne(F one) {
		System.out.println("Generic Method Call!");
		this.one = one;
	}
	
	public void setOne(String inp) {
		System.out.println("Generic Method Overload Call!");
		this.one = (F) inp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericOverloader g = new GenericOverloader(3);
		System.out.println(g.getOne());
		g.setOne(45);
		System.out.println(g.getOne());
		g.setOne("Test");
		System.out.println(g.getOne());
	}
}
