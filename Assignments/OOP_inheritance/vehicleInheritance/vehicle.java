package vehicleInheritance;

public class vehicle {
	
	private String engineType;
	
	private String fuelType;
	
	private String vehicleType;
	
	protected void run() {
		System.out.println("Engine is running!");
	}
	
	protected void start() {
		System.out.println("Engine is started!");
	}
	
	protected void stop() {
		System.out.println("Engine is stopped!");
	}
	
	protected void idle() {
		System.out.println("Engine is idle!");
	}

}
