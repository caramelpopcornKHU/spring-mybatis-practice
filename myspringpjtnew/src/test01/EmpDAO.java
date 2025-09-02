package test01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpDAO {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSession session;
	
	public List<Emp> findEmpByYear(int year) throws Exception {
		return session.selectList("findEmpByYear", year);
	}
	public List<Emp> findEmpByDeptId(int deptId) throws Exception {
		return session.selectList("findEmpByDeptId", deptId);
	}
	public void printStat() throws Exception {
		
	}
	public List<Emp> findEmpByManagerName() throws Exception {
		System.out.println("부서장 목록");
		System.out.println("Steven King, Alexander Hunold, Nancy Greenberg, Den Raphaely, Adam Fripp, John Russell");
		System.out.println("Jennifer Whalen, Michael Hartstein, Susan Mavris, Hermann Baer, Shelley Higgins");
		Scanner scan = new Scanner(System.in);
		String chooser;
		String name;
		System.out.print("1: first_name, 2: last_name, 3: full_name  -> ");chooser = scan.next();
		
		Map<String, String> map = new HashMap<>();
		
		map.put("managerFirstName", "");
		map.put("managerLastName", "");
		map.put("managerFullName", "");
		
		System.out.print("이름 입력: "); name = scan.next();
		
		switch(chooser) {
		case "1":
			map.put("managerFirstName", name);
			break;
		case "2":
			map.put("managerLastName", name);
			break;
		case "3":
			map.put("managerFullName", name);
			break;
		}
		
		return session.selectList("findEmpByManagerName", map);
	}
	
	public List<Emp> findByCity(String city) throws Exception{
		ArrayList<Emp> result = new ArrayList<>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		String sql = "select employee_id, department_id, first_name, last_name, DATE_FORMAT(hire_date, '%Y-%m-%d') hd, email, salary, email from EMPLOYEES where DEPARTMENT_ID "
				+ "in (select DEPARTMENT_ID from DEPARTMENTS where LOCATION_ID = "
				+ "(select LOCATION_ID from LOCATIONS where lower(city) ='"+city+"'))";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Emp emp = new Emp();
			emp.empId = rs.getInt("employee_id");
			emp.deptId = rs.getInt("department_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.hireDate = rs.getString("hd");
			emp.salary = rs.getInt("salary");
			emp.email = rs.getString("email");
			result.add(emp);
		}
		connection.close();
		return result;
	}
	public List<Emp> findEmpByName(String firstName) throws Exception {
		ArrayList<Emp> result = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = connection.createStatement();
		
		// 이름을 입력하고 그 이름에 해당하는 사원의 정보를 불러오는 sql 쿼리 문장을 넣어줌
		String sql = "select employee_id, department_id, first_name, last_name, DATE_FORMAT(hire_date, '%Y-%m-%d') hd, email, salary, email "
				      + "from employees "
				      + "where lower(first_name) ='" + firstName.toLowerCase()+"'";   
		ResultSet rs = stmt.executeQuery(sql);  // 
		while(rs.next()) {
			Emp tempEmp = new Emp();
			tempEmp.empId=rs.getInt("employee_id");
			tempEmp.deptId=rs.getInt("department_id");
			tempEmp.firstName=rs.getString("first_name");
			tempEmp.lastName=rs.getString("last_name");
			tempEmp.hireDate=rs.getString("hd");
			tempEmp.salary=rs.getInt("salary");
			tempEmp.email=rs.getString("email");
			result.add(tempEmp);
		}
		
		connection.close();
		return result;
	}

}
