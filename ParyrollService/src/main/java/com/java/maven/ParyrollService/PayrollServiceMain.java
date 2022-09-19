package com.java.maven.ParyrollService;

import java.util.Scanner;

public class PayrollServiceMain {
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Employee Payroll Service!");
		PayrollService service = new PayrollService();
		while (true) {
			System.out.println(" 1.Read Employee Data");
			System.out.println(" 2.Update EmployeeSalary");
			System.out.println(" 3.Update EmployeeSalary using prepared Statement");
			input = sc.nextInt();
			switch (input) {
			case 1:
				service.getEmpData();
				break;

			case 2: {
				System.out.println("Enter Employee ID:");
				int emp_id = sc.nextInt();
				System.out.println("Enter The Basic Pay:");
				double basic_pay = sc.nextDouble();
				service.updateSalary(emp_id, basic_pay);
				break;
			}
			case 3: {
				System.out.println("Enter Employee ID:");
				int emp_id = sc.nextInt();
				System.out.println("Enter The Basic Pay:");
				double basic_pay = sc.nextDouble();
				service.updateSalaryPs(emp_id, basic_pay);
				break;
			}
			default: {
				System.out.println("Invalid Input");
			}
			}

		}

	}
}
