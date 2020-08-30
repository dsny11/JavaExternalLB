package grossPay;

import java.util.Scanner;

public class GrossPay {
	//Control Statements Part-I - No.2
	private String employeeName;
	
	private double workHours;
	
	private double ratePerHour;
	
	private double grossPay;
	
	public GrossPay(String employeeName, double workHours, double ratePerHour) {
		setEmployeeName(employeeName);
		setWorkHours(workHours);
		setRatePerHour(ratePerHour);
		setGrosspay();
	}
	

	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public double getWorkHours() {
		return workHours;
	}



	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}



	public double getRatePerHour() {
		return ratePerHour;
	}



	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}
	
	public double setGrosspay() {		
		double extraHours = 0;
		if(this.workHours<=40) {
			grossPay = this.workHours * this.ratePerHour;
		}
		else {
			extraHours = this.workHours - 40;
			grossPay = (40 * this.ratePerHour)+(extraHours *(this.ratePerHour/2));
		}
		return grossPay;
	}
	
	public double getGrosspay() {
		return grossPay;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String employeeName;
		double workHours;		
		double ratePerHour;
		for (int i=1;i<=3;i++) {	
		Scanner s  = new Scanner(System.in);
		System.out.println("Enter Employee #"+i+" Name") ;
		employeeName = s.next();
		System.out.println("Enter 'No of hours' "+employeeName + " worked: ");
		workHours = s.nextDouble();
		System.out.println("Enter Hourly Rate for "+employeeName +" :");
		ratePerHour = s.nextDouble();		
		GrossPay grosspay = new GrossPay(employeeName,workHours,ratePerHour);
		System.out.println("Calculated GrossPay for "+employeeName +" :"+grosspay.getGrosspay());
		System.out.println("-------------------------------------");
		}
		System.out.println("End of Execution");
	} 
}
