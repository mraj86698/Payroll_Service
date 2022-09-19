package com.java.maven.ParyrollService;

public class PayrollServiceMain
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Employee Payroll Service!" );
        PayrollService service = new PayrollService();
    	service.getEmpData();

    }
}
