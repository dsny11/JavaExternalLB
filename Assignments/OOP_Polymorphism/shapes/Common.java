package shapes;

public class Common {

	public static void main( String args[] ) {
		
	Shape shapes[] = new Shape[ 2 ];
	shapes[ 0 ] = new Circle( 22, 88, 4 );
	shapes[ 1 ] = new Sphere( 8, 89, 2 );	
	
		for ( Shape currentShape : shapes )	{
			//System.out.printf( "%s: ",currentShape.getName() );
			if ( currentShape instanceof TwoDimensionalShape )	{
				TwoDimensionalShape twoDimensionalShape = 	( TwoDimensionalShape ) currentShape;
				System.out.printf( "%s's area is %s\n", currentShape.getName(), twoDimensionalShape.getArea() );
			} 
			if ( currentShape instanceof ThreeDimensionalShape ) {
				ThreeDimensionalShape threeDimensionalShape = 	( ThreeDimensionalShape) currentShape;
				System.out.printf( "%s's area is %s\n", currentShape.getName(), threeDimensionalShape.getArea() );
				System.out.println();
				System.out.printf( "%s's volume is %s\n", currentShape.getName(), threeDimensionalShape.getVolume() );
			}	
			System.out.println();
		}
	} 
}
