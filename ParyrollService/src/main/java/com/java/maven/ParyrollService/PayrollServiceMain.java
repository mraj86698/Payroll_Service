package com.java.maven.ParyrollService;

import java.util.Scanner;

public class PayrollServiceMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PayrollService service = new PayrollService();

		int choice=0;
		while (choice != 9) {
			System.out.println();
			System.out.println("Welcome to Employee Payroll Service!");
			System.out.println(" 1.Read Employee Data");
			System.out.println(" 2.Update Employeebasic_pay");
			System.out.println(" 3.Update Employeebasic_pay using prepared Statement");
			System.out.println(" 4.Show PayrollData");
			System.out.println(" 5.Retrieve employees for particular date range");
			System.out.println(" 6.Aggregate Function");
			System.out.println(" 7.Add Employee Details");
			System.out.println(" 8.Show Department Details");
			System.out.println(" 9.EmployeeDepartmentPayrollData");
			System.out.println("10.exit");

			int input = sc.nextInt();
			switch (input) {
			case 1:
				service.getEmpData();
				break;

			case 2: {
				System.out.println("Enter Employee ID:");
				int emp_id = sc.nextInt();
				System.out.println("Enter The Basic Pay:");
				double basic_pay = sc.nextDouble();
				service.updatebasic_pay(emp_id, basic_pay);
				break;
			}
			case 3: {
				System.out.println("Enter Employee ID:");
				int emp_id = sc.nextInt();
				System.out.println("Enter The Basic Pay:");
				double basic_pay = sc.nextDouble();
				service.updatebasic_payPs(emp_id, basic_pay);
				break;
			}
			case 4:
				service.showPayrollData();
				break;
			case 5:
				service.getEmpDataByJoinDate("2018-01-01", "2018-12-31");
				break;
			case 6:
				service.aggregate();
				break;
			case 7:
				service.addEmpData();
				break;
			case 8:
				service.showDepartmentDetails();
				break;
			case 9:
				service.showEmpDeptPayrollData();
				break;
			case 10: {
				System.out.println("Thank you for using the application");
				break;
			}

			default: {
				System.out.println("Invalid Input");
			}
			}

		}

	}
}
