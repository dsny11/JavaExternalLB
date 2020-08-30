package classesAndObjects;

public class rectangle {
	
	private float length = 1.0f;
	
	private float width = 1.0f ;
	
	private float area;
	
	private float perimeter;
	
	public rectangle(float length, float width) {
		setLength(length);
		setWidth(width);
		calculateArea();
		calculatePerimeter();
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		if ((length>=0.0f) && (length<=20.0f)) {
			this.length = length;	
		}		
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		if ((width>=0.0f) && (width<=20.0f)) {
			this.width = width;	
		}		
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public float getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(float perimeter) {
		this.perimeter = perimeter;
	}
	
	public void calculateArea() {
		setArea( this.length * this.width);
	}
	
	public void calculatePerimeter() {
		setPerimeter( 2 * (this.length + this.width));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle rectangle = new rectangle(20,1);
		System.out.println("Note: Length and Width of Rectangle when set to <=0 or >=21 are reset to 1: ");
		System.out.println("Length of Rectangle    : " + rectangle.getLength());
		System.out.println("Width of Rectangle     : " + rectangle.getWidth());
		System.out.println("Area of Rectangle      : " + rectangle.getArea());
		System.out.println("Perimeter of Rectangle : " + rectangle.getPerimeter());
	}
}
