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

	// @Autowired
	SqlSession session;

	public EmpDAO(SqlSession session) { // autowired랑 같은 효과
		this.session = session;
	}

	// 직원 정보를 전달받아서 테이블에 저장한다.
	public boolean insertEmp(Emp emp) {
		return false;
	}

	// 성, 명을 전달받아서 그 이름에 해당하는 사원정보를 리턴함
	public List<Emp> getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp emp = new Emp();
		emp.lastName = lastName;
		emp.firstName = firstName;
		return session.selectList("getEmpByFirstNLastName", emp);
	}

	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return session.selectList("getEmpListByDeptId", deptNo);
	}

	public List<Emp> getEmpListByJobId(String jobId) throws Exception {
		return session.selectList("getEmpListByJobId", jobId);
	}
}
