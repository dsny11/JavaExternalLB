package employee;

import java.util.Scanner;

public class TestEmployeeData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bFull=true;
		String option="";
		double percentage=0;
		String employeeType = "";
		Scanner s = new Scanner(System.in);
		EmployeeInfo employeeInfo = new EmployeeInfo();
		EmployeeDB employeeDB = new EmployeeDB();
		double salesThrehold = 0;
		while (bFull) {
			System.out.println("--Employee PayRoll Management--");
			System.out.println("Enter 1 to Add Increment to Salary based on EmployeeType");
			System.out.println("Enter 2 to Process Salary");
			System.out.println("Enter 3 to Process Bonus based on EmployeeType and Sales");
			System.out.println("Enter 4 to Process Bonus based on Employee DOB");	
			System.out.println("Enter 5 to View Salary");	
			option = s.next();
			switch(option) {
			case "1" :
				System.out.println("Choose an EmployeeType from below");
				System.out.println("Enter 1 to Choose FixedCommission");
				System.out.println("Enter 2 to Choose BasePlusCommision");
				System.out.println("Enter 3 to Choose TieredCommision");
				System.out.println("Enter 4 to Choose RevenueCommision");
				System.out.println("Enter 5 to Choose GrossMarginCommission");
				employeeType =getEmployeeType(s.nextInt()) ;				
				System.out.println("Enter increment percentage");
				percentage = s.nextDouble();
				EmployeeDB.addSalaryRaise(employeeType, percentage);				
				break;
			case "2" :				
				EmployeeDB.processSalary();
				break;
			case "3":
				System.out.println("Choose an EmployeeType from below");
				System.out.println("Enter 1 to Choose FixedCommission");
				System.out.println("Enter 2 to Choose BasePlusCommision");
				System.out.println("Enter 3 to Choose TieredCommision");
				System.out.println("Enter 4 to Choose RevenueCommision");
				System.out.println("Enter 5 to Choose GrossMarginCommission");
				employeeType = getEmployeeType(s.nextInt());
				System.out.println("Enter Sales Threhold : ");
				salesThrehold = s.nextDouble();		
				EmployeeDB.processSalary();
				EmployeeDB.processTypeAndSalesBonus(employeeType, salesThrehold);
				break;
			case "4":
				EmployeeDB.processSalary();
				EmployeeDB.processDOBBonus();
				
				break;
			case "5":
				EmployeeDB.viewMonthlySalary();
				break;
			}
				
		}
	}
	
	private static String getEmployeeType(int option) {
		String result = "";
		switch (option) {
		case 1 : 
			result = "FixedCommission";
			break;		
		case 2 : 
			result = "BasePlusCommision";
			break;
		case 3 : 
			result = "TieredCommision";
			break;
		case 4 : 
			result = "RevenueCommision";
			break;
		case 5 : 
			result = "GrossMarginCommission";
			break;
		}
		return result;
		
	}

}
