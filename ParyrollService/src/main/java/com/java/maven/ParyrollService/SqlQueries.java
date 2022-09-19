package com.java.maven.ParyrollService;

public class SqlQueries {

	public final String SELECT_EMP_DATA = "SELECT emp_id,emp_name,join_date,gender FROM employee_tbl";
	public final String UPDATE_SALARY = "update payroll_tbl set basic_pay = ? "
			+ ", deduction = ?, taxable_pay = ?, tax = ?, net_pay = ? "+ "where emp_id = ?";
	public final String SELECT_EMP_PAYROLL_DATA = "select e.emp_id, emp_name, p.* from "
			+ "employee_tbl e, payroll_tbl p where e.emp_id = p.emp_id";


}
