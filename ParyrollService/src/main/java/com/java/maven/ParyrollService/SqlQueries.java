package com.java.maven.ParyrollService;

public class SqlQueries {

	public final String SELECT_EMP_DATA = "SELECT emp_id,emp_name,join_date,gender FROM employee_tbl";
	public final String UPDATE_basic_pay = "update payroll_tbl set basic_pay = ? "
			+ ", deduction = ?, taxable_pay = ?, tax = ?, net_pay = ? "+ "where emp_id = ?";
	public final String SELECT_EMP_PAYROLL_DATA = "select e.emp_id, emp_name, p.* from "
			+ "employee_tbl e, payroll_tbl p where e.emp_id = p.emp_id";
	public final String SELECT_EMP_DATA_BY_JOIN_DATE = "select * from employee_tbl where join_date between CAST(? AS DATE) AND CAST(? AS DATE)";
	public final String count="select count(gender) from employee_tbl where gender= 'M' group by gender";
	public final String sum="SELECT SUM(BASIC_PAY) FROM employee_tbl e JOIN payroll_tbl p ON e.EMP_ID = p.EMP_ID WHERE e.GENDER = 'M' ";
	public final String avg="SELECT AVG(BASIC_PAY) FROM employee_tbl e JOIN payroll_tbl p ON e.EMP_ID = p.EMP_ID WHERE e.GENDER = 'M' ";
	public final String min="SELECT Min(BASIC_PAY) FROM employee_tbl e JOIN payroll_tbl p ON e.EMP_ID = p.EMP_ID WHERE e.GENDER = 'M' ";
	public final String max="SELECT Max(BASIC_PAY) FROM employee_tbl e JOIN payroll_tbl p ON e.EMP_ID = p.EMP_ID WHERE e.GENDER = 'M' ";
	public final String INSERT_EMP_DATA = "insert into employee_tbl (emp_name,join_date,gender)"
			+ " value (?,?,?)";

	public final String SELECT_DEPT_DATA = "select * from department_tbl";
	public final String INSERT_EMP_DEPT_DATA = "insert into employee_dept_tbl "
			+ "(emp_id, dept_id) value(?,?);";

	public final String INSERT_EMP_PAYROLL_DATA = "insert into payroll_tbl "
			+ "(basic_pay, deduction, taxable_pay, tax, net_pay,emp_id) "
			+ "values (?, ?, ?, ?, ?, ?)";

	public final String SELECT_EMP_DEPT_PAYROLL_DATA = "select e.emp_id, emp_name, p.basic_pay ,d.dept_name from "
			+ "employee_tbl e, payroll_tbl p, department_tbl d, employee_dept_tbl ed "
			+ "where e.emp_id = p.emp_id and e.emp_id = ed.emp_id and d.dept_id = ed.dept_id";



}
