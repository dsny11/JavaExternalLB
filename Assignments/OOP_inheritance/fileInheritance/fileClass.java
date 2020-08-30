package fileInheritance;

public class fileClass extends binaryClass {
	
	private String fileType;
	
	private String encodingType;
	
	private String extensionType;
	
	protected void read() {
		System.out.println("Reading file...");
	}
	
	protected void write() {
		System.out.println("Writing file...");
	}
	
}
