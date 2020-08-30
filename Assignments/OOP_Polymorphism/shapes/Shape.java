package shapes;

public abstract class Shape {
	private int x;
	private int y;

	public Shape( int x, int y ) {
		this.x = x;
		this.y = y;
	} 

	public void setX( int x ) {
		this.x = x;
	}

	public void setY( int y ) {
		this.y = y;
	} 	
	
	public int getX() {
		return x;
	} 

	public int getY() {
		return y;
	}

	public String toString() {
		return String.format( "(%d, %d)", getX(), getY() );
	}

	public abstract String getName(); 
	
}
