package payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payroll {

	private String employeeName;
	
	private double salary;
	
	private Date dateOfBirth;
	
	private Payroll(String employeeName, double salary, String dateOfBirth) throws ParseException {
		setEmployeeName(employeeName); 
		setSalary(salary);
		setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth));		
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public double getSalary() {
		if(this.dateOfBirth.getMonth()==new Date().getMonth()) {
			this.salary = this.salary + 100;
		}
		else {
			
		}
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Date getDateOfBirth() {
		printBirthdayMessage();
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public boolean isBirthDayMonth() {
		return this.dateOfBirth.getMonth()==new Date().getMonth();
	}
	
	public void printBirthdayMessage() {
		if(isBirthDayMonth()) {
			System.out.println("Yay - This is Birthday Month!");
		}
	}


	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Payroll payrollOne = new Payroll("Antony",10000,"28/11/1989");
		System.out.println("Employee Name :" + payrollOne.getEmployeeName());
		System.out.println("Salary :" + payrollOne.getSalary());
		System.out.println("DOB :" + payrollOne.getDateOfBirth());
		System.out.println("---------------------------------------");
		Payroll payrollTwo = new Payroll("Tom",15000,"01/08/1992");
		System.out.println("Employee Name :" + payrollTwo.getEmployeeName());
		System.out.println("Salary :" + payrollTwo.getSalary());
		System.out.println("DOB :" + payrollTwo.getDateOfBirth());		
	}

}
