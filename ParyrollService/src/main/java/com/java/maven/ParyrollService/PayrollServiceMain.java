package com.java.maven.ParyrollService;

import java.util.Scanner;

public class PayrollServiceMain
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println( "Welcome to Employee Payroll Service!" );
        PayrollService service = new PayrollService();
    	service.getEmpData();
    	System.out.println("Enter Employee ID:");
    	int emp_id=sc.nextInt();
    	System.out.println("Enter The Basic Pay:");
    	double basic_pay=sc.nextDouble();
    	service.updateSalary(emp_id, basic_pay);

    }
}
