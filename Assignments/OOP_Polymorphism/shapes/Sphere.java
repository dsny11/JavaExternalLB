package shapes;

public class Sphere extends ThreeDimensionalShape {
	
	private double area;
	private double volume;
	
	public Sphere( int x, int y, int radius ) {
		super( x, y, radius, radius, radius );
		this.area= 4 * 3.1415926535 * radius  * radius;
		this.volume= 1.33333333333 * 3.1415926535 * radius  * radius * radius; 
	}

	public String getName() {	
	return "Sphere";
	}
	
	protected double getArea() {
		return this.area;
	}
	
	protected double getVolume() {
		return this.volume;
	}

	
}
