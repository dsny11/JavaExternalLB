package pair;

public class Pair<F,S> {
	
	private F one;
	
	private S two;
	
	public Pair(F one, S two) {
		this.one = one;
		this.two = two;
	}

	public F getOne() {
		return one;
	}

	public void setOne(F one) {
		this.one = one;
	}

	public S getTwo() {
		return two;
	}

	public void setTwo(S two) {
		this.two = two;
	}

	public static void main(String[] args) {
		
		Pair pairOne = new Pair("5","6");
		System.out.println("First Element : "+pairOne.getOne());
		System.out.println("Second Element : "+pairOne.getTwo());
		pairOne.setOne("8");
		pairOne.setTwo("9");
		System.out.println("First Element : "+pairOne.getOne());
		System.out.println("Second Element : "+pairOne.getTwo());
		System.out.println("-------------------------------------");

		Pair pairTwo = new Pair(1.0,7.5);
		System.out.println("First Element : "+pairTwo.getOne());
		System.out.println("Second Element : "+pairTwo.getTwo());
		pairTwo.setOne(23);
		pairTwo.setTwo("Test");
		System.out.println("First Element : "+pairTwo.getOne());
		System.out.println("Second Element : "+pairTwo.getTwo());

	}

}

