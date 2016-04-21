package data;

public class Test {
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDBDao();
		Employee emp = empDao.getEmployeeById(1135);
		System.out.println(emp);
	}
}
