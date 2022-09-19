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
	 * Retrieve  EmployeePayroll from payrollService Database
	 */
	public void getEmpData() {
		resetConnection();
		System.out.println(
				"-------------------Employee Data-------------------------");
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql.SELECT_EMP_DATA);
			System.out.println("empId"+"\t"+"empName"+"\t"+"salary"+"\t"+"joinDate"+"\t"+"gender");
			while (rs.next()) {
				int empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				double salary = rs.getDouble("salary");
				LocalDate joinDate = rs.getDate("join_date").toLocalDate();
				String gender=rs.getString("gender");

				System.out.println(empId+"\t"+empName+"\t"+salary+"\t"+joinDate+"\t"+gender);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
