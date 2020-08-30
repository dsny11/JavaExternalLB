package shapes;

public abstract class TwoDimensionalShape extends Shape
{
	private int dimension1;
	private int dimension2;
	public TwoDimensionalShape( int x, int y, int d1, int d2 ) {
		super( x, y );
		dimension1 = d1;
		dimension2 = d2;
	}
	protected abstract double getArea();
}
