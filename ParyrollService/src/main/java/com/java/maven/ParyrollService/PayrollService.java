package com.java.maven.ParyrollService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class PayrollService {
	Connection con;
	SqlQueries sql;

	public void resetConnection() {
		con = DbConnection.init().getConnection();
		sql = new SqlQueries();
	}

	/**
	 * Retrieve EmployeePayroll from payrollService Database
	 */
	public void getEmpData() {
		resetConnection();
		System.out.println("-------------------Employee Data-------------------------");
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql.SELECT_EMP_DATA);
			System.out.println("empId" + "\t" + "empName" + "\t" + "joinDate" + "\t" + "gender");
			while (rs.next()) {
				int empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				LocalDate joinDate = rs.getDate("join_date").toLocalDate();
				String gender = rs.getString("gender");

				System.out.println(empId + "\t" + empName + "\t" + joinDate + "\t" + gender);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update the Employee Payroll Salary
	 */
	public void updateSalary(int emp_id, double basic_pay) {
		resetConnection();
		try {
			con = DbConnection.init().getConnection();
			Statement st = con.createStatement();
			double deduction = basic_pay * 0.10;
			double taxable_pay = basic_pay - deduction;
			double tax = taxable_pay * 0.20;
			double net_pay = taxable_pay - tax;
			int isUpdated = st.executeUpdate("update payroll_tbl set basic_pay = " + basic_pay + ", deduction = "
					+ deduction + ", taxable_pay = " + taxable_pay + "" + ", tax = " + tax + ", net_pay = " + net_pay
					+ " where emp_id = " + emp_id);

			if (isUpdated == 1) {
				System.out.println("Data is updated successfully");
			} else {
				System.out.println("Something went wrong while updating the data.");
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
