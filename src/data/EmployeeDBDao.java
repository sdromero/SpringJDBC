package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDBDao implements EmployeeDao{
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/companydb";
	@Override
	public Employee getEmployeeById(int id) {
		Connection conn = null;
		Employee emp = null;
	    String selectById = "select id, firstname, lastname from employees where id = " + id;

		try {
			Class.forName(DRIVER_CLASS_NAME);
			conn = DriverManager.getConnection(URL, "student", "student");
		    Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(selectById);

			if (rs.next()) {
				int i = rs.getInt(1);
				String fn  = rs.getString(2);
				String ln = rs.getString(3);
				
				emp = new Employee(i, fn, ln);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emp;
	}

}
