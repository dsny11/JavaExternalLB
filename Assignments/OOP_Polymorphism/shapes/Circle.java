package shapes;

public class Circle extends TwoDimensionalShape {
// three-argument constructor
	private double area;
	
	public Circle( int x, int y, int radius ) {
		super( x, y, radius, radius );
		this.area= 3.1415926535 * radius  * radius;
	} 
	
	public String getName() {	
		return "Circle";
	}
	
	protected double getArea() {		
		return this.area;
	}
}
