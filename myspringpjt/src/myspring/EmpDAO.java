package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public class EmpDAO {

	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSession session;

	// 직원 정보를 전달받아서 테이블에 저장한다.
	public boolean insertEmp(Emp emp) {
		return false;
	}

	// 성, 명을 전달받아서 그 이름에 해당하는 사원정보를 리턴함
	public Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp emp = new Emp();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where first_name = ? and last_name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
		}
		return emp;
	}

	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return session.selectList("getEmpListByDeptId", deptNo);
		
	}

	public List<Emp> getEmpListByJobId(String jobId) throws Exception {
		return session.selectList("getEmpListByJobId", jobId);
	}
	

}
