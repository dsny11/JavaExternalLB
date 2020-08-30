package employee;

// Introduction:Classes,Objects,Methods and Strings - No.1
public class Employee {

	private String firstname;
	
	private String lastname;
	
	private double salary;
	
	public Employee(String firstName, String lastName, double salary) {
		setFirstname(firstName);
		setLastname(lastName);
		if (salary>=0) {
			setMonthlySalary(salary);	
		}		
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getMonthlySalary() {
		return salary;
	}

	public void setMonthlySalary(double salary) {
		this.salary = salary;
	}
	
	public double getYearlySalary() {
		return salary*12;
	}
	
	public void setHikePerMonth(double percentage) {
		if (percentage>=0) {
			this.salary = (this.salary)+((percentage/100)*(this.salary));	
		}
		
	}

	public static void main(String[] args) {
		// Creating Object References for Employee One and Two
		Employee employeeOne = new Employee("Antony", "Marshal",50000);
		Employee employeeTwo = new Employee("Pavithra", "Ashok",60000);
		
		//Printing Salary before Hike
		System.out.println("Before Hike:");
		System.out.println("Yearly Salary of "+employeeOne.getFirstname()+" "+employeeOne.getYearlySalary());
		System.out.println("Yearly Salary of "+employeeTwo.getFirstname()+" "+employeeTwo.getYearlySalary());
		
		//Setting Salary Hike in percentage
		employeeOne.setHikePerMonth(10);
		employeeTwo.setHikePerMonth(10);
		
		//Printing Salary after Hike
		System.out.println("----------------------------");
		System.out.println("After Hike:");
		System.out.println("Yearly Salary of "+employeeOne.getFirstname()+" "+employeeOne.getYearlySalary());
		System.out.println("Yearly Salary of "+employeeTwo.getFirstname()+" "+employeeTwo.getYearlySalary());
	}
}
