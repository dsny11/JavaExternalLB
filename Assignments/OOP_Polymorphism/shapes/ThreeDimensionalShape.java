package shapes;

public abstract class ThreeDimensionalShape extends Shape {
	private int dimension1;
	private int dimension2;
	private int dimension3;
	
	
	public ThreeDimensionalShape(int x, int y, int d1, int d2, int d3 ) {
		super( x, y );
		dimension1 = d1;
		dimension2 = d2;
		dimension3 = d3;
	}
	protected abstract double getArea();
	protected abstract double getVolume();
}
