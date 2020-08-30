package employee;

public class EmployeeInfo {

	private String employeeUID;
	private String name;
	private String employeeType;
	private Sales sales;
	private double salary;	
	
	public String getEmployeeUID() {
		return employeeUID;
	}
	public void setEmployeeUID(String employeeUID) {
		this.employeeUID = employeeUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
