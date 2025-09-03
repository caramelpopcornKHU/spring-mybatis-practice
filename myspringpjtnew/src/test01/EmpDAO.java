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
		scan.nextLine();
		Map<String, String> map = new HashMap<>();
		
		
		System.out.print("이름 입력: "); name = scan.nextLine();
		
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
		return session.selectList("findByCity", city);
	}
	public List<Emp> findEmpByName() throws Exception {
		Scanner scan = new Scanner(System.in);
		String chooser;
		String name;
		System.out.print("1: first_name, 2: last_name, 3: full_name  -> ");chooser = scan.next();
		scan.nextLine();
		Map<String, String> map = new HashMap<>();
		
		
		System.out.print("이름 입력: "); name = scan.nextLine();
		
		switch(chooser) {
	    case "1":
	        map.put("firstName", name);
	        break;
	    case "2":
	        map.put("lastName", name);
	        break;
	    case "3":
	        map.put("fullName", name);
	        break;
	    }
		
		return session.selectList("findEmpByName", map);
	}

}
